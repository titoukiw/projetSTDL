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

	public String toString() {
		return "@{" + this.classe.getName() + "}";
	}

	public ClasseDeclaration getDeclaration() {
		return this.classe;
	}

	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() ClasseUseImpl");
	}
}

