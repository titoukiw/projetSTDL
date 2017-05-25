/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.io.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an instruction block.
 * @author Marc Pantel
 *
 */
public class BlockImpl implements Block {

	/**
	 * Sequence of instructions contained in a block.
	 */
	protected List<Instruction> instructions;

	/**
	 * Hierarchical structure of blocks.
	 * Link to the container block.
	 * 
	 */
	protected Optional<Block> context;
	
	protected int allocatedSize;
	/**
	 * Constructor for a block contained in a _context block.
	 * @param _context Englobing block.
	 */
	public BlockImpl(Block _context) {
		assert( _context != null);
		this.instructions = new LinkedList<Instruction>();
		if (_context == null) {
			this.context = Optional.empty();
		} else {
			this.context = Optional.of(_context);
		}
	}
	
	/**
	 * Constructor for a block root of the block hierarchy.
	 */
	public BlockImpl() {
		this.instructions = new LinkedList<Instruction>();
		this.context = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.Block#add(fr.n7.block.ast.Instruction)
	 */
	@Override
	public void add(Instruction _instruction) {
		this.instructions.add(_instruction);
	}



	public BlockImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		
		LinkedList<Instruction> declaredInstructions = new LinkedList<Instruction>();
		Instruction declaredInstruction;
		for(Instruction instruction : this.instructions){
			declaredInstruction = instruction.makeLiaisonTardive(classes,interfaces);
			if(declaredInstruction == null){
				throw new SemanticsUndefinedException("Cant declare " + instruction );
			}
			declaredInstructions.add(declaredInstruction);
		}
		this.instructions = declaredInstructions;
		return this;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#addAll(java.lang.Iterable)
	 */
	@Override
	public void addAll(Iterable<Instruction> _instructions) {
		for (Instruction i : _instructions) {
			this.instructions.add(i);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _local = "";
		for (Instruction _instruction : this.instructions) {
			_local += _instruction;
                        
		}
		return "{\n" + _local + "}\n" ;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
	        boolean _local = true;
                for(Instruction _instruction : this.instructions) {
                    _local = _local && _instruction.checkType();
                }
                return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		int local = _offset;
		for(Instruction i : this.instructions){
			local += i.allocateMemory(_register,local);
		}
		this.allocatedSize = local - _offset;
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _fragment = _factory.createFragment();
		for(Instruction i : this.instructions) {
			_fragment.append(i.getCode(_factory));
		}
		_fragment.add(_factory.createPop(0,this.allocatedSize));
		return _fragment;
	}

}
