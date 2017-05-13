package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

i

public class InterfaceGenHeritImpl implements Interface extends InterfaceImpl{

	private LinkedList<Type> heritages; //types hérités
	private LinkedList<ParametreGenericite> parametresGen;

	public InterfaceGenHeritImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<Type> heritages, LinkedList<ElementInterface> elements){
		super(nom, elements);
		this.heritages = heritages;
		this.parametresGen = parametresGen;
	}

}