package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;

public class ClasseGenHeritImpl  extends ClasseImpl implements Classe{

	private Classe heritage; //type hérité
	private LinkedList<ParametreGenericite> parametresGen;

	public ClasseGenHeritImpl(String nom, LinkedList<ParametreGenericite> parametresGen, Classe heritage, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.heritage = heritage;
		this.parametresGen = parametresGen;
	}

}