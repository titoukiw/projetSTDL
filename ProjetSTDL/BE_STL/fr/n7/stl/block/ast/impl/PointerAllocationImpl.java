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
public class PointerAllocationImpl implements Expression {

	protected Type 		 type;

	/**
	 *Construction for the implementation of a pointer allocation.
	 * @param _type
	 */
	public PointerAllocationImpl(Type _type) {
			this.type = _type;
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