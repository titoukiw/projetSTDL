package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.AtomicType;
import java.util.LinkedList;

public class SignatureImpl implements Signature {

	private String id;
	private LinkedList<Parametre> listParam;
	private String interfaceCourrante;
	private Type returnType;

	//Void method contructor
	public SignatureImpl(String id, LinkedList<Parametre> listParam, String nomInterface ){
		this.id = id;
		this.listParam = listParam;
		this.returnType = AtomicType.VoidType;
		this.interfaceCourrante = nomInterface;
	}

	public SignatureImpl(String id, Type type, LinkedList<Parametre> listParam, String nomInterface){
		this.id = id;
		this.listParam = listParam;
		this.returnType = type;
		this.interfaceCourrante = nomInterface;
	}

	@Override
	public String getName(){
		return this.id;
	}

	public Type getType(){
		return this.returnType;
	}

	public String toString(){
		String result = "\n (Signature)" + "[" + this.interfaceCourrante + "] " + this.returnType.toString() + " " + this.id + " (";
		for (Parametre param : listParam){
			result += param.getType().toString() + " " + param.getName() + ",";
		}
		return result + ")";


	}

	public LinkedList<Parametre> getParametres(){
		return this.listParam;
	}

	public String getInterfaceCourrante(){
		return this.interfaceCourrante;
	}

	public boolean isEqual(Signature sin){
		if(this.id == sin.getName() && this.interfaceCourrante == sin.getInterfaceCourrante() && this.listParam.size() == sin.getParametres().size()){
			for(int i=0;i<this.listParam.size();i++){
				if(!this.listParam.get(i).getType().equals(sin.getParametres().get(i).getType())){
					break;
				}
				if(i + 1 == this.listParam.size()){
					return true;
				}
			}
		}
		return false;
	}
}