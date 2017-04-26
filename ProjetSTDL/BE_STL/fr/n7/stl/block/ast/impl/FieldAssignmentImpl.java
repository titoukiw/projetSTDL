/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class FieldAssignmentImpl extends FieldAccessImpl implements Assignable {

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _name Name of the field in the record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, String _name) {
		super(_record, _name);
	}

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, FieldDeclaration _field) {
		super(_record, _field);
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



		while( (_localRecord instanceof FieldAssignmentImpl)) {

			for(FieldDeclaration fd : ((RecordTypeImpl)_localRecord.getType()).getFields()) {
				if (fd.getName() == _localFD.getName()) {
					break;
				}
				_localOffset += fd.getType().length();
			}
			_localFD = ((RecordTypeImpl)((FieldAssignmentImpl)_localRecord).record.getType()).get(((FieldAssignmentImpl)_localRecord).name).get();
			_localRecord = ((FieldAssignmentImpl) _localRecord).record;
			
			if( !(_localRecord instanceof FieldAssignmentImpl)) {
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
		_fragment.add(_factory.createLoadA(((VariableUseImpl)_localRecord).declaration.getRegister(),_localOffset));
		return _fragment;

	} 

}
