/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.List;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a function call expression.
 * @author Marc Pantel
 *
 */
public class FunctionCallImpl implements FunctionCall {

	private Expression function;
	private List<Expression> parameters;

	public FunctionCallImpl(Expression _function) {
		this.function = _function;
	}

	@Override
	public String toString() {
		String _result = function + "( ";
		Iterator<Expression> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
		}
		while (_iter.hasNext()) {
			_result += " ," + _iter.next();
		}
		return  _result + ")";
	}

	public FunctionCallImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredFunction = function.makeLiaisonTardive(classes,interfaces);
		if(declaredFunction == null){
			throw new SemanticsUndefinedException("cant declare " + this.function);
		}
		LinkedList<Expression> declaredParameters = new LinkedList<Expression>();
		for(Expression expr : parameters){
			declaredParameters.add(expr.makeLiaisonTardive(classes,interfaces));
		}
		this.function = declaredFunction;
		this.parameters = declaredParameters;
		return this;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.FunctionCall#add(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public void add(Expression _parameter) {
		this.parameters.add(_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
	        return this.function.getType();
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException( "getCode is undefined in FunctionCallImpl.");
	}

}
