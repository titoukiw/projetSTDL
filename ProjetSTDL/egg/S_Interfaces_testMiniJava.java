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
public class S_Interfaces_testMiniJava {
LEX_testMiniJava scanner;
  S_Interfaces_testMiniJava() {
	}
  S_Interfaces_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Objet> att_ast;
  LEX_testMiniJava att_scanner;
  LinkedList<Objet> att_list;
  private void regle2() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_2();
  }
  private void regle1() throws Exception {

	//declaration
	S_Interface_testMiniJava x_2 = new S_Interface_testMiniJava(scanner,att_eval) ;
	S_Interfaces_testMiniJava x_3 = new S_Interfaces_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_1(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_ast_1(x_2, x_3);
  }
private void action_ast_1(S_Interface_testMiniJava x_2, S_Interfaces_testMiniJava x_3) throws Exception {
try {
// instructions
this.att_list.add(x_2.att_ast);
this.att_ast=x_3.att_ast;
this.att_tds.register(x_2.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Interfaces -> Interface Interfaces1 #ast ;", e });
}
  }
private void action_ast_2() throws Exception {
try {
// instructions
this.att_ast=this.att_list;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Interfaces -> #ast ;", e });
}
  }
private void action_auto_inh_1(S_Interface_testMiniJava x_2, S_Interfaces_testMiniJava x_3) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_3.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_3.att_tds=this.att_tds;
x_3.att_list=this.att_list;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Interfaces -> Interface Interfaces1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_interface : // 68
        regle1 () ;
      break ;
      case LEX_testMiniJava.EOF :
        regle2 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
