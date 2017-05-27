package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import fr.n7.stl.block.ast.*;
import java.io.*;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ProgrammeImpl implements Programme {

	private LinkedList<Interface> interfaces;
	private LinkedList<Classe> classes;
	private ClassePrincipale classePrincipale;
	protected int allocatedSize;

	public ProgrammeImpl(LinkedList<Interface> interfaces, LinkedList<Classe> classes, ClassePrincipale classePrincipale) {
		this.interfaces = interfaces;
		this.classes = classes;
		this.classePrincipale = classePrincipale;
	}

	public String toString() {
		String result = "";
		for(Objet obj:interfaces){
			result += obj.toString();
		}
		for(Classe classe : this.classes) {
			result += classe.toString();
		}
		result += "\n " + this.classePrincipale.toString();
		return result;
	}

	public void makeLiaisonTardive() {
		LinkedList<Classe> declaredClasses = new LinkedList<Classe>();
		for (Classe classe : this.classes) {
			declaredClasses.add(((Classe)classe.makeLiaisonTardive(this.classes,this.interfaces)));
		}
		this.classes = declaredClasses;
	}

	public boolean checkType(){
		boolean result = true;
		for(Interface inter : interfaces){
			result = result && inter.checkType();
			if(!result){
				break;
			}
		}
		for (Classe cl : classes){
			result = result && cl.checkType();
			if(!result){
				break;
			}			
		}
		result = result && classePrincipale.checkType();

		return result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	public int allocateMemory(Register _register, int _offset) {
		return this.classePrincipale.allocateMemory(_register,_offset);
	}

}