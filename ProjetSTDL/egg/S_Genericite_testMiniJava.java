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
public class S_Genericite_testMiniJava {
LEX_testMiniJava scanner;
  S_Genericite_testMiniJava() {
	}
  S_Genericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LinkedList<ParametreGenericite> att_ast;
  LEX_testMiniJava att_scanner;
  private void regle24() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_24();
  }
private void action_ast_24() throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Genericite -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle24 () ;
  }
  }
