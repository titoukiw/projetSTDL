/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

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


	public AssignmentImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		if(this.declaration != null && this.value != null){
			return new AssignmentImpl(this.declaration.makeLiaisonTardive(classes,interfaces), this.value.makeLiaisonTardive(classes,interfaces));
		}
		if(this.assignable != null && this.value != null){
			return new AssignmentImpl(this.assignable.makeLiaisonTardive(classes,interfaces), this.value.makeLiaisonTardive(classes,interfaces));
		}
		if(this.assignable_expr != null && this.value != null){
			return new AssignmentImpl(this.assignable_expr.makeLiaisonTardive(classes,interfaces), this.value.makeLiaisonTardive(classes,interfaces));
		}

		return this;

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
		} else if (this.assignable_expr != null) {
			return ((this.declaration != null)
					?this.declaration.getName()
					:this.assignable_expr) + " = " + this.value.toString() + ";\n";
		} else {
			return null;
		}
	}


	public Type getType(){
		if(this.assignable != null){
			return this.assignable.getType();
		} else {
			return this.assignable_expr.getType();
		}
	}

	public boolean checkTypeConstructeur(LinkedList<Classe> classes, LinkedList<Interface> interfaces, String classeCourante) {
		boolean result = true;	//On vérifie qu'un contructeur n'appelle pas son propre type ?
			Classe _cl = null;
			for (Classe cl : classes){
				if (cl.getName().equals(classeCourante)){
					_cl = cl;
				}
			}
			if (this.assignable.getType() == _cl.getType()){
				return false;					
			} else {
				return true;
			}
	}
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean result;
			if(this.assignable != null){
				result = this.value.getType().compatibleWith(this.declaration.getType());
			} else if (this.assignable_expr != null && 
					   !(this.assignable_expr instanceof BinaryExpressionImpl) &&
					   !(this.assignable_expr instanceof UnaryExpressionImpl) ){
				result = this.value.getType().compatibleWith(this.assignable_expr.getType());
			} else {
				result = false;
			}
			return result;
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
		Fragment _fragment = _factory.createFragment();
		// if(this.value instanceof ObjetAllocationImpl){
		// 	if(this.assignable != null){
		// 		// _fragment.append(this.value.getCode(_factory)); //value on top
		// 		// _fragment.append(this.assignable.getCode(_factory));
		// 		// _fragment.add(_factory.createLoadL(this.assignable.getType().length()));//size of class on top
		// 		// _fragment.add(Library.MAlloc); // @ of class on top
		// 		// _fragment.add(_factory.createStoreI(this.value.getType().length()));

		// 		_fragment.append(this.assignable.getCode(_factory));
		// 		_fragment.add(_factory.createLoadL(this.assignable.getType().length()));
		// 		_fragment.add(Library.MAlloc);
		// 		_fragment.add(_factory.createStoreI(1));
		// 		_fragment.append(this.value.getCode(_factory));



		// 	}else if (this.assignable_expr != null){
		// 		// _fragment.append(this.value.getCode(_factory)); //value on top
		// 		// _fragment.append(this.assignable_expr.getCode(_factory));
		// 		// _fragment.add(_factory.createLoadL(this.assignable_expr.getType().length()));//size of class on top
		// 		// _fragment.add(Library.MAlloc); // @ of class on top
		// 		// _fragment.add(_factory.createStoreI(this.value.getType().length()));
		// 		_fragment.append(this.assignable_expr.getCode(_factory));
		// 		_fragment.add(_factory.createLoadL(this.assignable_expr.getType().length()));
		// 		_fragment.add(Library.MAlloc);
		// 		_fragment.add(_factory.createStoreI(1));
		// 		_fragment.append(this.value.getCode(_factory));

		// 	}else{
		// 		throw new SemanticsUndefinedException("AssignmentImpl getCode() no assignable");
		// 	}
		// }else{
			if(this.assignable != null){
				_fragment.append(this.value.getCode(_factory));
				_fragment.append(this.assignable.getCode(_factory));
				_fragment.add(_factory.createStoreI(this.value.getType().length()));
			} else if (this.assignable_expr != null){
				_fragment.append(this.value.getCode(_factory));
				_fragment.append(this.assignable_expr.getCode(_factory));
				_fragment.add(_factory.createStoreI(this.value.getType().length()));
			}
		// }

			
		return _fragment;
	}

}
