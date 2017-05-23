package fr.n7.stl.block.ast;


public interface FinalStaticField extends VariableDeclaration, ElementInterface {

	public Expression getValue();
}