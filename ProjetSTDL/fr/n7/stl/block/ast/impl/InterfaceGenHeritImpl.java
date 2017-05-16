package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */
import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class InterfaceGenHeritImpl implements Interface extends InterfaceImpl{

	private LinkedList<Type> heritages; //types hérités
	private LinkedList<ParametreGenericite> parametresGen;

	public InterfaceGenHeritImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<Type> heritages, LinkedList<ElementInterface> elements){
		super(); //super(nom, elements);
		this.heritages = heritages;
		this.parametresGen = parametresGen;
	}

	public String getName(){
		return super.getName();
	}
}