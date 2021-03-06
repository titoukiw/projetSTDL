/**
 * 
 */
package fr.n7.stl.block.ast;
import fr.n7.stl.block.ast.*;
import java.util.LinkedList;
/**
 * AST node for the constant declaration instruction.
 * @author Marc Pantel
 *
 */
public interface ConstantDeclaration extends Instruction, Declaration {
	
	/**
	 * Provide the value associated to a name in a type declaration.
	 * @return Value from the declaration.
	 */
	public Expression getValue();

	public ConstantDeclaration makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces);


}
