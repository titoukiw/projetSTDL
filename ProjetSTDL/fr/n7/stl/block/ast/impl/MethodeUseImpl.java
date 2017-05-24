package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class MethodeUseImpl implements Expression, Instruction {

	private Methode methode;
	private LinkedList<Expression> arguments;
	private ClasseUseImpl classe;


	public MethodeUseImpl(Methode methode,ClasseUseImpl classe){
		this.methode = methode;
		this.classe = classe;
	}

	public Type getType(){
		return this.methode.getType();
	}

	public void setArguments(LinkedList<Expression> args){
		this.arguments = args;
	}

	public String getName(){
		return this.methode.getName();
	}

	public String toString() {
		String toString = "(MethodeUse From " + this.classe.getName() + ") @{" + this.methode.getName() + "(" ;
		for(Expression args : this.arguments){
			toString += args + " ,";
		}
		toString += ")"  + "}\n";
		return toString;
	}

	public Methode getDeclaration() {
		return this.methode;
	}



	public boolean checkType(){
		throw new SemanticsUndefinedException("checkType() MethodeUseImpl");
	}
	

	public int allocateMemory(Register _register, int _offset){
		throw new SemanticsUndefinedException("allocateMemory() MethodeUseImpl");
	}
	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() MethodeUseImpl");
	}
}

