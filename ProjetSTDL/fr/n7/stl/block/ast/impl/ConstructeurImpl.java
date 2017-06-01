package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class ConstructeurImpl implements Constructeur {

	private String id; //le même que la classe courante
	private LinkedList<Parametre> listParam;
	private Block body;
	private DroitAcces droit;
	private int offset;
	private int paramSize;
	private String label;
	private String classeCourante;

	public ConstructeurImpl(String id, String classeCourante, DroitAcces droit, LinkedList<Parametre> listParam, Block body){
		this.id = id;
		this.droit = droit;
		this.listParam = listParam;
		this.body = body;
	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

	public String getClasseCourante(){
		return this.classeCourante;
	}

	public ElementClasse makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		LinkedList<Parametre> declaredListParam = new LinkedList<Parametre>();
		for (Parametre param : listParam){
			declaredListParam.add(((Parametre)param.makeLiaisonTardive(classes,interfaces)));
		}
		Block declaredBody = body.makeLiaisonTardive(classes,interfaces);
		this.listParam = declaredListParam;
		this.body = declaredBody;
		return this;
	}


	public String toString(){
		String toString = "(Constructeur)" + this.droit + " " + this.id + " (";
		for(Parametre param : this.listParam){
			toString += " " + param + ",";
		}
		toString += ")" + this.body ;
		return toString;
	}

	public Type getType()
	{
		throw new SemanticsUndefinedException("getType ConstructeurImpl");
	}

	public String getLabelIfEquals(LinkedList<Expression> listExprs){
		boolean local = true;
		if(listExprs.size() == listParam.size()){
			for(int i = 0; i < listParam.size();i++){
				local = local && listExprs.get(i).getType().compatibleWith(listParam.get(i).getType());
			}
		}

		if(local){
			return this.label;
		} else {
			return null;
		}
	}

	public boolean isEqual(Constructeur cons){
		if(this.id == cons.getName() && this.classeCourante == cons.getClasseCourante() 
									 && this.listParam.size() == cons.getParametres().size()){
			for(int i=0;i<this.listParam.size();i++){
				if(!this.listParam.get(i).getType().equals(cons.getParametres().get(i).getType())){
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
		return 0;
	}
	public String getLabel(){
		return this.label;
	}

	public Fragment getCode(TAMFactory factory){
		int offsetFunction = -0;
		Fragment code = factory.createFragment();
		for(Parametre p : this.listParam){
			offsetFunction -= p.getType().length();
		}
		code.add(factory.createLoad(Register.LB,offsetFunction-1,1));
		offsetFunction = -0;
		for(Parametre p: this.listParam){
			offsetFunction -= p.getType().length();
			code.add(factory.createLoad(Register.LB,offsetFunction,p.getType().length()));
		}
		code.append(body.getCode(factory));
		code.add(factory.createReturn(0,this.paramSize)); 
		this.label = this.id + factory.createLabelNumber();
		code.addPrefix( this.label + ":");
		return code;
	}

	@Override
	public boolean checkType() {
		boolean result;
		result = body.checkType();
		return result;
	}

	public int allocateMemory(Register register, int offset){
		int local_offset = -1;//dernier parametre est @ST-1 
		LinkedList tmpParam = new LinkedList<Parametre>(listParam);
		ListIterator li = tmpParam.listIterator(tmpParam.size());
		while(li.hasPrevious()){
			local_offset -= ((Parametre)li.previous()).allocateMemory(Register.ST,local_offset);//Les parametres sont push lors de l'appel, ils sont donc en dessous de ST
		}
		this.paramSize = -local_offset ;
		this.body.allocateMemory(register,offset);
		return 0;
	}



}








