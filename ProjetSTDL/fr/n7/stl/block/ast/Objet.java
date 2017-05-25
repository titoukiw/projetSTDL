package fr.n7.stl.block.ast;

import java.util.LinkedList;

/**
 * @author okeee
 *
 */
public interface Objet extends Declaration {

	public Type getType();

	public boolean checkType();

}