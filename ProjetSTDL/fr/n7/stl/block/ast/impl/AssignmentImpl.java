/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * @author Marc Pantel
 *
 */
public class AssignmentImpl implements Instruction, Expression {

	protected VariableDeclaration declaration;
	protected Expression value;
	protected Expression assignable_expr;
	protected Assignable assignable;

	/**
	 * Create an assignment instruction implementation from the assigned variable declaration
	 * and the assigned value.
	 * @param _declaration Assigned variable declaration.
	 * @param _value Assigned value.
	 */
	public AssignmentImpl(VariableDeclaration _declaration, Expression _value) {
		this.declaration = _declaration;
		this.value = _value;
	}

	/**
	 * Create an assignment instruction implementation from the assignable expression
	 * and the assigned value.
	 * @param _assignable Expression that can be assigned a value.
	 * @param _value Value assigned to the expression.
	 */
	public AssignmentImpl(Assignable _assignable, Expression _value) {
		this.assignable = _assignable;
		this.value = _value;
	}

	public AssignmentImpl(Expression assignable, Expression value){
		this.assignable_expr = assignable;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if(this.assignable != null){
			return ((this.declaration != null)
					?this.declaration.getName()
					:this.assignable) + " = " + this.value.toString() + ";\n";
		} else {
			return ((this.declaration != null)
					?this.declaration.getName()
					:this.assignable_expr) + " = " + this.value.toString() + ";\n";
		}
	}


	public Type getType(){
		if(this.assignable != null){
			return this.assignable.getType();
		} else {
			return this.assignable_expr.getType();
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
	        return this.value.getType().compatibleWith(this.assignable.getType());
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
			Fragment _fragment = this.value.getCode(_factory);
			_fragment.append(this.assignable.getCode(_factory));
			_fragment.add(_factory.createStoreI(this.value.getType().length()));
		return _fragment;
	}

}
