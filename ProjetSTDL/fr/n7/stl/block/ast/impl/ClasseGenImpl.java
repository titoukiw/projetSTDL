package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ParametreGenericite;
import java.util.LinkedList;

public class ClasseGenImpl extends ClasseImpl implements Classe  {

	private LinkedList<ParametreGenericite> parametresGen;

	public ClasseGenImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<ElementClasse> elements){
		super(nom, elements);
		this.parametresGen = parametresGen;
	}

}