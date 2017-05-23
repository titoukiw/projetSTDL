package fr.n7.stl.block.ast.impl;


import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;

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
