/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for building a couple value.
 * @author Marc Pantel
 *
 */
public class CoupleImpl implements Expression {

	private Expression first;
	
	private Expression second;

	/**
	 * Construction for a couple expression implementation.
	 * @param _first First part of the couple.
	 * @param _second Second part of the couple.
	 */
	public CoupleImpl(Expression _first, Expression _second) {
		this.first = _first;
		this.second = _second;
	}
	

	public CoupleImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredFirst = first.makeLiaisonTardive(classes,interfaces);
		Expression declaredSecond = second.makeLiaisonTardive(classes,interfaces);
		if(declaredFirst == null || declaredSecond == null){
			throw new SemanticsUndefinedException("cant declare " + this);
		}
		return new CoupleImpl(declaredFirst,declaredSecond);
		}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "< " + this.first + ", " + this.second + ">";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new CoupleTypeImpl( this.first.getType(), this.second.getType());
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = _factory.createFragment();
		_fragment.append(this.first.getCode(_factory));
		_fragment.append(this.second.getCode(_factory));
		return _fragment;
	}

}
