package fr.n7.stl.block.ast;

import java.util.LinkedList;
/**
 * @author okeee
 *
 */
public interface Classe extends Objet {

	public boolean equalsTo(Classe _classe);
	public boolean containsMethode(String id);		// Depreciated
	public Methode getMethode(String id);			// Depreciated
	public boolean containsSignature(String id, LinkedList<Type> listParam);
	public Methode getSignature(String id, LinkedList<Type> listParam);
	public boolean containsAttribut(String id);
	public Expression getAttribut(String id);
	public Classe getHeritage();
	public LinkedList<Interface> getInterface();


}