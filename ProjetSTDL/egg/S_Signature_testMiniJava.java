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
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ElementInterface att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  FunctionSymbolTable att_tdsFunctions;
  SymbolTable att_tdsAttributs;
  String att_interfaceCourrante;
  private void regle12() throws Exception {

	//declaration
	S_Type_testMiniJava x_2 = new S_Type_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_4 = new T_testMiniJava(scanner ) ;
	S_Parametres_testMiniJava x_6 = new S_Parametres_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_7 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_12(x_2, x_3, x_6);
	x_2.analyser() ;
	x_3.analyser(LEX_testMiniJava.token_identificateur);
	x_4.analyser(LEX_testMiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_12(x_2, x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_testMiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_12(x_2, x_3, x_6);
  }
  private void regle11() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_4 = new T_testMiniJava(scanner ) ;
	S_Parametres_testMiniJava x_6 = new S_Parametres_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_7 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_11(x_3, x_6);
	x_2.analyser(LEX_testMiniJava.token_vide);
	x_3.analyser(LEX_testMiniJava.token_identificateur);
	x_4.analyser(LEX_testMiniJava.token_parenthese_ouvrante);
if  (att_eval)	  action_tds_11(x_3, x_6);
	x_6.analyser() ;
	x_7.analyser(LEX_testMiniJava.token_parenthese_fermante);
if  (att_eval)	  action_ast_11(x_3, x_6);
  }
private void action_auto_inh_11(T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tds=this.att_tds;
x_6.att_tdsInterfaces=this.att_tdsInterfaces;
x_6.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsFunctions=this.att_tdsFunctions;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Signature -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_tds_12(S_Type_testMiniJava x_2, T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tdsParametres= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#tds","Signature -> Type identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_tds_11(T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
x_6.att_tdsParametres= new SymbolTable();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#tds","Signature -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_12(S_Type_testMiniJava x_2, T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_6.att_tdsInterfaces=this.att_tdsInterfaces;
x_6.att_tdsClasses=this.att_tdsClasses;
x_6.att_tdsFunctions=this.att_tdsFunctions;
x_6.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Signature -> Type identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_11(T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
if ((this.att_tds.knows(x_3.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_SIGNATURE_ident_already_defined, testMiniJavaMessages.SIGNATURE_ident_already_defined,new Object[]{});

}
else {
this.att_ast=this.att_factory.createSignature(x_3.att_txt, x_6.att_ast, this.att_interfaceCourrante);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Signature -> vide identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
private void action_ast_12(S_Type_testMiniJava x_2, T_testMiniJava x_3, S_Parametres_testMiniJava x_6) throws Exception {
try {
// instructions
if ((this.att_tds.knows(x_3.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_SIGNATURE_ident_already_defined, testMiniJavaMessages.SIGNATURE_ident_already_defined,new Object[]{});

}
else {
this.att_ast=this.att_factory.createSignature(x_3.att_txt, x_6.att_ast, this.att_interfaceCourrante, x_2.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Signature -> Type identificateur parenthese_ouvrante #tds Parametres parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_vide : // 54
        regle11 () ;
      break ;
      case LEX_testMiniJava.token_type_bool : // 51
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_int : // 50
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_char : // 52
        regle12 () ;
      break ;
      case LEX_testMiniJava.token_type_String : // 53
        regle12 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
