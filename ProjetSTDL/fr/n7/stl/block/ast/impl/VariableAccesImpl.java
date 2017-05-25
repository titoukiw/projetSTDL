/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import java.io.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class VariableAccesImpl implements Expression {

	protected VariableDeclaration declaration;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public VariableAccesImpl(VariableDeclaration _declaration) {
		this.declaration = _declaration;
	}



	public VariableAccesImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		VariableDeclaration declaredDeclaration = declaration.makeLiaisonTardive(classes,interfaces);
		if(declaredDeclaration == null){
			throw new SemanticsUndefinedException("cant declare " + this.declaration);
		}

		return new VariableAccesImpl(declaredDeclaration);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("(VariableAcces)@{" + this.declaration.getName() + "}");
	}

	public VariableDeclaration getDeclaration() {
		return this.declaration;
	}
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return declaration.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() VariableAccesImpl");
	}

}
