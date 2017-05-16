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
}