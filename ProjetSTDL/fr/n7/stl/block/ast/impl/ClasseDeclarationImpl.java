package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;


public class ClasseDeclarationImpl implements ClasseDeclaration {

	private String nom;
	private Type type;
	private Expression value;
	private Register register;
	private int offset;
	private Classe classe;


	public ClasseDeclarationImpl(String name, Type typ, Expression expr){
		this.nom = name;
		this.type = typ;
		this.value = expr;
		this.classe = ((ClasseTypeImpl) this.type).getClasse() ;
	}

	public Classe getClasse(){
		return this.classe;
	}

	public Type getType(){
		return this.type;
	}

	public Register getRegister(){
		return this.register;
	}

	public String toString(){
		String toString = "(ClasseDeclaration)" + this.type + " " + this.nom + " = " + this.value + ";\n";
		return toString;
	}

	public String getName(){
		return this.nom;
	}

	public int getOffset(){
		return this.offset;
	}

	public boolean checkType(){
		throw new SemanticsUndefinedException("checkType() ClasseDeclarationImpl");
	}

	public int allocateMemory(Register regiser, int offset){
		throw new SemanticsUndefinedException("allocateMemory() ClasseDeclarationImpl");
	}

	public Fragment getCode(TAMFactory factory){
		throw new SemanticsUndefinedException("getCode() ClasseDeclarationImpl");
	}


}
