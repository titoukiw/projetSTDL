/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for an unary operation expression.
 * @author Marc Pantel
 *
 */
public class UnaryExpressionImpl implements Expression {

	private UnaryOperator operator;
	private Expression parameter;
	
	/**
	 * Builds a unary expression Abstract Syntax Tree node from the parameter sub-expression
	 * and the unary operation.
	 * @param _operator : Unary Operator.
	 * @param _parameter : Expression for the parameter.
	 */
	public UnaryExpressionImpl(UnaryOperator _operator, Expression _parameter) {
		this.operator = _operator;
		this.parameter = _parameter;
	}


	public UnaryExpressionImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces) {
		Expression declaredParameter = parameter.makeLiaisonTardive(classes,interfaces);
		if(declaredParameter == null){
			throw new SemanticsUndefinedException("cant declare " + this.parameter);
		}
		return new UnaryExpressionImpl(this.operator,declaredParameter);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + this.operator + " " + this.parameter + ")";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type resultType = this.parameter.getType();
		if (resultType.equals(AtomicType.ErrorType)) {
			return resultType;
		} else {
			switch (this.operator) {
				case Negate: {
					if (resultType.compatibleWith(AtomicType.BooleanType))  {
						return resultType;
					} else {
						Logger.warning("Type error in unary expression : Negate parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case Opposite: {
					if (resultType.compatibleWith(AtomicType.FloatingType)) {
						return resultType;
					} else {
						Logger.warning("Type error in unary expression : Opposite parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case First: {
					if (resultType instanceof CoupleType) {
						return ((CoupleType)resultType).getFirst();
					} else {
						Logger.warning("Type error in unary expression : First parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				case Second: {
					if (resultType instanceof CoupleType) {
						return ((CoupleType)resultType).getFirst();
					} else {
						Logger.warning("Type error in unary expression : Second parameter " + resultType);
						return AtomicType.ErrorType;
					}
				}
				default : return AtomicType.ErrorType;
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = this.parameter.getCode(_factory);
		
		if(this.operator == UnaryOperator.First) {
			_code.add(_factory.createPop(0,((CoupleTypeImpl)this.parameter.getType()).getFirst().length()));
		}
		if(this.operator == UnaryOperator.Second) {
			_code.add(_factory.createPop(((CoupleTypeImpl)this.parameter.getType()).getFirst().length(),((CoupleTypeImpl)this.parameter.getType()).getSecond().length()));
		}
		if(this.operator != UnaryOperator.First && this.operator != UnaryOperator.Second){
			_code.add(TAMFactory.createUnaryOperator(this.operator));
		}
		
		return _code;
	}

}
