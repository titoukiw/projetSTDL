/**
 * 
 */
package fr.n7.stl.block.ast;
import java.util.LinkedList;
/**
 * Factory to create Abstract Syntax Tree nodes for common expressions in programming languages.
 * @author Marc Pantel
 *
 */
public interface ExpressionFactory {

	/**
	 * Create a node for a binary expression in the Abstract Syntax Tree.
	 * @param _left Abstract Syntax Tree for the left parameter of the binary operation.
	 * @param _operator Enum value for the binary operator.
	 * @param _right Abstract Syntax Tree for the right parameter of the binary operation.
	 * @return Abstract Syntax Tree node for the binary operation.
	 */
	public Expression createBinaryExpression(Expression _left, BinaryOperator _operator, Expression _right);

	/**
	 * Create a node for an unary expression in the Abstract Syntax Tree.
	 * @param _operator Enum value for the unary operator.
	 * @param _parameter Abstract Syntax Tree for the parameter of the unary operation.
	 * @return Abstract Syntax Tree node for the unary operation.
	 */
	public Expression createUnaryExpression(UnaryOperator _operator, Expression _parameter);
	
	/**
	 * Create a node for an integer value expression in the Abstract Syntax Tree.
	 * @param _texte Textual representation of the value of the Abstract Syntax Tree IntegerValue node.
	 * @return Abstract Syntax Tree node for the integer constant.
	 */
	public Value createIntegerValue(String _texte);

	public Value createCharacterValue(String _texte);

	public Value createStringValue(String _texte);
	
	/**
	 * Create a node for a boolean value expression in the Abstract Syntax Tree.
	 * @param _value Boolean value for the Abstract Syntax Tree BooleanValue node.
	 * @return Abstract Syntax Tree node for the boolean constant.
	 */
	public Value createBooleanValue(boolean _value);
	
	/**
	 * Create a node for a variable use expression in the Abstract Syntax Tree.
	 * with resolving the reference with the Symbol Table.	 
	 * @param _declaration Abstract Syntax Tree node for the declaration of the variable.
	 * @return Abstract Syntax Tree node for the access to a variable.
	 */
	public Expression createVariableUse(VariableDeclaration _declaration);
	
	/**
	 * Create a node for a variable assignment in the Abstract Syntax Tree.
	 * with resolving the reference with the Symbol Table.	 
	 * @param _declaration Abstract Syntax Tree node for the declaration of the variable.
	 * @return Abstract Syntax Tree node for the access to a variable.
	 */
	public Assignable createVariableAssignment(VariableDeclaration _declaration);
	
	/**
	 * Create a node for a function call expression in the Abstract Syntax Tree.
	 * @param _called Abstract Syntax Tree node for the called function.
	 * @return Abstract Syntax Tree node for the call of the _called function.
	 */
	public FunctionCall createFunctionCall(Expression _called);
	
	/**
	 * Create a node for an access to an element in an array expression in the Abstract Syntax Tree.
	 * @param _array Abstract Syntax Tree node for the array.
	 * @param _index Abstract Syntax Tree node for the index in the array.
	 * @return Abstract Syntax Tree node for the access of the _index cell in the _array.
	 */
	public Expression createArrayAccess(Expression _array, Expression _index);
	
	/**
	 * Create a node for an assignment to an element in an array expression in the Abstract Syntax Tree.
	 * @param _array Abstract Syntax Tree node for the array.
	 * @param _index Abstract Syntax Tree node for the index in the array.
	 * @return Abstract Syntax Tree node for the access of the _index cell in the _array.
	 */
	public Assignable createArrayAssignment(Assignable _array, Expression _index);
			
	/**
	 * Create a node for a sequence of expressions in the Abstract Syntax Tree.
	 * @return Abstract Syntax Tree node for the creation of a sequence of values.
	 */
	public Sequence createSequence();

	/**
	 * Create a node for a sequence of expressions in the Abstract Syntax Tree.
	 * @param _values Abstract Syntax Tree nodes for the values in the collection.
	 * @return Abstract Syntax Tree node for the creation of a collection of values.
	 */
	public Sequence createSequence(Iterable<Expression> _values);

    /**
    * Create a node for the allocation of an array
    * @param _type The type of the elements of the array
    * @param _size The size of the array to allocate
    */
    public Expression createArrayAllocation(Type _type, Expression _size);

    /**
    * Create a node for the allocation of a pointer
    * @param type The Type of the object
    * @param expressions 
    */
    public Expression createObjetAllocation(Type type, LinkedList<Expression> expressions);


}
