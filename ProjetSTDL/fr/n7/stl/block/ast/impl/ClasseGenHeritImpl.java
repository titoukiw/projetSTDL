package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.classe;

public class ClasseGenHeritImpl implements Classe extends ClasseImpl {

	private Classe heritage; //type hérité
	private LinkedList<ParametreGenericite> parametresGen;

	public ClasseGenHeritImpl(String nom, LinkedList<ParametreGenericite> parametresGen, Classe heritage, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.heritage = heritage;
		this.parametresGen = parametresGen;
	}

}