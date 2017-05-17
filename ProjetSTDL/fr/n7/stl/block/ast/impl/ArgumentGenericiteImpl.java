package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;


/* Cette classe est un peu chelou */
public class ArgumentGenericiteImpl implements ArgumentGenericite {
	private Objet obj;
	private LinkedList<Type> argType;

	public ArgumentGenericiteImpl(Objet obj){
		this.obj = obj;
	}

	public ArgumentGenericiteImpl(Objet obj, LinkedList<Type> argType){
		this.obj = obj;
		this.argType = argType;
	}

	public String toString() {
		String toString = "(ArgumentGenericite " + this.obj.getName();
		for(Type type : argType){
			toString += " ," +type.toString();
		}
		return toString + " )";
	}

	// ArgumentGenericite extends Type oblige:

	/* does not @Override ?!*/
	public int length(){
		return 99;
	}

	/* does not @Override ?!*/
	public boolean equalsTo(Type type){
		return true;
	}

	/* does not @Override ?!*/
	public boolean compatibleWith(Type type) {
		return true;
	}

	/* does not @Override ?!*/
	public Type merge(Type type){
		return null;
	}
}