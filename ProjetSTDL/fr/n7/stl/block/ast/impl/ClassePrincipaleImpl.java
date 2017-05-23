package fr.n7.stl.block.ast.impl;


import java.util.LinkedList;


import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;



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
		throw new SemanticsUndefinedException("checkType ClassePrincipaleImpl");
	}

	public int allocateMemory(Register _register, int _offset){
		throw new SemanticsUndefinedException("allocateMemory ClassePrincipaleImpl");
	}

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode ClassePrincipaleImpl");
	}
}