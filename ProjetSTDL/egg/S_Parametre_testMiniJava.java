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
public class S_Parametre_testMiniJava {
LEX_testMiniJava scanner;
  S_Parametre_testMiniJava() {
	}
  S_Parametre_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Parametre att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  FunctionSymbolTable att_tdsFunctions;
  SymbolTable att_tdsAttributs;
  SymbolTable att_tdsParametres;
  private void regle17() throws Exception {

	//declaration
	S_Type_testMiniJava x_2 = new S_Type_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_17(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser(LEX_testMiniJava.token_identificateur);
if  (att_eval)	  action_ast_17(x_2, x_3);
  }
private void action_ast_17(S_Type_testMiniJava x_2, T_testMiniJava x_3) throws Exception {
try {
// instructions
if (this.att_tds.contains(x_3.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_PARAMETRE_already_defined, testMiniJavaMessages.PARAMETRE_already_defined,new Object[]{""+x_3.att_txt});

}
else {
this.att_ast=this.att_factory.createParametre(x_3.att_txt, x_2.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Parametre -> Type identificateur #ast ;", e });
}
  }
private void action_auto_inh_17(S_Type_testMiniJava x_2, T_testMiniJava x_3) throws Exception {
try {
// instructions
x_2.att_tds=this.att_tds;
x_2.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Parametre -> Type identificateur #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle17 () ;
  }
  }
