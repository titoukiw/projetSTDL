package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.signature;

public class SignatureImpl implements Signature {

	private String id;
	private LinkedList<Parametre> listParam;

	public Signature(String id, LinkedList<Parametre> listParam){
		this.id = id;
		this.listParam = listParam;
	}

	public getId(){
		return this.id;
	}

	//public getListParam()?
}