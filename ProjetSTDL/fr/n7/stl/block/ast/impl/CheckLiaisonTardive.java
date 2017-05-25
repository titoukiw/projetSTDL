
/**
 * 
 */
package fr.n7.stl.block.ast.impl;

public class CheckLiaisonTardive {

	private boolean succes; // s'il n'y a plus de UndeclaredType
	private String ast; // nouvel ast

	public CheckLiaisonTardive(boolean succes, String ast){
		this.succes = succes;
		this.ast = ast;
	}

	public isSucces(){
		return this.succes;
	}

	public getAst(){
		return this.ast;
	}
}