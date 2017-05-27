package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;
import java.util.ListIterator;
public class MethodeImpl implements Methode {

	private String id;
	private LinkedList<Parametre> listParam;
	private Block body;
	private DroitAcces droit;
	private boolean statique;
	private Type returnType;
	private int paramSize;
	private String label;
	private String classeCourante;

	public MethodeImpl(String id, String classeCourante, DroitAcces droit, LinkedList<Parametre> listParam,
							Block body, boolean statique, Type returnType){
		this.id = id;
		this.droit = droit;
		this.listParam = listParam;
		this.body = body;
		this.statique = statique;
		this.returnType = returnType;
		this.classeCourante = classeCourante;
	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

	public String getClasseCourante(){
		return this.classeCourante;
	}

	public Type getType(){
		return this.returnType;
	}




	public ElementClasse makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		

		LinkedList<Parametre> declaredParams = new LinkedList<Parametre>();
		Parametre declaredParam;
		Block declaredBody;

		for(Parametre param : this.listParam){
			declaredParam = param.makeLiaisonTardive(classes,interfaces);
			if(declaredParam == null){
				throw new SemanticsUndefinedException("Cannot declare " + param);
			}
			declaredParams.add(declaredParam);
		}


		declaredBody = body.makeLiaisonTardive(classes,interfaces);
		if(declaredBody == null){
			throw new SemanticsUndefinedException("Cannot declare body of " + this.id );
		}


		if(this.returnType instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.returnType).getName())){
					return new MethodeImpl(this.id,this.classeCourante,this.droit,declaredParams,declaredBody,this.statique,
											new ClasseTypeImpl(classe));
				}
			}
			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.returnType).getName())){
					return new MethodeImpl(this.id,this.classeCourante,this.droit,declaredParams,declaredBody,this.statique,
											new InterfaceTypeImpl(interf));
				}
			}
		}

		return new MethodeImpl(this.id,this.classeCourante,this.droit,declaredParams,declaredBody,this.statique,this.returnType);
}

	public String toString(){
		String toString = "(Methode) " + this.droit;
		if(this.statique){
			toString += " static";
		}
		toString += " " + this.returnType + " " + this.id + " (";
		for(Parametre param : this.listParam){
			toString += " " + param + ",";
		}
		toString += ")" + this.body ;
		return toString;
	}

	public boolean isEqual(Methode meth){
		if(this.id.equals(meth.getName()) && this.classeCourante.equals(meth.getClasseCourante()) 
									 && this.listParam.size() == meth.getParametres().size()){
			for(int i=0;i<this.listParam.size();i++){
				if(!this.listParam.get(i).getType().equals(meth.getParametres().get(i).getType())){
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public String getName(){
		return this.id;
	}

	public int length(){
		return 0; //?
	}

	public int allocateMemory(Register _register, int _offset){
		int local_offset = - 1;//dernier parametre est @ST-1 
		LinkedList tmpParam = new LinkedList<Parametre>(listParam);
		ListIterator li = tmpParam.listIterator(tmpParam.size());
		while(li.hasPrevious()){
			local_offset -= ((Parametre)li.previous()).allocateMemory(Register.ST,local_offset);//Les parametres sont push lors de l'appel, ils sont donc en dessous de ST
		}
		this.paramSize = -local_offset;
		this.body.allocateMemory(_register,_offset);
		return 0;

	}

	public Fragment getCode(TAMFactory factory){
		Fragment code = factory.createFragment();
		code.append(body.getCode(factory));
		code.add(factory.createReturn(returnType.length(),this.paramSize));
		this.label = this.id + factory.createLabelNumber();
		code.addPrefix( this.label + ":");
		return code;

	}

	@Override
	public boolean checkType() {
		return body.checkType();
	}


}


