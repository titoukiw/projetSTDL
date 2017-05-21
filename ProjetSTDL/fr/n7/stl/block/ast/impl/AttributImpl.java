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
	private boolean statique;
	private String classeCourante;

	public AttributImpl(String id, String classeCourante, Type type, DroitAcces droit, boolean statique){
		this.id = id;
		this.type = type;
		this.droit = droit;
		this.statique = statique;
		this.classeCourante = classeCourante;
	}

	public String getClasseCourante(){
		return this.classeCourante;
	}

	public String getName(){
		return this.id;
	}

}
