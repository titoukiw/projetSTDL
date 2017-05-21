package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
import java.util.LinkedList;

public class MethodeImpl implements Methode {

	private String id;
	private LinkedList<Parametre> listParam;
	private Bloc body;
	private DroitAcces droit;
	private Boolean statique;
	private Type returnType;

	public ConstructeurImpl(String id, DroitAcces droit, LinkedList<Parametre> listParam,
							Bloc body, Boolean statique, Type returnType){
		this.id = id;
		this.droit = droit;
		this.listParam = listParam;
		this.body = body;
		this.statique = statique;
		this.returnType = returnType;
	}
}


