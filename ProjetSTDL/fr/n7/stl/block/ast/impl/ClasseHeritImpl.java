package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.classe;

public class ClasseHeritImpl implements Classe extends ClasseImpl {

	private Classe heritage; //type hérité

	public ClasseGenHeritImpl(String nom, Classe heritage, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.heritage = heritage;
	}

}