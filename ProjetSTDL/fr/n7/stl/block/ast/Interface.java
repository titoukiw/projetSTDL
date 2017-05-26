package fr.n7.stl.block.ast;

import java.util.LinkedList;
/**
 * @author okeee
 *
 */
public interface Interface extends Objet {

	public String getName();
	public boolean equalsTo(Interface inter);
	public LinkedList<Interface> getHeritage();
	public Expression getFinalStaticField(String name);
	public boolean hasFinalStaticField(String name);
}