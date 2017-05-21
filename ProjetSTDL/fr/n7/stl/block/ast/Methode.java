package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

import java.util.LinkedList;

public interface Methode extends ElementClasse {

	public boolean isEqual(Methode meth);

	public LinkedList<Parametre> getParametres();

	public String getClasseCourante();
}