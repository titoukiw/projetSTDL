package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

public interface Signature extends ElementInterface{

	public LinkedList<Parametre> getParametres();

	public String getId();
}
