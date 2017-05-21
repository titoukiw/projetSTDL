package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.block.ast.*;


public class ProgrammeImpl implements Programme {

	private LinkedList<Interface> interfaces;
	private LinkedList<Classe> classes

	public ProgrammeImpl(LinkedList<Interface> interfaces, LinkedList<Classe> classes) {
		this.interfaces = interfaces;
		this.classes = classes;
	}

	public String toString() {
		String result = "";
		for(Objet obj:interfaces){
			result += obj.toString();
		}
		for(Classe classe : this.classes) {
			result += classe.toString();
		}
		return result;
	}
}