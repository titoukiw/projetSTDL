package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;

import java.util.LinkedList;

public class ObjetAllocationImpl implements Expression {

	private Type type; //type -> ClassTypeImpl ou InterfaceTypeImpl 
	private LinkedList<Expression> expressions;

	public ObjetAllocationImpl(Type type, LinkedList<Expression> expressions){
		this.type = type;
		this.expressions = expressions;
	}

	public Type getType(){
		return this.type;
	}

	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		LinkedList<Expression> declaredExpressions = new LinkedList<Expression>();

		for(Expression expr : expressions){
			declaredExpressions.add(expr.makeLiaisonTardive(classes,interfaces));
		}

		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl) this.type).getName())){
					return new ObjetAllocationImpl(new ClasseTypeImpl(classe),declaredExpressions);
				}
			}
			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl) this.type).getName())){
					return new ObjetAllocationImpl(new InterfaceTypeImpl(interf),declaredExpressions);
				}
			}
			return null;
		}
		return new ObjetAllocationImpl(this.type,declaredExpressions);
	}


	public String toString() {
		String toString = "(Allocation) new " + this.type + " ( " + this.expressions + " )";
		return toString;
	}

	public String getLabel(){
		LinkedList<Constructeur> constructeurs = ((ClasseTypeImpl) this.type).getClasse().getConstructeurs();
		for(Constructeur constructeur : constructeurs){
			if(constructeur.getLabelIfEquals(this.expressions) != null){
				return constructeur.getLabelIfEquals(this.expressions);
			}
		}

		return "WRONG_LABEL";
	}

	public Fragment getCode(TAMFactory _factory){
		Fragment code = _factory.createFragment();



		for(Expression e : expressions){
			code.append(e.getCode(_factory));
		}
		code.add(_factory.createCall(this.getLabel(),Register.LB));
		return code;

	}
}