package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
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

	public AttributUseImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new AttributUseImpl(this.attribut.makeLiaisonTardive(classes,interfaces),this.classe);
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
		Fragment code = _factory.createFragment();
		return code;
	}

	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}
}


