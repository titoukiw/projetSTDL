package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
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








