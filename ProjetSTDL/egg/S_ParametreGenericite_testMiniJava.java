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
public class S_ParametreGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_ParametreGenericite_testMiniJava() {
	}
  S_ParametreGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ParametreGenericite att_ast;
  LEX_testMiniJava att_scanner;
  private void regle24() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_HeritageGenericite_testMiniJava x_3 = new S_HeritageGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_24(x_3);
	x_2.analyser(LEX_testMiniJava.token_choix);
	x_3.analyser() ;
if  (att_eval)	  action_ast_24(x_3);
  }
  private void regle23() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_HeritageGenericite_testMiniJava x_3 = new S_HeritageGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_23(x_2, x_3);
	x_2.analyser(LEX_testMiniJava.token_identificateur_type);
	x_3.analyser() ;
if  (att_eval)	  action_ast_23(x_2, x_3);
  }
private void action_auto_inh_23(T_testMiniJava x_2, S_HeritageGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ParametreGenericite -> identificateur_type HeritageGenericite #ast ;", e });
}
  }
private void action_auto_inh_24(S_HeritageGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ParametreGenericite -> choix HeritageGenericite #ast ;", e });
}
  }
private void action_ast_23(T_testMiniJava x_2, S_HeritageGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
if (this.att_tds.contains(x_2.att_txt)){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_GENERICITE_already_defined, testMiniJavaMessages.GENERICITE_already_defined,new Object[]{""+x_2.att_txt});

}
else {
this.att_ast=this.att_factory.createGenericParameter(x_2.att_txt, x_3.att_ast);
}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ParametreGenericite -> identificateur_type HeritageGenericite #ast ;", e });
}
  }
private void action_ast_24(S_HeritageGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createGenericParameter(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ParametreGenericite -> choix HeritageGenericite #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_identificateur_type : // 82
        regle23 () ;
      break ;
      case LEX_testMiniJava.token_choix : // 66
        regle24 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
