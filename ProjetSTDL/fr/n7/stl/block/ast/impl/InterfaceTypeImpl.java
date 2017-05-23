package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.block.ast.*;


public class InterfaceTypeImpl implements Type {

	private Interface inter;

	public InterfaceTypeImpl(Interface inter) {
		this.inter = inter;
	}

	public boolean equalsTo(Type _other){
		if(_other instanceof InterfaceTypeImpl){
			return this.inter.equalsTo(((InterfaceTypeImpl) _other).inter);
		} else {
			return false;
		}
	}

	public boolean compatibleWith(Type _other){
		throw new SemanticsUndefinedException("compatibleWith() InterfaceTypeImpl");
	}

	public Type merge(Type _other){
				throw new SemanticsUndefinedException("merge() InterfaceTypeImpl");

	}

	public int length(){
				throw new SemanticsUndefinedException("length() InterfaceTypeImpl");

	}

	public String toString(){
		return this.inter.getName();
	}

}