package fr.n7.stl.block.ast.impl;

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

	@Override
	public int length(){
		return 99;
	}

	@Override
	public Type merge(){
		return null;
	}
}