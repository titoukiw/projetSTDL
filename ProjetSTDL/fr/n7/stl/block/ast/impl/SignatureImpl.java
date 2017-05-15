package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.signature;
import fr.n7.stl.block.ast.AtomicType;

public class SignatureImpl implements Signature {

	private String id;
	private LinkedList<Parametre> listParam;
	private Type returnType;

	//Void method contructor
	public Signature(String id, LinkedList<Parametre> listParam){
		this.id = id;
		this.listParam = listParam;
		this.returnType = AtomicType.VoidType;
	}

	public Signature(String id, Type type, LinkedList<Parametre> listParam){
		this.id = id;
		this.listParam = listParam;
		this.returnType = type;
	}

	public getId(){
		return this.id;
	}

	public Type getType(){
		this.returnType;
	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

}