/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a repetition instruction.
 * @author Marc Pantel
 *
 */
public class RepetitionImpl implements Instruction {

	protected Expression condition;
	protected Block body;

	public RepetitionImpl(Expression _condition, Block _body) {
		this.condition = _condition;
		this.body = _body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "while (" + this.condition + ") " + this.body;
	}

	public Instruction makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredCondition = condition.makeLiaisonTardive(classes,interfaces);
		if(declaredCondition == null){
			throw new SemanticsUndefinedException("cant declare " + this.condition);
		}
		Block declaredBody = body.makeLiaisonTardive(classes,interfaces);
		if(declaredBody == null){
			throw new SemanticsUndefinedException("cant declare " + this.body);
		}

		return new RepetitionImpl(declaredCondition,declaredBody);
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
	        return AtomicType.BooleanType.equalsTo(this.condition.getType());	
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.body.allocateMemory(_register,_offset);
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int _localLabel = _factory.createLabelNumber();
		Fragment _fragment = this.condition.getCode((_factory));
		_fragment.addPrefix("debut_boucle_" + _localLabel +":");
		_fragment.add(_factory.createJumpIf("fin_boucle_" + _localLabel,0));
		_fragment.append(this.body.getCode(_factory));
		_fragment.add(_factory.createJump("debut_boucle_" + _localLabel));
		_fragment.addSuffix("fin_boucle_" + _localLabel +":");
		return _fragment;
	}

}
