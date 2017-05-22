package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;

public class ParametreImpl implements Parametre {

	private String id;
	private Type type; //TypeAtomique?

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

}