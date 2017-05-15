package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

public interface Signature extends ElementInterface{


	public String getId();

	public Type getType();

	public LinkedList<Parametre> getParametres();

	
}
