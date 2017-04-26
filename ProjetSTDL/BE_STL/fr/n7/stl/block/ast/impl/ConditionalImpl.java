/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class ConditionalImpl implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Optional<Block> elseBranch;

	public ConditionalImpl(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.of(_else);
	}

	public ConditionalImpl(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch.isPresent())?(" else " + this.elseBranch.get()):"");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
			return AtomicType.BooleanType ==this.condition.getType();	
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		 this.thenBranch.allocateMemory(_register,_offset);
		 if(this.elseBranch.isPresent()){
			this.elseBranch.get().allocateMemory(_register,_offset);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int _localLabel = _factory.createLabelNumber();
		Fragment _fragment = this.condition.getCode(_factory);
		_fragment.add(_factory.createJumpIf("else_Condition" + _localLabel,0));
		_fragment.append(this.thenBranch.getCode(_factory));
		_fragment.add(_factory.createJump("fin_Condition" + _localLabel));
		_fragment.addSuffix("else_Condition" + _localLabel +":");
		if(this.elseBranch.isPresent()){
			_fragment.append(this.elseBranch.get().getCode(_factory));
		}
		_fragment.addSuffix("fin_Condition" + _localLabel + ":");
		return _fragment;
	}

}
