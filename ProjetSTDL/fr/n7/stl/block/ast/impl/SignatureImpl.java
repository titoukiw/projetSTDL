package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
import java.util.LinkedList;

public class SignatureImpl implements Signature {

	private String id;
	private LinkedList<Parametre> listParam;
	private Type returnType;

	//Void method contructor
	public SignatureImpl(String id, LinkedList<Parametre> listParam){
		this.id = id;
		this.listParam = listParam;
		this.returnType = AtomicType.VoidType;
	}

	public SignatureImpl(String id, Type type, LinkedList<Parametre> listParam){
		this.id = id;
		this.listParam = listParam;
		this.returnType = type;
	}

	@Override
	public String getId(){
		return this.id;
	}

	public Type getType(){
		return this.returnType;
	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

}