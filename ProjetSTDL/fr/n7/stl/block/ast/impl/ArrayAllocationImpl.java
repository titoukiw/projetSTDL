package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;


/**
 *Implemention of the Abstract Syntax Tree node for an array allocation.
 *@author Titouan Tanguy
 *
 */
public class ArrayAllocationImpl implements Expression {

	protected Expression size;
	protected Type 		 type;

	/**
	 *Construction for the implementation of an array allocation.
	 * @param _type
	 * @param _size
	 */
	public ArrayAllocationImpl(Type _type, Expression _size) {
			this.size = _size;
			this.type = _type;
		}


	public ArrayAllocationImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredSize = size.makeLiaisonTardive(classes,interfaces);
		if(declaredSize == null){
			throw new SemanticsUndefinedException("cannot declare" + declaredSize);
		}
		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new ArrayAllocationImpl(new ClasseTypeImpl(classe), declaredSize);
				}
			}
			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new ArrayAllocationImpl(new InterfaceTypeImpl(interf), declaredSize);
				}
			}
			return null;
		}
		return new ArrayAllocationImpl(this.type,declaredSize);
	}


	public Type getType(){
		return new ArrayTypeImpl(this.type);
	}

	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = this.size.getCode(_factory);
		_fragment.add(_factory.createLoadL(this.type.length()));
		_fragment.add(Library.IMul);
		_fragment.add(Library.MAlloc);
		return _fragment;

	}

}