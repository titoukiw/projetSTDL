package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.*;
public interface Parametre extends Declaration{

	public String getName();
	public Type getType();
	public int allocateMemory(Register _register, int _offset);

}