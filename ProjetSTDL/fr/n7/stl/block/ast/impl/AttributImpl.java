package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
import java.util.LinkedList;

public class AttributImpl implements Attribut {

	private String id;
	private Type type;
	private DroitAcces droit;
	private Boolean statique;

	public AttributImpl(String id, Type type, DroitAcces droit, Boolean statique){
		this.id = id;
		this.type = type;
		this.droit = droit;
		this.statique = statique;
	}

	public setValue(Expression expr){
	} //mtn?

}
