/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;
/**
 * Implementation of the Abstract Syntax Tree node for a type conversion expression.
 * @author Marc Pantel
 *
 */
public class TypeConversionImpl implements Expression {

	private Expression target;
	private Type type;

	public TypeConversionImpl(Expression _target, Type _type) {
		this.target = _target;
		this.type = _type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	public TypeConversionImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredTarget = target.makeLiaisonTardive(classes,interfaces);
		if(declaredTarget == null){
			throw new SemanticsUndefinedException("cant declare " + this.target);
		}

		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new TypeConversionImpl(declaredTarget,new ClasseTypeImpl(classe));
				}
			}
			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new TypeConversionImpl(declaredTarget,new InterfaceTypeImpl(interf));
				}
			}
			return null;
		}

		return new TypeConversionImpl(declaredTarget,this.type);
	}



	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in TypeConversionImpl.");
	}

}
