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

	public Interface getInterface(){
		return this.inter;
	}
	
	public boolean compatibleWith(Type _other){
		boolean result;
		result = this.toString().equals(_other.toString());
		if (!result){
			for (Interface i : this.inter.getHeritage()){
				result = i.getType().compatibleWith(_other);
				if (result){
					return result;
				}
			}
		}
		return result;
	}

	public Type merge(Type _other){
				throw new SemanticsUndefinedException("merge() InterfaceTypeImpl");

	}

	public int length(){
		return 0;
	}

	public String toString(){
		return this.inter.getName();
	}

}