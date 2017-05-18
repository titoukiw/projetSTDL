package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class InterfaceImpl implements Interface {

	private String nom;
	private LinkedList<Signature> listSign;
	private LinkedList<FinalStaticField> listFSField;


	public InterfaceImpl(String nom, LinkedList<ElementInterface> elements){
		this.nom = nom;
		for (ElementInterface e : elements){
			if (e instanceof Signature ){
				listSign.add((Signature) e);
			} else {
				listFSField.add((FinalStaticField) e);
			}
		}
	}

	@Override
	public String getName(){
		return "(Interface)" + this.nom;
	}

	public String toString(){
		String toString = this.getName();
		if(listSign != null){
			for(Signature sign : listSign){
				toString += sign.toString();
			}
		}
		if (listFSField != null){
			for (FinalStaticField fsf : listFSField) {
				toString += fsf.toString();
			}
		}

		return toString ;
	}

	/* does not @Override ?!*/
	public int length(){
		return 99;
	}

	/* does not @Override ?!*/
	public boolean equalsTo(Type type){
		return true;
	}

	/* does not @Override ?!*/
	public boolean compatibleWith(Type type) {
		return true;
	}

	/* does not @Override ?!*/
	public Type merge(Type type){
		return null;
	}
}