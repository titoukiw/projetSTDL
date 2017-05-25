package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.block.ast.*;


public class ClasseTypeImpl implements Type {


	private Classe classe;
	

	public ClasseTypeImpl(Classe classe){
		this.classe = classe;
	}

	public Classe getClasse() {
		return this.classe;
	}

	public boolean equalsTo(Type _other){
		if (_other instanceof ClasseTypeImpl){
			return this.classe.equalsTo(((ClasseTypeImpl) _other).getClasse());
		} else {
			return false;
		}
	}


	public boolean compatibleWith(Type _other){
		if (_other instanceof ClasseTypeImpl){
			return this.classe.getName().equals(((ClasseTypeImpl) _other).getClasse());
		} else {
			System.out.println(this.toString() + "||" + _other.toString() );
			return false;
		}
	}


	public Type merge(Type _other){
				throw new SemanticsUndefinedException("merge() ClasseTypeImpl");

	}

	public int length(){
				throw new SemanticsUndefinedException("length() ClasseTypeImpl");

	}

	public String toString(){
		return this.classe.getName();
	}
}