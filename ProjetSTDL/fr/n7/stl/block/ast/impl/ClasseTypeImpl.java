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
		boolean result = false;
		if (_other instanceof ClasseTypeImpl){
			if (this.classe.getName().equals(((ClasseTypeImpl) _other).getClasse().getName())){
				result = true;

			} else {
				Classe cl_other = ((ClasseTypeImpl) _other).getClasse().getHeritage();
				while( cl_other != null){
					result = this.classe.getName().equals(cl_other.getName());
					if(result = true){
						return result;
					}
					cl_other = cl_other.getHeritage();
				}
				return result;
			}
		} else {
			System.out.println(this.toString() + "||" + _other.toString() );
			return false;
		}
		return result;
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