package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class AttributAccesImpl implements Expression {

	private ElementClasse attribut;
	private ClasseUseImpl classe;


	public AttributAccesImpl(ElementClasse att,ClasseUseImpl classe){
		this.attribut = att;
		this.classe = classe;
	}

	public Type getType(){
		return this.attribut.getType();
	}

	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new AttributAccesImpl(attribut.makeLiaisonTardive(classes,interfaces),this.classe);
	}

	public String toString() {
		return "(AttributAcces From " + this.attribut.getClasseCourante() +  " )@{" + this.attribut.getName() + "}";
	}

	public ElementClasse getDeclaration() {
		return this.attribut;
	}
	
	public ClasseUseImpl getClasseUse(){
		return this.classe;
	}
	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() AttributAccesImpl");
	}
}