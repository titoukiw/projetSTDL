package fr.n7.stl.block.ast.impl;


import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.ClassePrincipale;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;



public class ClassePrincipaleImpl implements ClassePrincipale {

	private String name;
	private Block methodePrincipale;


	public ClassePrincipaleImpl(String name, Block methodePrincipale){
		this.name = name;
		this.methodePrincipale = methodePrincipale;
	}

	public String toString() {
		String toString = "public class " + this.name;
		toString += " { \n" + "public staitc void main(String args[]) ";
		toString += " " + this.methodePrincipale + "\n }";
		return toString;
	}


	public boolean checkType() {
		return methodePrincipale.checkType();
	}

	public int allocateMemory(Register _register, int _offset){
		throw new SemanticsUndefinedException("allocateMemory ClassePrincipaleImpl");
	}

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode ClassePrincipaleImpl");
	}

}