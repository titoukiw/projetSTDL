package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */
public interface Classe extends Objet {

	public boolean equalsTo(Classe _classe);
	public boolean containsMethode(String id);
	public Methode getMethode(String id);
	public boolean containsAttribut(String id);
	public Expression getAttribut(String id);


}