package fr.n7.stl.block.ast.impl;

import java.util.List;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class ClasseUseImpl implements Expression {

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

	public boolean containsAttribut(String id){
		return this.classe.getClasse().containsAttribut(id);
	}
	
	public Expression getAttribut(String id){
		return this.classe.getClasse().getAttribut(id);
	}

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() ClasseUseImpl");
	}
}


