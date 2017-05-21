package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
import java.util.LinkedList;

public class ConstructeurImpl implements Constructeur {

	private String id; //le même que la classe courante
	private LinkedList<Parametre> listParam;
	private Bloc body;
	private DroitAcces droit;

	public ConstructeurImpl(String id, DroitAcces droit, LinkedList<Parametre> listParam, Bloc body){
		this.id = id;
		this.droit = droit;
		this.listParam = listParam;
		this.body = body;
	}

}

