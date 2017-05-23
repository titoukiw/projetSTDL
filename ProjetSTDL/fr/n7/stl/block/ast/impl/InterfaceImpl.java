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
	private LinkedList<Interface> listHeritage;
	private LinkedList<ElementInterface> listElements;


	public InterfaceImpl(String nom, LinkedList<ElementInterface> elements){
		// this.nom = nom;
		// for (ElementInterface e : elements){
		// 	if (e instanceof Signature ){
		// 		listSign.add((Signature) e);
		// 	} else {
		// 		listFSField.add((FinalStaticField) e);
		// 	}
		// }
	}

	public InterfaceImpl(String nom, LinkedList<Interface> listHeritage, LinkedList<ElementInterface> listElements){
		this.nom = nom;
		this.listHeritage = listHeritage;
		this.listElements = listElements;
	}

	@Override
	public String getName(){
		return this.nom;
	}

	public boolean hasFinalStaticField(String name){
		for(ElementInterface elem : this.listElements){
			if (elem instanceof FinalStaticFieldImpl && name.equals(elem.getName())){
				return true;
			}
		}
		return false;
	}


	public Expression getFinalStaticField(String name){
		for(ElementInterface elem : this.listElements){
			if (elem instanceof FinalStaticFieldImpl && name.equals(elem.getName())){
				return ((FinalStaticField) elem).getExpression();
			}

		}
		return null;
	}

	public Type getType(){
		return new InterfaceTypeImpl(this);
	}

	public String toString(){
		String toString =  "\n (Interface)" + this.getName();


		if(listHeritage.size() >0){
			toString += " extends ";
			for(Interface herit : this.listHeritage){
				toString +=  herit.getName() + ",";
			}
		}

		toString += "{";
		if (listElements.size() > 0){
			for (ElementInterface ei : this.listElements) {
				toString += "\n\t" + ei.toString() ;
			}
		}

		return toString + "\n }";
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

	public boolean equalsTo(Interface inter){
		return this.nom.equals(inter.getName());
	}

	/* does not @Override ?!*/
	public Type merge(Type type){
		return null;
	}
}