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
public class S_HeritageInterface_testMiniJava {
LEX_testMiniJava scanner;
  S_HeritageInterface_testMiniJava() {
	}
  S_HeritageInterface_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
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
  private void regle4() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	S_InstanceGenericite_testMiniJava x_5 = new S_InstanceGenericite_testMiniJava(scanner,att_eval) ;
	S_SuiteHeritageInterface_testMiniJava x_6 = new S_SuiteHeritageInterface_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_4(x_3, x_5, x_6);
	x_2.analyser(LEX_testMiniJava.token_extension);
	x_3.analyser(LEX_testMiniJava.token_identificateur_type);
if  (att_eval)	  action_inh_4(x_3, x_5, x_6);
	x_5.analyser() ;
	x_6.analyser() ;
if  (att_eval)	  action_ast_4(x_3, x_5, x_6);
  }
  private void regle5() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_5();
  }
private void action_inh_4(T_testMiniJava x_3, S_InstanceGenericite_testMiniJava x_5, S_SuiteHeritageInterface_testMiniJava x_6) throws Exception {
try {
// instructions
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#inh","HeritageInterface -> extension identificateur_type #inh InstanceGenericite SuiteHeritageInterface #ast ;", e });
}
  }
private void action_ast_5() throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","HeritageInterface -> #ast ;", e });
}
  }
private void action_auto_inh_4(T_testMiniJava x_3, S_InstanceGenericite_testMiniJava x_5, S_SuiteHeritageInterface_testMiniJava x_6) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_6.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
x_6.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","HeritageInterface -> extension identificateur_type #inh InstanceGenericite SuiteHeritageInterface #ast ;", e });
}
  }
private void action_ast_4(T_testMiniJava x_3, S_InstanceGenericite_testMiniJava x_5, S_SuiteHeritageInterface_testMiniJava x_6) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if (this.att_tds.knows(x_3.att_txt)){
loc_o=this.att_tds.get(x_3.att_txt);
loc_d=loc_o.get();
if (loc_d instanceof Interface ){
if ((x_5.att_ast==null)){
x_6.att_ast.add(this.att_factory.createGenericType(((Interface)loc_d)));
}
else {
x_6.att_ast.add(this.att_factory.createGenericType(((Interface)loc_d), x_5.att_ast));
}
this.att_ast=x_6.att_ast;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_TYPE_not_an_interface, testMiniJavaMessages.TYPE_not_an_interface,new Object[]{""+x_3.att_txt});


}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_TYPE_unknown, testMiniJavaMessages.TYPE_unknown,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","HeritageInterface -> extension identificateur_type #inh InstanceGenericite SuiteHeritageInterface #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_extension : // 70
        regle4 () ;
      break ;
      case LEX_testMiniJava.token_accolade_ouvrante : // 27
        regle5 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
