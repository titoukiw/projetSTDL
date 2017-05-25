package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public class MethodeImpl implements Methode {

	private String id;
	private LinkedList<Parametre> listParam;
	private Block body;
	private DroitAcces droit;
	private boolean statique;
	private Type returnType;
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


	public Fragment getCode(TAMFactory factory){
		throw new SemanticsUndefinedException("getCode AttributImpl");
	}

	@Override
	public boolean checkType() {
		return body.checkType();
	}


}


