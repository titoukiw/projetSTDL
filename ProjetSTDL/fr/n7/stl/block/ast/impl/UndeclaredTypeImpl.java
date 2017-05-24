package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.*;


public class UndeclaredTypeImpl implements Type {

	private String nom;

	public UndeclaredTypeImpl(String nom){
		this.nom = nom;
	}

	public String getName(){
		return this.nom;
	}

	public boolean equalsTo(Type _other){
		throw new SemanticsUndefinedException("equalsTo no meaning for UndeclaredTypeImpl");
	}

	public boolean compatibleWith(Type _other){
		throw new SemanticsUndefinedException("equalsTo no meaning for UndeclaredTypeImpl");
	}
	
	
	public Type merge(Type _other){
		throw new SemanticsUndefinedException("merge no meaning for UndeclaredTypeImpl");
	}
	

	public int length(){
		throw new SemanticsUndefinedException("length no meaning for UndeclaredTypeImpl");
	}
}