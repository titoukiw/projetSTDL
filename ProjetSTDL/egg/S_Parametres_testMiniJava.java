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
public class S_Parametres_testMiniJava {
LEX_testMiniJava scanner;
  S_Parametres_testMiniJava() {
	}
  S_Parametres_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Parametre> att_ast;
  LEX_testMiniJava att_scanner;
  private void regle14() throws Exception {

	//declaration
	S_Parametre_testMiniJava x_2 = new S_Parametre_testMiniJava(scanner,att_eval) ;
	S_SuiteParametres_testMiniJava x_3 = new S_SuiteParametres_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_14(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_ast_14(x_2, x_3);
  }
  private void regle13() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_13();
  }
private void action_ast_14(S_Parametre_testMiniJava x_2, S_SuiteParametres_testMiniJava x_3) throws Exception {
try {
// instructions
this.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Parametres -> Parametre SuiteParametres #ast ;", e });
}
  }
private void action_auto_inh_14(S_Parametre_testMiniJava x_2, S_SuiteParametres_testMiniJava x_3) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_3.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Parametres -> Parametre SuiteParametres #ast ;", e });
}
  }
private void action_ast_13() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Parametre>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Parametres -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_parenthese_fermante : // 32
        regle13 () ;
      break ;
      case LEX_testMiniJava.token_type_bool : // 61
        regle14 () ;
      break ;
      case LEX_testMiniJava.token_type_int : // 60
        regle14 () ;
      break ;
      case LEX_testMiniJava.token_type_char : // 62
        regle14 () ;
      break ;
      case LEX_testMiniJava.token_type_String : // 63
        regle14 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
