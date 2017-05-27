package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public class AttributImpl implements Attribut {

	private String id;
	private Type type;
	private DroitAcces droit;
	private boolean statique;
	private String classeCourante;

	public AttributImpl(String id, String classeCourante, Type type, DroitAcces droit, boolean statique){
		this.id = id;
		this.type = type;
		this.droit = droit;
		this.statique = statique;
		this.classeCourante = classeCourante;
	}

	public String getClasseCourante(){
		return this.classeCourante;
	}

	public Type getType(){
		return this.type;
	}

	public ElementClasse makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes) {
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new AttributImpl(this.id, this.classeCourante, new ClasseTypeImpl(classe), this.droit, this.statique);
				}
			}

			for (Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new AttributImpl(this.id, this.classeCourante, new InterfaceTypeImpl(interf), this.droit, this.statique);
				}
			}

			return null;
		}
		return this;
	}

	public String toString(){
		String toString = "(AttributImpl) "+ this.droit ;
		if (this.statique){
			toString += " static";
		}
		toString += " " + this.type + " " + this.id +";";
		return toString;
	}
	public String getName(){
		return this.id;
	}

	public boolean checkType(){
		return true;
	}

	public int length(){
		return this.type.length();
	}

	public Fragment getCode(TAMFactory factory){
		throw new SemanticsUndefinedException("getCode AttributImpl");
	}

}
