package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class InterfaceGenImpl implements Interface extends InterfaceImpl{

	private LinkedList<ParametreGenericite> parametresGen;

	public InterfaceGenImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<ElementInterface> elements){
		super(); //super(nom, elements);
		this.parametresGen = parametresGen;
	}

	public String getName(){
		return super.getName();
	}
}