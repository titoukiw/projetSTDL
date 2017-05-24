package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;


public class ParametreUseImpl implements Expression {

	protected Parametre parametre;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public ParametreUseImpl(Parametre _parametre) {
		this.parametre = _parametre;
	}


	public Parametre getParametre() {
		return this.parametre;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("@(ParametreUse) {" + this.parametre.getName() + "}");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return parametre.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() ParametreUseImpl");
	}


}