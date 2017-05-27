package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface ElementClasse extends Declaration, Expression {

	public String getClasseCourante();
	public Type getType();
	public boolean checkType();
	public int length();
	public int allocateMemory(Register registre, int offset);
	public ElementClasse makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces);
}