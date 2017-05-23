package fr.n7.stl.block.ast;

import java.util.LinkedList;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;



public interface ClassePrincipale {

	public boolean checkType();

	public int allocateMemory(Register _register, int _offset);

	public Fragment getCode(TAMFactory _factory);
}