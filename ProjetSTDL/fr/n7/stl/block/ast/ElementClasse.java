package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public interface ElementClasse extends Declaration, Expression {

	public String getClasseCourante();
	public Type getType();
	public boolean checkType();
	public int length();
	public ElementClasse makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces);
}