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
public class S_ElementInterface_testMiniJava {
LEX_testMiniJava scanner;
  S_ElementInterface_testMiniJava() {
	}
  S_ElementInterface_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  SymbolTable att_tdsClasses;
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ElementInterface att_ast;
  SymbolTable att_tdsInterfaces;
  LEX_testMiniJava att_scanner;
  SymbolTable att_tdsAttributs;
  FunctionSymbolTable att_tdsFunctions;
  String att_interfaceCourrante;
  private void regle10() throws Exception {

	//declaration
	S_Signature_testMiniJava x_2 = new S_Signature_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_10(x_2);
	x_2.analyser() ;
	x_3.analyser(LEX_testMiniJava.token_point_virgule);
if  (att_eval)	  action_ast_10(x_2);
  }
private void action_auto_inh_10(S_Signature_testMiniJava x_2) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_2.att_tdsAttributs=this.att_tdsAttributs;
x_2.att_tdsInterfaces=this.att_tdsInterfaces;
x_2.att_tdsClasses=this.att_tdsClasses;
x_2.att_tdsFunctions=this.att_tdsFunctions;
x_2.att_interfaceCourrante=this.att_interfaceCourrante;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ElementInterface -> Signature point_virgule #ast ;", e });
}
  }
private void action_ast_10(S_Signature_testMiniJava x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
this.att_tdsFunctions.registerSign(x_2.att_ast, this.att_interfaceCourrante);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ElementInterface -> Signature point_virgule #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle10 () ;
  }
  }
