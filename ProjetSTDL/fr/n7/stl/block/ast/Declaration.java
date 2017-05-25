package fr.n7.stl.block.ast;

/**
 * @author Marc Pantel
 *
 */
import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public interface Declaration {
	
	/**
	 * Provide the identifier (i.e. name) given to the declaration.
	 * @return Name of the declaration.
	 */
	public String getName();

	//public String toString(); //??
	public Declaration makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces);


}
