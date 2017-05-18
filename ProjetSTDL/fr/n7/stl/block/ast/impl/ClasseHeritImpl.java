package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.Classe;
import java.util.LinkedList;

public class ClasseHeritImpl  extends ClasseImpl implements Classe {

	private Classe heritage; //type hérité

	public ClasseHeritImpl(String nom, Classe heritage, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.heritage = heritage;
	}

}