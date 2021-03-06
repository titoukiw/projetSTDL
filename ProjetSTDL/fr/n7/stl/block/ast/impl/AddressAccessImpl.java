package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access expression.
 * @author Titouan Tanguy
 *
 */
public class AddressAccessImpl implements Expression {

	protected Expression address;
	
	/**
	 * Construction for the implementation of a pointer content access expression Abstract Syntax Tree node.
	 * @param _address Abstract Syntax Tree for the pointer expression in a pointer content access expression.
	 */
	public AddressAccessImpl(Expression _address) {
		this.address = address;
	}

	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new AddressAccessImpl(address.makeLiaisonTardive(classes,interfaces));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(@" + this.address + ")";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
	        throw new SemanticsUndefinedException("Semantics getType is not implemented in AddressAccessImpl.");       
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode is not implemented in AddressAccessImpl.");
	}

}
