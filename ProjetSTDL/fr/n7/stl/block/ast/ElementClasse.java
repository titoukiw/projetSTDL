package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

public interface ElementClasse extends Declaration, Expression {

	public String getClasseCourante();
	public Type getType();
}