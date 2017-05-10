/**
 * 
 */
package fr.n7.stl.interface.ast.impl;

/**
 * Implementation of the factory for building Abstract Syntax Tree node for the Bloc language.
 * @author okeee
 *
 */
public class InterfaceFactoryImpl implements InterfaceFactory {

	public InterfaceFactoryImpl(){
	}

	public Interface createInterface(Object... args){
		return new InterfaceImpl(args);
	}

}