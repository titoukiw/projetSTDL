/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldDeclarationImpl implements FieldDeclaration {

	private String name;
	private Type type;

	public FieldDeclarationImpl(String _name, Type _type) {
		this.name = _name;
		this.type = _type;
	}

	public FieldDeclarationImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new FieldDeclarationImpl(this.name, new ClasseTypeImpl(classe));
				}
			}

			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new FieldDeclarationImpl(this.name, new InterfaceTypeImpl(interf));
				}
			}
			return null;
		}

		return this;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.FieldDeclaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name + ";";
	}

}
