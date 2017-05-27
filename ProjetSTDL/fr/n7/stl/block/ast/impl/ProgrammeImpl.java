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
		int local_offset = _offset;
		// Memory pour les Final Static Field dans l'interface ?
		// for(Interface interf : interfaces){
		// 	local_offset += interf.allocateMemory(_register,local_offset);
		// }
		for(Classe classe : classes){
			local_offset += classe.allocateMemory(_register,local_offset);
		}
		local_offset += this.classePrincipale.allocateMemory(_register,local_offset);
		this.allocatedSize = local_offset - _offset;

		return 0;
	}

	public Fragment getCode(TAMFactory _factory) {
		Fragment code = _factory.createFragment();
		Fragment codeprinc = _factory.createFragment();
		// Code des Final Static Field dans l'interface ?
		// for(Interface interf : interfaces){
		// 	code.append(interf.getCode(_factory));
		// }
		
		for(Classe classe : classes){
			code.append(classe.getCode(_factory));
		}
		codeprinc.append(classePrincipale.getCode(_factory));
		codeprinc.add(_factory.createHalt());
		codeprinc.append(code);
		//POP allocatedSize ?
		return codeprinc;
	}

}