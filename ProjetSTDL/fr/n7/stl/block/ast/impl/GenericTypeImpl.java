package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Type;


public class GenericTypeImpl implements Type {

	private Objet objet;
	private LinkedList<Type> instGens;

	public GenericTypeImpl(Objet objet, LinkedList<Type> instGens){
		this.objet = objet;
		this.instGens = instGens;
	}

	public GenericTypeImpl(Objet objet){
		this.objet = objet;
	}

	@Override
	public boolean equalsTo(Type _other) {
		return true;
	}

	@Override
	public boolean compatibleWith(Type _other) {
		return true;
	}

	@Override
	public Type merge(Type _other) {
		return null;
	}

	@Override
	public int length() {
		return 99;
	}
}