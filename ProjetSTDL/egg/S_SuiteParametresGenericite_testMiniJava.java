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
public class S_SuiteParametresGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_SuiteParametresGenericite_testMiniJava() {
	}
  S_SuiteParametresGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<ParametreGenericite> att_ast;
  LEX_testMiniJava att_scanner;
  private void regle21() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_ParametreGenericite_testMiniJava x_3 = new S_ParametreGenericite_testMiniJava(scanner,att_eval) ;
	S_SuiteParametresGenericite_testMiniJava x_4 = new S_SuiteParametresGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_21(x_3, x_4);
	x_2.analyser(LEX_testMiniJava.token_virgule);
	x_3.analyser() ;
	x_4.analyser() ;
if  (att_eval)	  action_ast_21(x_3, x_4);
  }
  private void regle22() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_22();
  }
private void action_auto_inh_21(S_ParametreGenericite_testMiniJava x_3, S_SuiteParametresGenericite_testMiniJava x_4) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_3.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","SuiteParametresGenericite -> virgule ParametreGenericite SuiteParametresGenericite1 #ast ;", e });
}
  }
private void action_ast_21(S_ParametreGenericite_testMiniJava x_3, S_SuiteParametresGenericite_testMiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_3.att_ast);
this.att_ast=x_4.att_ast;
this.att_tds.register(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteParametresGenericite -> virgule ParametreGenericite SuiteParametresGenericite1 #ast ;", e });
}
  }
private void action_ast_22() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<ParametreGenericite>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteParametresGenericite -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_virgule : // 39
        regle21 () ;
      break ;
      case LEX_testMiniJava.token_superieur : // 34
        regle22 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
