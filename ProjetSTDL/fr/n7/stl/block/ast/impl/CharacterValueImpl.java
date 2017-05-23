package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
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

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() CharacterValueImpl");
	}


}
