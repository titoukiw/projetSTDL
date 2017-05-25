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

	public Fragment getCode(TAMFactory _factory){
		throw new SemanticsUndefinedException("getcode() ObjetAllocationImpl");
	}
}