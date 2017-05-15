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
public class S_Signature_testMiniJava {
LEX_testMiniJava scanner;
  S_Signature_testMiniJava() {
	}
  S_Signature_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ElementInterface att_ast;
  LEX_testMiniJava att_scanner;
  private void regle12() throws Exception {

	//declaration
	S_Type_testMiniJava x_2 = new S_Type_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_4 = new T_testMiniJava(scanner ) ;
	S_Parametres_testMiniJava x_5 = new S_Parametres_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_6 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_2, x_3, x_5);
	x_2.analyser() ;
	x_3.analyser(LEX_testMiniJava.token_identificateur);
	x_4.analyser(LEX_testMiniJava.token_parenthese_ouvrante);
	x_5.analyser() ;
	x_6.analyser(LEX_testMiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_12(x_2, x_3, x_5);
  }
  private void regle11() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_4 = new T_testMiniJava(scanner ) ;
	S_Parametres_testMiniJava x_5 = new S_Parametres_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_6 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_11(x_3, x_5);
	x_2.analyser(LEX_testMiniJava.token_vide);
	x_3.analyser(LEX_testMiniJava.token_identificateur);
	x_4.analyser(LEX_testMiniJava.token_parenthese_ouvrante);
	x_5.analyser() ;
	x_6.analyser(LEX_testMiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_11(x_3, x_5);
  }
private void action_auto_inh_11(T_testMiniJava x_3, S_Parametres_testMiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Signature -> vide identificateur parenthese_ouvrante Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_12(S_Type_testMiniJava x_2, T_testMiniJava x_3, S_Parametres_testMiniJava x_5) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Signature -> Type identificateur parenthese_ouvrante Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_11(T_testMiniJava x_3, S_Parametres_testMiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createSignature(x_3.att_txt, x_5.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Signature -> vide identificateur parenthese_ouvrante Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_12(S_Type_testMiniJava x_2, T_testMiniJava x_3, S_Parametres_testMiniJava x_5) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createSignature(x_3.att_txt, x_2.att_ast, x_5.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Signature -> Type identificateur parenthese_ouvrante Parametres parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_vide : // 59
        regle11 () ;
      break ;
      case LEX_testMiniJava.token_type_bool : // 56
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_int : // 55
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_char : // 57
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_String : // 58
        regle12 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
