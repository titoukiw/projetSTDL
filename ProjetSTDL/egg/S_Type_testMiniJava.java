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
public class S_Type_testMiniJava {
LEX_testMiniJava scanner;
  S_Type_testMiniJava() {
	}
  S_Type_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
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
  private void regle25() throws Exception {

	//declaration
	S_TypeAtomique_testMiniJava x_2 = new S_TypeAtomique_testMiniJava(scanner,att_eval) ;
	S_SuiteTypeAtomique_testMiniJava x_4 = new S_SuiteTypeAtomique_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_25(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_inhArray_25(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_25(x_2, x_4);
  }
private void action_ast_25(S_TypeAtomique_testMiniJava x_2, S_SuiteTypeAtomique_testMiniJava x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Type -> TypeAtomique #inhArray SuiteTypeAtomique #ast ;", e });
}
  }
private void action_auto_inh_25(S_TypeAtomique_testMiniJava x_2, S_SuiteTypeAtomique_testMiniJava x_4) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Type -> TypeAtomique #inhArray SuiteTypeAtomique #ast ;", e });
}
  }
private void action_inhArray_25(S_TypeAtomique_testMiniJava x_2, S_SuiteTypeAtomique_testMiniJava x_4) throws Exception {
try {
// instructions
x_4.att_innerArray=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#inhArray","Type -> TypeAtomique #inhArray SuiteTypeAtomique #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle25 () ;
  }
  }
