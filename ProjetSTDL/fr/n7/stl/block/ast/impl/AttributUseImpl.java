package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;

public class AttributUseImpl implements Expression {

	private ElementClasse attribut;
	private ClasseUseImpl classe;
	private Classe classeCourrante;


	public AttributUseImpl(ElementClasse att,ClasseUseImpl classe){
		this.attribut = att;
		this.classe = classe;
	}

	public AttributUseImpl(ElementClasse att,ClasseUseImpl classe,Classe classeCourrante){
		this.attribut = att;
		this.classe = classe;
		this.classeCourrante = classeCourrante;
	}


	public Type getType(){
		return this.attribut.getType();
	}

	public AttributUseImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		for(Classe cl : classes){
			System.out.println(cl.getName());
			if(cl.getName().equals(this.attribut.getClasseCourante())){
				this.classeCourrante = cl;
			}
		}
		return new AttributUseImpl(this.attribut.makeLiaisonTardive(classes,interfaces),this.classe,this.classeCourrante);
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
		//int posClass = -5;
		int pos = 0;
		Fragment fragment = _factory.createFragment();
		//fragment.add(_factory.createLoad(Register.LB,posClass,this.classeCourrante.getType().length()));//on load l'adresse de la classe
		fragment.add(_factory.createLoad(Register.LB,3,1)); // Load de l'adresse de la classe qu'on utilise (elle est toujours au meme endroit)
		for(ElementClasse att : this.classeCourrante.getElements()){
			if(att instanceof Attribut) {
				if(att.getName().equals(attribut.getName())){
					fragment.add(_factory.createLoadL(pos)); //calcul du decalage de l'adresse de l'attribut par rapport a l'adresse de la classe
					fragment.add(Library.IAdd);
					return fragment;
				} else {
					pos -= ((AttributImpl)this.attribut).offset;
				}
			}
		}
		return null;
	}

	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}
}


