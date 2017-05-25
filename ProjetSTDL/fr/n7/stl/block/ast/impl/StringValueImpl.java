
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

public class StringValueImpl implements StringValue{
	
	private String value;
	
	public StringValueImpl(String _text) {
		this.value = _text;
	}

	public String toString() {
		return this.value;
	}
	
	@Override
	public Type getType() {
		return AtomicType.StringType;
	}

	public StringValueImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return this;
	}


	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() StringValueImpl");
	}

}