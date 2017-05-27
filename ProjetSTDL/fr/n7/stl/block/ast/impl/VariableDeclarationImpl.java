/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class VariableDeclarationImpl implements VariableDeclaration {

	private String name;
	protected Type type;
	protected Expression value;
	protected Register register;
	protected int offset;
	
	/**
	 * Creates a variable declaration instruction node for the Abstract Syntax Tree.
	 * @param _name Name of the declared variable.
	 * @param _type Type of the declared variable.
	 * @param _value Value of the declared variable.
	 */
	public VariableDeclarationImpl(String _name, Type _type, Expression _value) {
		this.name = _name;
		this.type = _type;
		this.value = _value;
	}



	public VariableDeclarationImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		if(value != null){
			Expression declaredValue = this.value.makeLiaisonTardive(classes,interfaces);
		
			if(declaredValue == null){
				throw new SemanticsUndefinedException("cant declare" + this.value);
			}
			if(this.type instanceof UndeclaredTypeImpl){
				for (Classe classe : classes){
					if(classe.getName().equals(((UndeclaredTypeImpl) this.type).getName())){
						return new VariableDeclarationImpl(this.name,new ClasseTypeImpl(classe), declaredValue);
					}
				}
	
				throw new SemanticsUndefinedException("cant declare" + this.type);
			}
			return new VariableDeclarationImpl(this.name, this.type,declaredValue);
		} else {
			if(this.type instanceof UndeclaredTypeImpl){
				for (Classe classe : classes){
					if(classe.getName().equals(((UndeclaredTypeImpl) this.type).getName())){
						return new VariableDeclarationImpl(this.name,new ClasseTypeImpl(classe), this.value);
					}
				}
	
				throw new SemanticsUndefinedException("cant declare" + this.type);
			}
		}

		return null;

		
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(VariableDeclaration)" + this.type + " " + this.name + " = " + this.value + ";\n";
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getRegister()
	 */
	@Override
	public Register getRegister() {
		return this.register;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getOffset()
	 */
	@Override
	public int getOffset() {
		return this.offset;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean result;
		result = this.value.getType().compatibleWith(this.type);
		return result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.register = _register;
		this.offset = _offset ;
		return this.value.getType().length();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		return this.value.getCode(_factory);
	}

}
