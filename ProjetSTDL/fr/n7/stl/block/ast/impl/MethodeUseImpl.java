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


	public MethodeUseImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Methode declaredMethode = ((Methode)methode.makeLiaisonTardive(classes,interfaces));
		if(declaredMethode == null){
			throw new SemanticsUndefinedException("cannot declare " + this.methode);
		}
		LinkedList<Expression> args = new LinkedList<Expression>();

		for(Expression expr : arguments){
			args.add(expr.makeLiaisonTardive(classes,interfaces));
		}

		MethodeUseImpl declaredMetUseImp = new MethodeUseImpl(declaredMethode,this.classe);
		declaredMetUseImp.setArguments(args);
		return declaredMetUseImp;
	}




	public boolean checkType(){
		boolean result = true;
		String nomMeth = this.methode.getName();
		Classe cl = this.classe.getDeclaration().getClasse();
		LinkedList<Type> listType = new LinkedList<Type>();
		for(Expression e : this.arguments){
			listType.addFirst(e.getType());
		}

		if (cl.containsSignature(this.methode.getName(),listType)){
			this.methode = cl.getSignature(this.methode.getName(), listType);
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	

	public int allocateMemory(Register _register, int _offset){
		throw new SemanticsUndefinedException("allocateMemory() MethodeUseImpl");
	}
	

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getCode() MethodeUseImpl");
	}
}


