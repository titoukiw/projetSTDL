/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.*;
import java.util.LinkedList;



/**
 * Implementation of the factory for building Abstract Syntax Tree node for the Bloc language.
 * @author Marc Pantel
 *
 */
public class BlockFactoryImpl implements BlockFactory {

	/**
	 * 
	 */
	public BlockFactoryImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createBinaryExpression(fr.n7.block.ast.Expression, fr.n7.block.ast.Expression)
	 */
	@Override
	public Expression createBinaryExpression(Expression _left, BinaryOperator _operator, Expression _right) {
		return new BinaryExpressionImpl(_left,_operator,_right);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createIntegerValue()
	 */
	@Override
	public Value createIntegerValue(String _texte) {
		return new IntegerValueImpl(_texte);
	}

	public Value createCharacterValue(String _texte){
		return new CharacterValueImpl(_texte);
	}

	public Value createStringValue(String _texte){
		return new StringValueImpl(_texte);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createBlock()
	 */
	@Override
	public Block createBlock(Block _context) {
		return new BlockImpl(_context);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createVariableDeclaration(java.lang.String, fr.n7.block.ast.Type, fr.n7.block.ast.Expression)
	 */
	@Override
	public VariableDeclaration createVariableDeclaration(String _name, Type _type, Expression _initialValue) {
		return new VariableDeclarationImpl(_name,_type,_initialValue);
	}

	public ClasseDeclaration createClasseDeclaration(String name, Type type, Expression expr){
		return new ClasseDeclarationImpl(name,type,expr);
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.ASTFactory#createIntegerType()
	 */
	@Override
	public Type createIntegerType() {
		return AtomicType.IntegerType;
	}

	public Type createInterfaceType(Interface inter){
		return new InterfaceTypeImpl(inter);
	}

	public ClasseTypeImpl createClasseType(Classe classe) {
		return new ClasseTypeImpl(classe);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createUnaryExpression(fr.n7.stl.block.ast.UnaryOperator, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createUnaryExpression(UnaryOperator _operator, Expression _parameter) {
		return new UnaryExpressionImpl(_operator,_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableUse(fr.n7.stl.block.ast.VariableDeclaration)
	 */
	@Override
	public Expression createVariableUse(VariableDeclaration _declaration) {
		return new VariableUseImpl(_declaration);
	}

	public Expression createClasseUse(ClasseDeclaration _declaration){
		return new ClasseUseImpl(_declaration);
	}
	
	public ClassePrincipale createClassePrincipale(String nom, Block bloc){
		return new ClassePrincipaleImpl(nom,bloc);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createVariableAssignment(fr.n7.stl.block.ast.VariableDeclaration)
	 */
	@Override
	public Assignable createVariableAssignment(VariableDeclaration _declaration) {
		return new VariableAssignmentImpl(_declaration);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createConditional(Expression _condition, Block _then, Block _else) {
		return new ConditionalImpl(_condition,_then,_else);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createRepetition(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createRepetition(Expression _condition, Block _body) {
		return new RepetitionImpl(_condition,_body);
	}

	public Instruction createReturn(Expression _value) {
		return new ReturnImpl(_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createBooleanType()
	 */
	@Override
	public Type createBooleanType() {
		return AtomicType.BooleanType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createPrinter(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createPrinter(Expression _value) {
		return new PrinterImpl(_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createAssignment(VariableDeclaration _declaration, Expression _value) {
		return new AssignmentImpl(_declaration,_value);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createAssignment(fr.n7.stl.block.ast.VariableDeclaration, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Instruction createAssignment(Assignable _assignable, Expression _value) {
		return new AssignmentImpl(_assignable,_value);
	}

	public Expression createAssignment(Expression assignable, Expression value) {
		return new AssignmentImpl(assignable,value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createBooleanValue(boolean)
	 */
	@Override
	public Value createBooleanValue(boolean _value) {
		if (_value) {
			return BooleanValue.True;
		} else {
			return BooleanValue.False;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createFunctionCall(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public FunctionCall createFunctionCall(Expression _function) {
		return new FunctionCallImpl(_function);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAccess(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Expression createArrayAccess(Expression _array, Expression _index) {
		return new ArrayAccessImpl(_array,_index);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createArrayAssignment(fr.n7.stl.block.ast.Assignable, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public Assignable createArrayAssignment(Assignable _array, Expression _index) {
		return new ArrayAssignmentImpl(_array,_index);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock()
	 */
	@Override
	public Block createBlock() {
		return createBlock((Block)null);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(java.lang.Iterable)
	 */
	@Override
	public Block createBlock(Iterable<Instruction> _content) {
		Block _local = createBlock();
		_local.addAll(_content);
		return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createBlock(fr.n7.stl.block.ast.Block, java.lang.Iterable)
	 */
	@Override
	public Block createBlock(Block _context, Iterable<Instruction> _content) {
		Block _local = createBlock(_context);
		_local.addAll(_content);
		return _local;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConditional(fr.n7.stl.block.ast.Expression, fr.n7.stl.block.ast.Block)
	 */
	@Override
	public Instruction createConditional(Expression _condition, Block _then) {
		return new ConditionalImpl(_condition,_then);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.InstructionFactory#createConstantDeclaration(java.lang.String, fr.n7.stl.block.ast.Type, fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public ConstantDeclaration createConstantDeclaration(String _name, Type _type, Expression _value) {
		return new ConstantDeclarationImpl(_name,_type,_value);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createArrayType(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type createArrayType(Type _element) {
		return new ArrayTypeImpl(_element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createFunctionType(fr.n7.stl.block.ast.Type, java.lang.Iterable)
	 */
	@Override
	public Type createFunctionType(Type _result, Iterable<Type> _parameters) {
		return new FunctionTypeImpl(_result,_parameters);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection()
	 */
	@Override
	public Sequence createSequence() {
		return new SequenceImpl();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.ExpressionFactory#createCollection(java.lang.Iterable)
	 */
	@Override
	public Sequence createSequence(Iterable<Expression> _values) {
		return new SequenceImpl(_values);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createFloatingType()
	 */
	@Override
	public Type createFloatingType() {
		return AtomicType.FloatingType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createCharType()
	 */
	@Override
	public Type createCharType() {
		return AtomicType.CharacterType;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.TypeFactory#createStringType()
	 */
	@Override
	public Type createStringType() {
		return AtomicType.StringType;
	}

    /* (non-Javadoc)
    * @see fr.n7.stl.block.ast.TypeFactory#createArrayAllocation(Type _type, Expression _size)
    */
    public Expression createArrayAllocation(Type _type, Expression _size) {
    	return new ArrayAllocationImpl(_type,_size);
    }

    public Expression createObjetAllocation(Type type, LinkedList<Expression> expressions){
    	return new ObjetAllocationImpl(type,expressions);
    }

    /* PROJET ------------------------------------------------------------>>>>>>>>>>>>>>>>>> */

    /* createInterface */
	public Interface createInterface(String nom, LinkedList<Interface> heritages, LinkedList<ElementInterface> elements){
		return new InterfaceImpl(nom,heritages,elements);
	}
	/* END createInterface */

	/* Genericite */
	public ArgumentGenericite createArgumentGenericite(Objet obj, LinkedList<Type> instType){ //avant:  ArgumentGenericite
		return new ArgumentGenericiteImpl(obj,instType);
	}

	public ArgumentGenericite createArgumentGenericite(Objet obj){ //idem
		return new ArgumentGenericiteImpl(obj);
	}	
	public Type createGenericType(Objet obj) {
		return new GenericTypeImpl(obj);
	}
	public Type createGenericType(Objet obj, LinkedList<Type> instGen){
		return new GenericTypeImpl(obj,instGen);
	}

	/* END Genericite */

	/* ElementInterface etc */
	public Signature createSignature(String id, LinkedList<Parametre> listParam, String nomInterface){
		return new SignatureImpl(id, listParam,nomInterface);
	}

	public Signature createSignature(String id,Type type, LinkedList<Parametre> listParam, String nomInterface){
		return new SignatureImpl(id, type, listParam, nomInterface);
	}

	public Parametre createParametre(String id, Type type){
		return new ParametreImpl(id,type);
	}

	public Expression createParametreUse(Parametre param){
		return new ParametreUseImpl(param);
	}
	public Programme createProgramme(LinkedList<Interface> interfaces, LinkedList<Classe> classes, ClassePrincipale classePrincipale) {
		return new ProgrammeImpl(interfaces, classes, classePrincipale);
	}
	// Classes TypeGenerique ArgumentGenericite 
	public FinalStaticField createFinalStaticField(String id,String objetCourrant,Type type, Expression expr){
		return new FinalStaticFieldImpl(id, objetCourrant,type, expr);
	}

	/*  Objet....*/

	/* Classe */
	public Classe createClasse(String nom, LinkedList<Classe> heritages, LinkedList<Interface> impl,LinkedList<ElementClasse> elements){
		return new ClasseImpl(nom, impl, heritages, elements);
	}
	/*END Classe*/

	/*Elements Classe*/
	public Constructeur createConstructeur(String id, String classeCourante, DroitAcces droit, LinkedList<Parametre> listParam, Block body){
		return new ConstructeurImpl(id, classeCourante, droit, listParam, body);
	}
	
	public Methode createMethode(String id, String classeCourante, DroitAcces droit, 
							     LinkedList<Parametre> listParam, Block body, boolean statique, Type returnType){
		return new MethodeImpl(id, classeCourante, droit, listParam, body, statique, returnType);
	}

	public Expression createMethodeUse(Methode methode,ClasseUseImpl classe){
		return new MethodeUseImpl(methode,classe);
	}

	public Attribut createAttribut(String id, String classeCourante, Type type, DroitAcces droit, boolean statique){
		return new AttributImpl(id, classeCourante, type, droit, statique);
	}

	public Expression createAttributUse(ElementClasse attribut,ClasseUseImpl classe){
		return new AttributUseImpl(attribut,classe);
	}
	
	public Expression createAttributAssignment(ElementClasse attribut,ClasseUseImpl classe){
		return new AttributAssignmentImpl(attribut,classe);
	}

	public Type createUndeclaredType(String id_type){
		return new UndeclaredTypeImpl(id_type);
	}

	/*END Elements Classe*/




}
