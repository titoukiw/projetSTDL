package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Library;



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