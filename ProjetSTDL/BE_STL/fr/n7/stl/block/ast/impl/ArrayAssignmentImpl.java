/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Library;
/**
 * @author Marc Pantel
 *
 */
public class ArrayAssignmentImpl extends ArrayAccessImpl implements Assignable {

	/**
	 * Construction for the implementation of an array element assignment expression Abstract Syntax Tree node.
	 * @param _array Abstract Syntax Tree for the array part in an array element assignment expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element assignment expression.
	 */
	public ArrayAssignmentImpl(Expression _array, Expression _index) {
		super(_array, _index);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.ArrayAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = this.array.getCode(_factory);
		_fragment.append(this.index.getCode(_factory));
		_fragment.add(_factory.createLoadL(this.getType().length()));
		_fragment.add(Library.IMul);
		_fragment.add(Library.IAdd);
		return _fragment;
	}
	
}
