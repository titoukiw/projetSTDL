/**
 * 
 */
package fr.n7.stl.block.ast;
import fr.n7.stl.block.ast.*;
import java.util.LinkedList;
/**
 * @author Marc Pantel
 *
 */
public interface TypeDeclaration extends Instruction, Declaration {
	
	/**
	 * Provide the type associated to a name in a type declaration.
	 * @return Type from the declaration.
	 */
	public Type getType();

	public TypeDeclaration makeLiaisonTardive(LinkedList<Classe> classes,LinkedList<Interface> interfaces);

}
