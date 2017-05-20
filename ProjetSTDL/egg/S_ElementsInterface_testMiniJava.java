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
public class S_ElementsInterface_testMiniJava {
LEX_testMiniJava scanner;
  S_ElementsInterface_testMiniJava() {
	}
  S_ElementsInterface_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<ElementInterface> att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  FunctionSymbolTable att_tdsFunctions;
  String att_interfaceCourrante;
  private void regle9() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_9();
  }
  private void regle8() throws Exception {

	//declaration
	S_ElementInterface_testMiniJava x_2 = new S_ElementInterface_testMiniJava(scanner,att_eval) ;
	S_ElementsInterface_testMiniJava x_4 = new S_ElementsInterface_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_register_8(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_8(x_2, x_4);
  }
private void action_ast_9() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<ElementInterface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ElementsInterface -> #ast ;", e });
}
  }
private void action_auto_inh_8(S_ElementInterface_testMiniJava x_2, S_ElementsInterface_testMiniJava x_4) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tdsInterfaces=this.att_tdsInterfaces;
x_4.att_tdsInterfaces=this.att_tdsInterfaces;
x_2.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsFunctions=this.att_tdsFunctions;
x_4.att_tdsFunctions=this.att_tdsFunctions;
x_2.att_interfaceCourrante=this.att_interfaceCourrante;
x_4.att_interfaceCourrante=this.att_interfaceCourrante;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ElementsInterface -> ElementInterface #register ElementsInterface1 #ast ;", e });
}
  }
private void action_register_8(S_ElementInterface_testMiniJava x_2, S_ElementsInterface_testMiniJava x_4) throws Exception {
try {
// instructions
this.att_tds.register(x_2.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#register","ElementsInterface -> ElementInterface #register ElementsInterface1 #ast ;", e });
}
  }
private void action_ast_8(S_ElementInterface_testMiniJava x_2, S_ElementsInterface_testMiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ElementsInterface -> ElementInterface #register ElementsInterface1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_vide : // 54
        regle8 () ;
      break ;
      case LEX_testMiniJava.token_type_bool : // 51
        regle8 () ;
      break ;
      case LEX_testMiniJava.token_type_int : // 50
        regle8 () ;
      break ;
      case LEX_testMiniJava.token_type_char : // 52
        regle8 () ;
      break ;
      case LEX_testMiniJava.token_type_String : // 53
        regle8 () ;
      break ;
      case LEX_testMiniJava.token_accolade_fermante : // 18
        regle9 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
