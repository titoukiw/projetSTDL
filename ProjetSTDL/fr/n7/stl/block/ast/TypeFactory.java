/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * Factory to create nodes for types.
 * @author Marc Pantel
 *
 */
public interface TypeFactory {

	/**
	 * Create an Abstract Syntax Tree node for the integer type.
	 * @return Abstract Syntax Tree node for the integer type.
	 */
	public Type createIntegerType();
	
	/**
	 * Create an Abstract Syntax Tree node for the boolean type.
	 * @return Abstract Syntax Tree node for the boolean type.
	 */
	public Type createBooleanType();
	
	/**
	 * Create an Abstract Syntax Tree node for the float type.
	 * @return Abstract Syntax Tree node for the float type.
	 */
	public Type createFloatingType();
	
	/**
	 * Create an Abstract Syntax Tree node for the char type.
	 * @return Abstract Syntax Tree node for the char type.
	 */
	public Type createCharType();

	/**
	 * Create an Abstract Syntax Tree node for the String type.
	 * @return Abstract Syntax Tree node for the String type.
	 */
	public Type createStringType();
	
	/** 
	 * Create an Abstract Syntax Tree node for an array type.
	 * @param _element Abstract Syntax Tree for the type of the elements in the array type.
	 * @return Abstract Syntax Tree node for an array type.
	 */
	public Type createArrayType(Type _element);
	
	/**
	 * Create an Abstract Syntax Tree node for a function type.
	 * @param _result Abstract Syntax Tree for the type of the result in the function type.
	 * @param _parameters Abstract Syntax Trees for the types of the sequence of parameters in the function type.
	 * @return Abstract Syntax Tree node for a function type.
	 */
	public Type createFunctionType(Type _result, Iterable<Type> _parameters);

	public Type createUndeclaredType(String id_type);
	
}
