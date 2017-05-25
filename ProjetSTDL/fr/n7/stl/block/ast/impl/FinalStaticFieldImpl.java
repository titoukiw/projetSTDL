package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FinalStaticField;
import fr.n7.stl.block.ast.Type;


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
	@Override
	public boolean checkType() {
		return this.type.compatibleWith(value.getType());
	}
	
	
	public String toString() {
		return "([FinalStaticField] " + this.type + " " + this.name + " = " + this.value + ";)\n";
	}




}