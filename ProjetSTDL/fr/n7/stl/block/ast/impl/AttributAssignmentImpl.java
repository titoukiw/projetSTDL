package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;
import fr.n7.stl.block.ast.*;


public class AttributAssignmentImpl extends AttributUseImpl implements Assignable {

	private ElementClasse attribut;
	private ClasseUseImpl classe;
	protected Expression value;
	protected Register register;
	protected int offset;


	public AttributAssignmentImpl(ElementClasse att,ClasseUseImpl classe){ //Attribut déjà créé
		super(att, classe);
		this.attribut = att;
		this.classe = classe;
	}
	
	public void setValue(Expression value){
		this.value = value;
	}

	public Type getType(){
		return this.attribut.getType();
	}

	@Override
	public boolean checkType(){
		boolean result;
		if(value.getType().compatibleWith(super.getType())){
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/*@Override
	public Expression makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return new AttributAssignementImpl(attribut.makeLiaisonTardive(classes,interfaces),this.classe);
	}*/

	public String toString() {
		return "(AttributAssignt From " + this.attribut.getClasseCourante() +  " )@{" + this.attribut.getName() + "}";
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