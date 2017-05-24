package fr.n7.stl.block.ast.impl;

import java.util.List;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class AttributAccesImpl implements Expression {

	private ElementClasse attribut;


	public AttributAccesImpl(ElementClasse att){
		this.attribut = att;
	}

	public Type getType(){
		return this.attribut.getType();
	}

	public String toString() {
		return "(AttributAcces From " + this.attribut.getClasseCourante() +  " )@{" + this.attribut.getName() + "}";
	}

	public ElementClasse getDeclaration() {
		return this.attribut;
	}
	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() AttributAccesImpl");
	}
}