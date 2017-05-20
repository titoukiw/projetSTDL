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
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Interface> att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  FunctionSymbolTable att_tdsFunctions;
  SymbolTable att_tdsAttributs;
  private void regle2() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_2();
  }
  private void regle1() throws Exception {

	//declaration
	S_Interface_testMiniJava x_2 = new S_Interface_testMiniJava(scanner,att_eval) ;
	S_Interfaces_testMiniJava x_4 = new S_Interfaces_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_1(x_2, x_4);
	x_2.analyser() ;
if  (att_eval)	  action_interfaceMultiple_1(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_1(x_2, x_4);
  }
private void action_ast_1(S_Interface_testMiniJava x_2, S_Interfaces_testMiniJava x_4) throws Exception {
try {
// instructions
x_4.att_ast.addFirst(x_2.att_ast);
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Interfaces -> Interface #interfaceMultiple Interfaces1 #ast ;", e });
}
  }
private void action_ast_2() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Interfaces -> #ast ;", e });
}
  }
private void action_auto_inh_1(S_Interface_testMiniJava x_2, S_Interfaces_testMiniJava x_4) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_4.att_factory=this.att_factory;
x_2.att_tdsInterfaces=this.att_tdsInterfaces;
x_4.att_tdsInterfaces=this.att_tdsInterfaces;
x_2.att_tdsClasses=this.att_tdsClasses;
x_4.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsFunctions=this.att_tdsFunctions;
x_4.att_tdsFunctions=this.att_tdsFunctions;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_4.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tds=this.att_tds;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Interfaces -> Interface #interfaceMultiple Interfaces1 #ast ;", e });
}
  }
private void action_interfaceMultiple_1(S_Interface_testMiniJava x_2, S_Interfaces_testMiniJava x_4) throws Exception {
try {
// instructions
if ((this.att_tds.contains(x_2.att_ast.getNom()))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_INTERFACE_already_defined, testMiniJavaMessages.INTERFACE_already_defined,new Object[]{""+x_2.att_ast.getNom()});

}
else {
this.att_tds.register(x_2.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#interfaceMultiple","Interfaces -> Interface #interfaceMultiple Interfaces1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_interface : // 58
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
