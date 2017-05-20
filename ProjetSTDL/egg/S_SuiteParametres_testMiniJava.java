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
public class S_SuiteParametres_testMiniJava {
LEX_testMiniJava scanner;
  S_SuiteParametres_testMiniJava() {
	}
  S_SuiteParametres_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Parametre> att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  FunctionSymbolTable att_tdsFunctions;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsParametres;
  private void regle15() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_15();
  }
  private void regle16() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_Parametre_testMiniJava x_3 = new S_Parametre_testMiniJava(scanner,att_eval) ;
	S_SuiteParametres_testMiniJava x_5 = new S_SuiteParametres_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_16(x_3, x_5);
	x_2.analyser(LEX_testMiniJava.token_virgule);
	x_3.analyser() ;
if  (att_eval)	  action_register_16(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_16(x_3, x_5);
  }
private void action_ast_15() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Parametre>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteParametres -> #ast ;", e });
}
  }
private void action_ast_16(S_Parametre_testMiniJava x_3, S_SuiteParametres_testMiniJava x_5) throws Exception {
try {
// instructions
x_5.att_ast.addFirst(x_3.att_ast);
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteParametres -> virgule Parametre #register SuiteParametres1 #ast ;", e });
}
  }
private void action_auto_inh_16(S_Parametre_testMiniJava x_3, S_SuiteParametres_testMiniJava x_5) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_3.att_tdsInterfaces=this.att_tdsInterfaces;
x_5.att_tdsInterfaces=this.att_tdsInterfaces;
x_3.att_tdsClasses=this.att_tdsClasses;
x_5.att_tdsClasses=this.att_tdsClasses;
x_3.att_tdsFunctions=this.att_tdsFunctions;
x_5.att_tdsFunctions=this.att_tdsFunctions;
x_3.att_tdsAttributs=this.att_tdsAttributs;
x_5.att_tdsAttributs=this.att_tdsAttributs;
x_3.att_tdsParametres=this.att_tdsParametres;
x_5.att_tdsParametres=this.att_tdsParametres;
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","SuiteParametres -> virgule Parametre #register SuiteParametres1 #ast ;", e });
}
  }
private void action_register_16(S_Parametre_testMiniJava x_3, S_SuiteParametres_testMiniJava x_5) throws Exception {
try {
// instructions
this.att_tdsParametres.register(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#register","SuiteParametres -> virgule Parametre #register SuiteParametres1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_parenthese_fermante : // 22
        regle15 () ;
      break ;
      case LEX_testMiniJava.token_virgule : // 29
        regle16 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
