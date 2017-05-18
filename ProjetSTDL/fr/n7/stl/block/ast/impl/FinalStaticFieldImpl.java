package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;


public class FinalStaticFieldImpl extends VariableDeclarationImpl implements ElementInterface {

	private String name;
	private Expression value;
	private Type type;


	public FinalStaticFieldImpl(String name, Type type, Expression expr){
		super(name,type,expr);
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Type getType() {
		return type;
	}
	
	public Expression getExpression() {
		return value;
	}
	

	/* TO DO */
	@Override
	public boolean checkType() {
		return true;
	}
	
	@Override
	public String toString() {
		return "([FinalStaticField] " + this.type + " " + this.name + " = " + this.value + ";)\n";
	}



}