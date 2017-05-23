package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
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
	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

	public String getClasseCourante(){
		return this.classeCourante;
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
		if(this.id == meth.getName() && this.classeCourante == meth.getClasseCourante() 
									 && this.listParam.size() == meth.getParametres().size()){
			for(int i=0;i<this.listParam.size();i++){
				if(!this.listParam.get(i).getType().equals(meth.getParametres().get(i).getType())){
					return false;
				}
			}
		}
		return true;
	}

	public String getName(){
		return this.id;
	}

}


