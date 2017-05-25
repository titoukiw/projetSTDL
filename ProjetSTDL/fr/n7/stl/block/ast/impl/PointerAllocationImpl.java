package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;


/**
 *Implemention of the Abstract Syntax Tree node for an array allocation.
 *@author Titouan Tanguy
 *
 */
public class PointerAllocationImpl implements Expression {

	protected Type 		 type;

	/**
	 *Construction for the implementation of a pointer allocation.
	 * @param _type
	 */
	public PointerAllocationImpl(Type _type) {
			this.type = _type;
	}

	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		


		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new PointerAllocationImpl(new ClasseTypeImpl(classe));
				}
			}
			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new PointerAllocationImpl(new InterfaceTypeImpl(interf));
				}
			}
			return null;
		}
		return this;
	}
	


	public Type getType(){
		return new PointerTypeImpl(this.type);
	}

	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = _factory.createFragment();
		_fragment.add(_factory.createLoadL(this.type.length()));
		_fragment.add(Library.MAlloc);
		return _fragment;
	}

}