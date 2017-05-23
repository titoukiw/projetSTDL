package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */
public interface Interface extends Objet {

	public String getName();
	public boolean equalsTo(Interface inter);
	public Expression getFinalStaticField(String name);
	public boolean hasFinalStaticField(String name);
}