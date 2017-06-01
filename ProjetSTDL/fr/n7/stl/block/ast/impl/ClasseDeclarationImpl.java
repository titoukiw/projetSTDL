package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;


public class ClasseDeclarationImpl implements ClasseDeclaration {

	private String nom;
	private Type type;
	private Expression value;
	private Register register;
	private int offset;
	private Classe classe;


	public ClasseDeclarationImpl(String name, Type typ, Expression expr){
		this.nom = name;
		this.type = typ;
		this.value = expr;
		if(this.type instanceof ClasseTypeImpl){
			this.classe = ((ClasseTypeImpl) this.type).getClasse() ;
		}
	}

	public Classe getClasse(){
		return this.classe;
	}

	public Type getType(){
		return this.type;
	}

	public ClasseDeclarationImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredValue = value.makeLiaisonTardive(classes,interfaces);
		if(declaredValue == null){
			throw new SemanticsUndefinedException("cant declare " + this.value);
		}
		this.value = declaredValue;
		if(this.type instanceof UndeclaredTypeImpl){
			this.type = ((UndeclaredTypeImpl)this.type).makeLiaisonTardive(classes,interfaces);
			if(this.type == null){
				throw new SemanticsUndefinedException("cant declare " + this.type);
			}
			this.classe = ((ClasseTypeImpl) this.type).getClasse();
		}
		
		return this;
	}

	public Register getRegister(){
		return this.register;
	}

	public String toString(){
		String toString = "(ClasseDeclaration)" + this.type + " " + this.nom + " = " + this.value + ";\n";
		return toString;
	}

	public String getName(){
		return this.nom;
	}

	public int getOffset(){
		return this.offset;
	}

	public boolean checkType(){
		boolean result;
		result = this.value.getType().compatibleWith(this.type) && this.classe.checkType(); 
		return result;
	}

	public int allocateMemory(Register register, int offset){
		this.register =  register;
		this.offset = offset;
		return 1;
	}

	public Fragment getCode(TAMFactory factory){
		Fragment fragment = factory.createFragment();
		fragment.add(factory.createLoadL(this.type.length()));
		fragment.add(Library.MAlloc);
		fragment.append(this.value.getCode(factory));
		return fragment;
	}


}
