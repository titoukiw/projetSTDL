package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.block.ast.*;


public class ProgrammeImpl implements Programme {

	private LinkedList<Objet> interfaces;

	public ProgrammeImpl(LinkedList<Objet> interfaces) {
		this.interfaces = interfaces;
	}

	public String toString() {
		String result = "";
		for(Objet obj:interfaces){
			result += obj;
		}
		return result;
	}
}