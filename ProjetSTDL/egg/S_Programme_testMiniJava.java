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
public class S_Programme_testMiniJava {
LEX_testMiniJava scanner;
  S_Programme_testMiniJava() {
	}
  S_Programme_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  Block att_ast;
  LEX_testMiniJava att_scanner;
  private void regle0() throws Exception {

	//declaration
	S_Interfaces_testMiniJava x_3 = new S_Interfaces_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_factory_0(x_3);
	x_3.analyser() ;
if  (att_eval)	  action_ast3_0(x_3);
  }
private void action_ast3_0(S_Interfaces_testMiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast3","Programme -> #factory Interfaces #ast3 ;", e });
}
  }
private void action_factory_0(S_Interfaces_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds= new SymbolTable();
x_3.att_factory= new InterfaceFactory();
x_3.att_list= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#factory","Programme -> #factory Interfaces #ast3 ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_interface : // 63
        regle0 () ;
      break ;
      case LEX_testMiniJava.EOF :
        regle0 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
