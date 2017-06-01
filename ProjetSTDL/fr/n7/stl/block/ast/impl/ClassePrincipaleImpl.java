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
		toString += " { \n" + "public static void main(String args[]) ";
		toString += " " + this.methodePrincipale + "\n }";
		return toString;
	}


	public boolean checkType() {
		return methodePrincipale.checkType();
	}

	public int allocateMemory(Register _register, int _offset) {
		return this.methodePrincipale.allocateMemory(_register, _offset); //+1 pour le nom ?
	}

	public Fragment getCode(TAMFactory _factory){
		return methodePrincipale.getCode(_factory);
	}

}