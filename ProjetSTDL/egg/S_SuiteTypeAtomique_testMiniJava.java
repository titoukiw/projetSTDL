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
public class S_SuiteTypeAtomique_testMiniJava {
LEX_testMiniJava scanner;
  S_SuiteTypeAtomique_testMiniJava() {
	}
  S_SuiteTypeAtomique_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
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
  Type att_innerArray;
  private void regle30() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	S_SuiteTypeAtomique_testMiniJava x_5 = new S_SuiteTypeAtomique_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_30(x_5);
	x_2.analyser(LEX_testMiniJava.token_crochet_ouvrant);
	x_3.analyser(LEX_testMiniJava.token_crochet_fermant);
if  (att_eval)	  action_inhArray_30(x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_30(x_5);
  }
  private void regle31() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_31();
  }
private void action_auto_inh_30(S_SuiteTypeAtomique_testMiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inhArray SuiteTypeAtomique1 #ast ;", e });
}
  }
private void action_inhArray_30(S_SuiteTypeAtomique_testMiniJava x_5) throws Exception {
try {
// instructions
x_5.att_innerArray=this.att_factory.createArrayType(this.att_innerArray);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#inhArray","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inhArray SuiteTypeAtomique1 #ast ;", e });
}
  }
private void action_ast_30(S_SuiteTypeAtomique_testMiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteTypeAtomique -> crochet_ouvrant crochet_fermant #inhArray SuiteTypeAtomique1 #ast ;", e });
}
  }
private void action_ast_31() throws Exception {
try {
// instructions
this.att_ast=this.att_innerArray;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteTypeAtomique -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_crochet_ouvrant : // 24
        regle30 () ;
      break ;
      case LEX_testMiniJava.token_identificateur : // 76
        regle31 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
