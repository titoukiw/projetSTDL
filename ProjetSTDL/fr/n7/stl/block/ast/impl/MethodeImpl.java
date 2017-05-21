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
	private Bloc body;
	private DroitAcces droit;
	private boolean statique;
	private Type returnType;
	private String classeCourante;

	public ConstructeurImpl(String id, DroitAcces droit, LinkedList<Parametre> listParam,
							Bloc body, Boolean statique, Type returnType, String classeCourante){
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

}


