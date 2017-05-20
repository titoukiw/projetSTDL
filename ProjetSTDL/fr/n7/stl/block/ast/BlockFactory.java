/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;

/**
 * Combines the various factories for the Bloc language.
 * @author Marc Pantel
 *
 */
public interface BlockFactory extends ExpressionFactory, InstructionFactory, TypeFactory, InterfaceFactory {

	public Programme createProgramme(LinkedList<Interface> interfaces);
}
