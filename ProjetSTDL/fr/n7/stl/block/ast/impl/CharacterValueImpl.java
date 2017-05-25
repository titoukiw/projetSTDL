package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.*;

public class CharacterValueImpl implements CharacterValue {
	
	private char value;
	
	public CharacterValueImpl(String _text) {
		this.value = _text.charAt(1);
	}
	
	public String toString() {
		return new String("'"+ this.value + "'");
	}

	@Override
	public Type getType() {
		return AtomicType.CharacterType;
	}

	public CharacterValueImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		return this;
	}


	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() CharacterValueImpl");
	}


}
