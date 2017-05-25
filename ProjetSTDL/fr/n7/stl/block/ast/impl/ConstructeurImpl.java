package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public class ConstructeurImpl implements Constructeur {

	private String id; //le même que la classe courante
	private LinkedList<Parametre> listParam;
	private Block body;
	private DroitAcces droit;
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

	public Fragment getCode(TAMFactory factory){
		throw new SemanticsUndefinedException("getCode AttributImpl");
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return body.checkType();
	}



}








