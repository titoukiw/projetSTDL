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
public class S_Interface_testMiniJava {
LEX_testMiniJava scanner;
  S_Interface_testMiniJava() {
	}
  S_Interface_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Objet att_ast;
  LEX_testMiniJava att_scanner;
  private void regle3() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	S_Genericite_testMiniJava x_4 = new S_Genericite_testMiniJava(scanner,att_eval) ;
	S_HeritageInterface_testMiniJava x_5 = new S_HeritageInterface_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_6 = new T_testMiniJava(scanner ) ;
	S_ElementsInterface_testMiniJava x_7 = new S_ElementsInterface_testMiniJava(scanner,att_eval) ;
	T_testMiniJava x_8 = new T_testMiniJava(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_3(x_3, x_4, x_5, x_7);
	x_2.analyser(LEX_testMiniJava.token_interface);
	x_3.analyser(LEX_testMiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
	x_6.analyser(LEX_testMiniJava.token_accolade_ouvrante);
	x_7.analyser() ;
	x_8.analyser(LEX_testMiniJava.token_accolade_fermante);
if  (att_eval)	  action_ast_3(x_3, x_4, x_5, x_7);
  }
private void action_auto_inh_3(T_testMiniJava x_3, S_Genericite_testMiniJava x_4, S_HeritageInterface_testMiniJava x_5, S_ElementsInterface_testMiniJava x_7) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
x_7.att_factory=this.att_factory;
x_5.att_tds=this.att_tds;
x_7.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","Interface -> interface identificateur_type Genericite HeritageInterface accolade_ouvrante ElementsInterface accolade_fermante #ast ;", e });
}
  }
private void action_ast_3(T_testMiniJava x_3, S_Genericite_testMiniJava x_4, S_HeritageInterface_testMiniJava x_5, S_ElementsInterface_testMiniJava x_7) throws Exception {
try {
// instructions
if ((this.att_tds.knows(x_3.att_txt))){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_TYPE_already_defined, testMiniJavaMessages.TYPE_already_defined,new Object[]{""+x_3.att_txt});

}
else {
if ((x_4.att_ast==null)){
if ((x_5.att_ast==null)){
this.att_ast=this.att_factory.createInterface(x_3.att_txt, x_7.att_ast);
}
else {
this.att_ast=this.att_factory.createInterface(x_3.att_txt, x_5.att_ast, x_7.att_ast);
}
}
else {
if ((x_5.att_ast==null)){
this.att_ast=this.att_factory.createInterface(x_3.att_txt, x_4.att_ast, x_7.att_ast);
}
else {
this.att_ast=this.att_factory.createInterface(x_3.att_txt, x_4.att_ast, x_5.att_ast, x_7.att_ast);
}
}
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","Interface -> interface identificateur_type Genericite HeritageInterface accolade_ouvrante ElementsInterface accolade_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle3 () ;
  }
  }
