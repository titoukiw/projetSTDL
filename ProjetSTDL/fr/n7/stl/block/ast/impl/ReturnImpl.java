package fr.n7.stl.block.ast.impl;


import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class ReturnImpl implements Instruction {

	protected Expression expr;

	public ReturnImpl(Expression expr) {
		this.expr = expr;
	}

	@Override
	public String toString() {
		return "return " + this.expr;
	}

	public ReturnImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredExpr = this.expr.makeLiaisonTardive(classes,interfaces);
		if(declaredExpr == null){
			throw new SemanticsUndefinedException("cant declare " + this.expr);
		}

		return new ReturnImpl(declaredExpr);
	}


	@Override
	public boolean checkType() {
		throw new SemanticsUndefinedException ("checkType ReturnImpl");
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		throw new SemanticsUndefinedException ("allocateMemory ReturnImpl");
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException ("getCode ReturnImpl");
	}

}
