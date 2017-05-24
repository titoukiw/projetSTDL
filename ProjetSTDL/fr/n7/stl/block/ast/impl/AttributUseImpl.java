package fr.n7.stl.block.ast.impl;

import java.util.List;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class AttributUseImpl implements Expression {

	private ElementClasse attribut;
	private ClasseUseImpl classe;


	public AttributUseImpl(ElementClasse att,ClasseUseImpl classe){
		this.attribut = att;
		this.classe = classe;
	}

	public Type getType(){
		return this.attribut.getType();
	}

	public ClasseUseImpl getClasseUse(){
		return this.classe;
	}

	public String toString() {
		return "(AttributUse From " + this.attribut.getClasseCourante() +  " )@{" + this.attribut.getName() + "}";
	}

	public ElementClasse getDeclaration() {
		return this.attribut;
	}

	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() AttributUseImpl");
	}
}


