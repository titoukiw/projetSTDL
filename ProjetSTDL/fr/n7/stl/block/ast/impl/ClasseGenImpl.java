package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.classe;

public class ClasseGenImpl implements Classe extends ClasseImpl {

	private LinkedList<ParametreGenericite> parametresGen;

	public ClasseGenImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.parametresGen = parametresGen;
	}

}