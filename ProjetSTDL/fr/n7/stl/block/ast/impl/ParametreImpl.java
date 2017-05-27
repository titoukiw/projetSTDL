package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

/**
 * @author okeee
 *
 */
import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.Register;

public class ParametreImpl implements Parametre {

	private String id;
	private Type type; //TypeAtomique?
	private Register register;
	private int offset;


	public ParametreImpl(String id, Type type ){
		this.id = id;
		this.type = type;
	}


	public String getName(){
		return this.id;
	}

	public String toString(){
		return "(Parametre) " + this.type + " " + this.id;
	}

	public Type getType(){
		return this.type;
	}

	public int getOffset(){
		return this.offset;
	}


	public Parametre makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new ParametreImpl(this.id,new ClasseTypeImpl(classe));
				}
			}
			for(Interface interf : interfaces){
				return new ParametreImpl(this.id, new InterfaceTypeImpl(interf));
			}

			return null;
		}

		return this;
	}



	public int allocateMemory(Register _register, int _offset){
		this.register = _register;
		this.offset = _offset;
		return this.type.length();
	}

}