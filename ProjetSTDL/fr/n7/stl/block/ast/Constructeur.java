package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

import java.util.LinkedList;

public interface Constructeur extends ElementClasse {

	public boolean isEqual(Constructeur cons);

	public LinkedList<Parametre> getParametres();

	public String getClasseCourante();
	public String getLabelIfEquals(LinkedList<Expression> expr);
}