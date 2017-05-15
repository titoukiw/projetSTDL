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
public class S_InstanceGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_InstanceGenericite_testMiniJava() {
	}
  S_InstanceGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Type> att_ast;
  LEX_testMiniJava att_scanner;
  private void regle19() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_ArgumentsGenericite_testMiniJava x_3 = new S_ArgumentsGenericite_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_4 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_19(x_3);
	x_2.analyser(LEX_testMiniJava.token_inferieur);
	x_3.analyser() ;
	x_4.analyser(LEX_testMiniJava.token_superieur);
if  (att_eval)	  action_ast_19(x_3);
  }
  private void regle18() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_18();
  }
private void action_ast_18() throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","InstanceGenericite -> #ast ;", e });
}
  }
private void action_ast_19(S_ArgumentsGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","InstanceGenericite -> inferieur ArgumentsGenericite superieur #ast ;", e });
}
  }
private void action_auto_inh_19(S_ArgumentsGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","InstanceGenericite -> inferieur ArgumentsGenericite superieur #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_virgule : // 34
        regle18 () ;
      break ;
      case LEX_testMiniJava.token_accolade_ouvrante : // 22
        regle18 () ;
      break ;
      case LEX_testMiniJava.token_superieur : // 29
        regle18 () ;
      break ;
      case LEX_testMiniJava.token_inferieur : // 28
        regle19 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
