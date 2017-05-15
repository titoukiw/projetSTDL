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
public class S_ArgumentsGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_ArgumentsGenericite_testMiniJava() {
	}
  S_ArgumentsGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<TypeAtomique> att_ast;
  LEX_testMiniJava att_scanner;
  private void regle20() throws Exception {

	//declaration
	S_ArgumentGenericite_testMiniJava x_2 = new S_ArgumentGenericite_testMiniJava(scanner,att_eval) ;
	S_SuiteArgumentsGenericite_testMiniJava x_3 = new S_SuiteArgumentsGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_20(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_ast_20(x_2, x_3);
  }
private void action_auto_inh_20(S_ArgumentGenericite_testMiniJava x_2, S_SuiteArgumentsGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_3.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ArgumentsGenericite -> ArgumentGenericite SuiteArgumentsGenericite #ast ;", e });
}
  }
private void action_ast_20(S_ArgumentGenericite_testMiniJava x_2, S_SuiteArgumentsGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ArgumentsGenericite -> ArgumentGenericite SuiteArgumentsGenericite #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle20 () ;
  }
  }
