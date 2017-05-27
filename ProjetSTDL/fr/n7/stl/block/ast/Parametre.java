package fr.n7.stl.block.ast;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public interface Parametre extends Declaration{

	public String getName();
	public Type getType();
	public int allocateMemory(Register _register, int _offset);
	public Parametre makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces);
	public int getOffset();
}