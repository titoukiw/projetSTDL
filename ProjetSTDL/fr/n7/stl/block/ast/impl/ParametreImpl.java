package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;

public class ParametreImpl implements Parametre {

	private String id;
	private Type type; //TypeAtomique?
	private Register register;
	private int offset;


	public ParametreImpl(String id, Type type ){
		this.id = id;
		this.type = type;
	}


	public String getName(){
		return this.id;
	}

	public String toString(){
		return "(Parametre) " + this.type + " " + this.id;
	}

	public Type getType(){
		return this.type;
	}


	public int allocateMemory(Register _register, int _offset){
		this.register = _register;
		this.offset = _offset;
		return this.type.length();
	}

}