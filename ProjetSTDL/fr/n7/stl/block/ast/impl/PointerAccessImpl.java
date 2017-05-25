/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access expression.
 * @author Marc Pantel
 *
 */
public class PointerAccessImpl implements Expression {

	protected Expression pointer;
	
	/**
	 * Construction for the implementation of a pointer content access expression Abstract Syntax Tree node.
	 * @param _pointer Abstract Syntax Tree for the pointer expression in a pointer content access expression.
	 */
	public PointerAccessImpl(Expression _pointer) {
		this.pointer = _pointer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(*" + this.pointer + ")";
	}

	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new PointerAccessImpl(this.pointer.makeLiaisonTardive(classes,interfaces));
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
	        Type _elt = this.pointer.getType();
                if( _elt instanceof PointerTypeImpl) {
                    return ((PointerTypeImpl) _elt).getPointedType();
                } else {
                    System.out.println("erreur de type pointeur");
                    return AtomicType.ErrorType;
                }
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = this.pointer.getCode(_factory);
		_fragment.add(_factory.createLoadI(this.getType().length()));
		return _fragment;
	}

}
