
/**
 * 
 */
package fr.n7.stl.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;


public class FunctionSymbolTable{
	private LinkedList<Signature> listSignatures;
	private LinkedList<Objet> listMethodes;
	private LinkedList<Objet> listConstructeurs;


	public FunctionSymbolTable() {
		this.listSignatures = new LinkedList<Signature>();
		this.listMethodes = new LinkedList<Objet>();
		this.listConstructeurs = new LinkedList<Objet>();
	}

	/* To complete */

	public boolean containSign(Signature sign){
		for(Signature s_element : this.listSignatures){
			if(s_element.isEqual(sign)) {
				return true;
			}
		}
		return false;
	}

	public boolean acceptSign(Signature sign){
		return (!this.containSign(sign));
	}



	public void registerSign(Signature sign, String interfaceCourrante) throws ForbiddenDeclarationException {
		if(this.acceptSign(sign)){
			this.listSignatures.add(sign);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}
}