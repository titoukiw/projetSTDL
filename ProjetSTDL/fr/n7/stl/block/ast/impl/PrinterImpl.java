/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.Library;
import java.util.LinkedList;
/**
 * Implementation of the Abstract Syntax Tree node for a printer instruction.
 * @author Marc Pantel
 *
 */
public class PrinterImpl implements Instruction {

	private Expression parameter;

	public PrinterImpl(Expression _value) {
		this.parameter = _value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "print" + this.parameter + ";\n";
	}


	public Instruction makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredParameter = parameter.makeLiaisonTardive(classes,interfaces);
		if(declaredParameter == null){
			throw new SemanticsUndefinedException("cant declare " + this.parameter);
		}

		return new PrinterImpl(declaredParameter);
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
	    return (this.parameter.getType() instanceof AtomicType);  
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
		Fragment _fragment = this.parameter.getCode(_factory);
		_fragment.add(Library.IOut);
		return _fragment;
	}

}
