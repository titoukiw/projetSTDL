/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.Optional;
import java.io.*;
import java.util.LinkedList;
/**
 * Implementation of the Abstract Syntax Tree node for accessing a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAccessImpl implements Expression {

	protected Expression record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _name Name of the field in the record field access expression.
	 */
	public FieldAccessImpl(Expression _record, String _name) {
		this.record = _record;
		this.name = _name;
	}

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field access expression.
	 */
	public FieldAccessImpl(Expression _record, FieldDeclaration _field) {
		this.record = _record;
		this.field = _field;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
	}


	public FieldAccessImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		

		Expression declaredRecord = record.makeLiaisonTardive(classes,interfaces);
		if(declaredRecord == null){
			throw new SemanticsUndefinedException("cannot declare " + this.record);
		}
		
		if(field != null){
			FieldDeclaration declaredField = ((FieldDeclaration) field.makeLiaisonTardive(classes,interfaces));
			if(declaredField == null){
				throw new SemanticsUndefinedException("cannot declare" + this.field);
			}
			return new FieldAccessImpl(declaredRecord,declaredField);
		}

		return new FieldAccessImpl(declaredRecord,this.name);
	}



	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
            Optional<FieldDeclaration> _local;
            if(this.field == null) {
                _local = ((RecordTypeImpl)this.record.getType()).get(this.name);
                if(_local.isPresent()) {
                    this.field = _local.get();
                } else {
                   throw new SemanticsUndefinedException("undefined field");
                }
            }
		return this.field.getType();
	}

	

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int _localOffset = 0;



		Expression _localRecord = this.record;
		FieldDeclaration _localFD = ((RecordTypeImpl)this.record.getType()).get(this.name).get();



//		System.out.println("boucle1");
//		System.out.println(_localRecord instanceof FieldAssignmentImpl);
//		System.out.println("localFD to find" + _localFD);
//		for(FieldDeclaration fd : ((RecordTypeImpl)_localRecord.getType()).getFields()) {
//			System.out.println(fd);
//		}
//
//		_localFD = ((RecordTypeImpl)((FieldAssignmentImpl)_localRecord).record.getType()).get(((FieldAssignmentImpl)_localRecord).name).get();
//		_localRecord = ((FieldAssignmentImpl)this.record).record;
//		
//
//		System.out.println("boucle2");
//		System.out.println(_localRecord instanceof FieldAssignmentImpl);
//		System.out.println("localFD to find" + _localFD );
//		for(FieldDeclaration fd : ((RecordTypeImpl)_localRecord.getType()).getFields()) {
//			System.out.println(fd);
//	}



		while( (_localRecord instanceof FieldAccessImpl)) {

			for(FieldDeclaration fd : ((RecordTypeImpl)_localRecord.getType()).getFields()) {
				if (fd.getName() == _localFD.getName()) {
					break;
				}
				_localOffset += fd.getType().length();
			}
			_localFD = ((RecordTypeImpl)((FieldAccessImpl)_localRecord).record.getType()).get(((FieldAccessImpl)_localRecord).name).get();
			_localRecord = ((FieldAccessImpl) _localRecord).record;
			
			if( !(_localRecord instanceof FieldAccessImpl)) {
				for(FieldDeclaration fd : ((RecordTypeImpl)_localRecord.getType()).getFields()) {

					if (fd.getName() == _localFD.getName()) {
						break;
					}
					_localOffset += fd.getType().length();
				}
			}
		}	

		_localOffset += ((VariableUseImpl)_localRecord).declaration.getOffset();
		Fragment _fragment = _factory.createFragment();
		_fragment.add(_factory.createLoad(((VariableUseImpl)_localRecord).declaration.getRegister(),_localOffset,((RecordTypeImpl)this.record.getType()).get(this.name).get().getType().length()));
		return _fragment;

	}

}
