package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;


public class ParametreUseImpl implements Expression {

	protected Parametre parametre;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * param _parametre Declaration of the used variable.
	 */
	public ParametreUseImpl(Parametre _parametre) {
		this.parametre = _parametre;
	}


	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Parametre declaredParametre = parametre.makeLiaisonTardive(classes,interfaces);
		if(declaredParametre == null){
			throw new SemanticsUndefinedException("cannot declare" + parametre);
		}
		return new ParametreUseImpl(declaredParametre);
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
		int offsetFun = 3;
		Fragment code = _factory.createFragment();
		if(this.parametre.getType() instanceof ClasseTypeImpl){
			code.add(_factory.createLoad(Register.LB,-this.parametre.getOffset()+offsetFun,1)); //on a passe le pointeur vers la classe
			code.add(_factory.createLoadI(this.parametre.getType().length()));
		} else {
			code.add(_factory.createLoad(Register.LB,-this.parametre.getOffset()+offsetFun,this.parametre.getType().length()));
		}


		return code;
	}


}