package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;

import java.util.LinkedList;

public class ObjetAllocationImpl implements Expression {

	private Type type; //type -> ClassTypeImpl ou InterfaceTypeImpl 
	private LinkedList<Expression> expressions;

	public ObjetAllocationImpl(Type type, LinkedList<Expression> expressions){
		this.type = type;
		this.expressions = expressions;
	}

	public Type getType(){
		return this.type;
	}


	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getcode() ObjetAllocationImpl");
	}
}