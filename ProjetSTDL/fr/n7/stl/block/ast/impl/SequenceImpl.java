/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;

/**
 * Implementation of the Abstract Syntax Tree node for a sequence building expression.
 * @author Marc Pantel
 *
 */
public class SequenceImpl implements Sequence {

	private LinkedList<Expression> values;

	public SequenceImpl(Iterable<Expression> _values) {
		this();
		for (Expression _value : _values) {
			this.values.add(_value);
		}
	}

	public SequenceImpl() {
		this.values = new LinkedList<Expression>();
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Sequence#add(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public void add(Expression _value) {
		this.values.add(_value);
	}

	public SequenceImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		LinkedList<Expression> declaredValues = new LinkedList<Expression>();

		for(Expression value : values){
			declaredValues.add(value.makeLiaisonTardive(classes,interfaces));
		}

		return new SequenceImpl(declaredValues);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = "{ ";
		Iterator<Expression> _iter = this.values.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " ," + _iter.next();
			}
		}
		return _result + " }";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		SequenceTypeImpl _result = new SequenceTypeImpl();
		for (Expression _value : this.values) {
			_result.add(_value.getType());
		}
		return _result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = _factory.createFragment();
		for (Expression e : values) {
			_fragment.append(e.getCode(_factory));
		}
		return _fragment;
	}

}
