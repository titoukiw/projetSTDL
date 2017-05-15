package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.lex.*;
import mg.egg.eggc.runtime.libjava.*;
import mg.egg.eggc.runtime.libjava.messages.*;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import java.util.Vector;
public class S_TypeAtomique_testMiniJava {
LEX_testMiniJava scanner;
  S_TypeAtomique_testMiniJava() {
	}
  S_TypeAtomique_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Type att_ast;
  LEX_testMiniJava att_scanner;
  private void regle26() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_testMiniJava.token_type_bool);
if  (att_eval)	  action_ast_26();
  }
  private void regle27() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_testMiniJava.token_type_int);
if  (att_eval)	  action_ast_27();
  }
  private void regle28() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_testMiniJava.token_type_char);
if  (att_eval)	  action_ast_28();
  }
  private void regle29() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	//appel
	x_2.analyser(LEX_testMiniJava.token_type_String);
if  (att_eval)	  action_ast_29();
  }
private void action_ast_26() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createBooleanType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","TypeAtomique -> type_bool #ast ;", e });
}
  }
private void action_ast_27() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createIntegerType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","TypeAtomique -> type_int #ast ;", e });
}
  }
private void action_ast_28() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createCharType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","TypeAtomique -> type_char #ast ;", e });
}
  }
private void action_ast_29() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createStringType();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","TypeAtomique -> type_String #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_type_bool : // 56
        regle26 () ;
      break ;
      case LEX_testMiniJava.token_type_int : // 55
        regle27 () ;
      break ;
      case LEX_testMiniJava.token_type_char : // 57
        regle28 () ;
      break ;
      case LEX_testMiniJava.token_type_String : // 58
        regle29 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
