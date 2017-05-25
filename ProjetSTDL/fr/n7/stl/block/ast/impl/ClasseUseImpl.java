package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class ClasseUseImpl implements Expression, Instruction {

	private ClasseDeclaration classe;


	public ClasseUseImpl(ClasseDeclaration classe){
		this.classe = classe;
	}

	public Type getType(){
		return this.classe.getType();
	}

	public String getName(){
		return this.classe.getClasse().getName();
	}

	public String toString() {
		return "(ClasseUse) @{" + this.classe.getName() + "}";
	}

	public ClasseDeclaration getDeclaration() {
		return this.classe;
	}

	public ClasseUseImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		ClasseDeclaration declaredClasse =((ClasseDeclaration) classe.makeLiaisonTardive(classes,interfaces));
		this.classe = declaredClasse;
		return this;
	}


	public boolean containsMethode(String id){
		return this.classe.getClasse().containsMethode(id);
	}

	public Methode getMethode(String id){
		return this.classe.getClasse().getMethode(id);
	}

	public boolean containsAttribut(String id){
		return this.classe.getClasse().containsAttribut(id);
	}
	
	public Expression getAttribut(String id){
		return this.classe.getClasse().getAttribut(id);
	}

	public boolean checkType(){
		throw new SemanticsUndefinedException("checkType() ClasseUseImpl");
	}
	

	public int allocateMemory(Register _register, int _offset){
		throw new SemanticsUndefinedException("allocateMemory() ClasseUseImpl");
	}
	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() ClasseUseImpl");
	}
}


