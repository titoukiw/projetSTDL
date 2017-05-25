/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;
/**
 * Implementation of the Abstract Syntax Tree node for accessing an array element.
 * @author Marc Pantel
 *
 */
public class ArrayAccessImpl implements Expression {

	protected Expression array;
	protected Expression index;

	/**
	 * Construction for the implementation of an array element access expression Abstract Syntax Tree node.
	 * @param _array Abstract Syntax Tree for the array part in an array element access expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element access expression.
	 */
	public ArrayAccessImpl(Expression _array, Expression _index) {
		this.array = _array;
		this.index = _index;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (this.array + "[ " + this.index + " ]");
	}

	public ArrayAccessImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new ArrayAccessImpl(array.makeLiaisonTardive(classes,interfaces),index.makeLiaisonTardive(classes,interfaces));
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
	        Type _elt1 = this.array.getType();
                Type _elt2 = this.index.getType();
                if(! _elt2.equalsTo(AtomicType.IntegerType)) {
                    System.out.println("index must be an integer");
                    return AtomicType.ErrorType;
                } else {
                    if(_elt1 instanceof ArrayTypeImpl) {
                        return ((ArrayTypeImpl) _elt1).getType();
                   } else {
                       System.out.println("not an array");
                       return AtomicType.ErrorType;
                   }
                }
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = this.array.getCode(_factory);
		_fragment.append(this.index.getCode(_factory));
		_fragment.add(_factory.createLoadL(this.getType().length()));
		_fragment.add(Library.IMul);
		_fragment.add(Library.IAdd);
		_fragment.add(_factory.createLoadI(this.getType().length()));
		return _fragment;


	}

}
