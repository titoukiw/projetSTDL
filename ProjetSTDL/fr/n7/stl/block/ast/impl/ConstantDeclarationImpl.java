/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import fr.n7.stl.tam.ast.*;
import java.util.LinkedList;

/**
 * Implementation of the Abstract Syntax Tree node for a constant declaration instruction.
 * @author Marc Pantel
 *
 */
public class ConstantDeclarationImpl implements ConstantDeclaration {

	private String name;
	protected Type type;
	protected Expression value;

	public ConstantDeclarationImpl(String _name, Type _type, Expression _value) {
		this.name = _name;
		this.type = _type;
		this.value = _value;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "const " + this.type + " " + this.name + " = " + this.value + ";\n";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	public ConstantDeclarationImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
		Expression declaredValue = value.makeLiaisonTardive(classes,interfaces);
		if(declaredValue == null){
			throw new SemanticsUndefinedException("cant decalre " + this.value);
		}

		if(this.type instanceof UndeclaredTypeImpl){
			for(Classe classe : classes){
				if(classe.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new ConstantDeclarationImpl(this.name,new ClasseTypeImpl(classe),declaredValue);
				}
			}

			for(Interface interf : interfaces){
				if(interf.getName().equals(((UndeclaredTypeImpl)this.type).getName())){
					return new ConstantDeclarationImpl(this.name,new InterfaceTypeImpl(interf),declaredValue);
				}
			}
			return null;
		}
		return new ConstantDeclarationImpl(this.name,this.type,declaredValue);
	}

	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ConstantDeclaration#getValue()
	 */
	@Override
	public Expression getValue() {
		return this.value;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
	        return this.value.getType().compatibleWith(this.type);
        }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}

}
