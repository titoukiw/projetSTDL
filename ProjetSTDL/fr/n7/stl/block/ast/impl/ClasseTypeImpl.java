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
				LinkedList<Classe> thisHerit = this.classe.getHeritage();
				Classe thisCl;
				while( thisHerit.size() > 0 ){
					thisCl = thisHerit.get(0);
					result = thisCl.getName().equals(((ClasseTypeImpl) _other).getClasse().getName());
					if(result = true){
						return result;
					}
					thisHerit = thisCl.getHeritage();
				}
				return result;
			}
		} else if (_other instanceof InterfaceTypeImpl){

				for (Interface i: this.classe.getInterface()){
					if (i.getType().compatibleWith(_other)){
						result = true;
						return result;
					}
				}

				LinkedList<Classe> thisHerit = this.classe.getHeritage();
				Classe thisCl;
				while( thisHerit.size() > 0 ){
					thisCl = thisHerit.get(0);
					for (Interface i: thisCl.getInterface()){
						if (i.getType().compatibleWith(_other)){
							result = true;
							return result;
						}
					}
					thisHerit = thisCl.getHeritage();
				}
				return result;
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
		int l = 0; 
		for (ElementClasse elt : this.classe.getElements()){
			l += elt.length();
		}
		if (this.classe.getHeritage().size() > 0){
			l += this.classe.getHeritage().get(0).getType().length();
		}
		return l;
	}

	public String toString(){
		return this.classe.getName();
	}
}