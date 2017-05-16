package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class InterfaceHeritImpl extends InterfaceImpl{

	private LinkedList<Type> heritages; //types hérités

	public InterfaceHeritImpl(String nom, LinkedList<Type> heritages, LinkedList<ElementInterface> elements){
		super(); //super(nom, elements);
		this.heritages = heritages;
	}

	@Override
	public int length(){
		return 99;
	}
}