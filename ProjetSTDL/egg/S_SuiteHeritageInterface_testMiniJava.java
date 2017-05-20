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
public class S_SuiteHeritageInterface_testMiniJava {
LEX_testMiniJava scanner;
  S_SuiteHeritageInterface_testMiniJava() {
	}
  S_SuiteHeritageInterface_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LinkedList<Interface> att_ast;
  SymbolTable att_tdsInterfaces;
  LinkedList<Interface> att_listInterfacesHeritage;
  LEX_testMiniJava att_scanner;
  private void regle7() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_7();
  }
  private void regle6() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	S_SuiteHeritageInterface_testMiniJava x_5 = new S_SuiteHeritageInterface_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_6(x_3, x_5);
	x_2.analyser(LEX_testMiniJava.token_virgule);
	x_3.analyser(LEX_testMiniJava.token_identificateur_type);
if  (att_eval)	  action_inh_6(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_6(x_3, x_5);
  }
private void action_inh_6(T_testMiniJava x_3, S_SuiteHeritageInterface_testMiniJava x_5) throws Exception {
try {
// instructions
if ((this.att_tdsInterfaces.contains(x_3.att_txt))){
this.att_listInterfacesHeritage.add(x_3.att_txt);
x_5.att_listInterfacesHeritage=this.att_listInterfacesHeritage;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_HERITAGE_doesnt_exist, testMiniJavaMessages.HERITAGE_doesnt_exist,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#inh","SuiteHeritageInterface -> virgule identificateur_type #inh SuiteHeritageInterface1 #ast ;", e });
}
  }
private void action_auto_inh_6(T_testMiniJava x_3, S_SuiteHeritageInterface_testMiniJava x_5) throws Exception {
try {
// instructions
x_5.att_tds=this.att_tds;
x_5.att_factory=this.att_factory;
x_5.att_tdsInterfaces=this.att_tdsInterfaces;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","SuiteHeritageInterface -> virgule identificateur_type #inh SuiteHeritageInterface1 #ast ;", e });
}
  }
private void action_ast_6(T_testMiniJava x_3, S_SuiteHeritageInterface_testMiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
this.att_ast=x_5.att_ast;
if ((this.att_tds.knows(identificateur_type))){
loc_o=this.att_tds.get(x_3.att_txt);
loc_d=loc_o.get();
if (loc_d instanceof Interface ){
this.att_ast.addFirst(((Interface)loc_d));
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_HERITAGE_not_interface, testMiniJavaMessages.HERITAGE_not_interface,new Object[]{""+x_3.att_txt});


}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_HERITAGE_dont_exist, testMiniJavaMessages.HERITAGE_dont_exist,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteHeritageInterface -> virgule identificateur_type #inh SuiteHeritageInterface1 #ast ;", e });
}
  }
private void action_ast_7() throws Exception {
try {
// instructions
this.att_ast= new LinkedList<Interface>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","SuiteHeritageInterface -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_virgule : // 29
        regle6 () ;
      break ;
      case LEX_testMiniJava.token_accolade_ouvrante : // 17
        regle7 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
