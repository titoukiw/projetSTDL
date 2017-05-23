package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;


public class FinalStaticFieldImpl extends VariableDeclarationImpl implements FinalStaticField {

	private String name;
	private Expression value;
	private Type type;
	private String objetCourant;

	public FinalStaticFieldImpl(String name, String objetCourant, Type type, Expression expr){
		super(name,type,expr);
		this.objetCourant = objetCourant;
	}

	public String getName() {
		return name;
	}
	
	public Type getType() {
		return type;
	}
	
	public Expression getValue() {
		return value;
	}
	
	public String getInterfaceCourrante(){
		return this.objetCourant;
	}

	/* TO DO */
	public boolean checkType() {
		return true;
	}
	
	
	public String toString() {
		return "([FinalStaticField] " + this.type + " " + this.name + " = " + this.value + ";)\n";
	}



}