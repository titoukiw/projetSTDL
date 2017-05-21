
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
	private LinkedList<Methode> listMethodes;
	private LinkedList<Constructeur> listConstructeurs;


	public FunctionSymbolTable() {
		this.listSignatures = new LinkedList<Signature>();
		this.listMethodes = new LinkedList<Methode>();
		this.listConstructeurs = new LinkedList<Constructeur>();
	}

	/* To complete */



	public boolean containCons(Constructeur cons) {
		for (Constructeur c_element : this.listConstructeurs) {
			if(c_element.isEqual(cons)){
				return true;
			}
		}
		return false;
	}
	public boolean containFun(Methode met) {
		for(Methode m_element : this.listMethodes){
			if(m_element.isEqual(met)){
				return true;
			}
		}
		return false;
	}
	public boolean containSign(Signature sign){
		for(Signature s_element : this.listSignatures){
			if(s_element.isEqual(sign)) {
				return true;
			}
		}
		return false;
	}



	public boolean acceptConst(Constructeur cons) {
		return (!this.containCons(cons));
	}
	public boolean acceptFun(Methode met) {
		return (!this.containFun(met));
	}

	public boolean acceptSign(Signature sign){
		return (!this.containSign(sign));
	}



	public void registerConstructeur(Constructeur cons) throws ForbiddenDeclarationException {
		if(this.acceptConst(cons)) {
			this.listConstructeurs.add(cons);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}

	public void registerFun(Methode met) throws ForbiddenDeclarationException {
		if(this.acceptFun(met)) {
			this.listMethodes.add(met);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}

	public void registerSign(Signature sign, String interfaceCourrante) throws ForbiddenDeclarationException {
		if(this.acceptSign(sign)){
			this.listSignatures.add(sign);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}
}