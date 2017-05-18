package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class InterfaceGenImpl extends InterfaceImpl{

	private LinkedList<ArgumentGenericite> parametresGen;

	public InterfaceGenImpl(String nom, LinkedList<ArgumentGenericite> parametresGen, LinkedList<ElementInterface> elements){
		super(nom, elements);
		this.parametresGen = parametresGen;
	}


	@Override
	public int length(){
		return 99;
	}
}