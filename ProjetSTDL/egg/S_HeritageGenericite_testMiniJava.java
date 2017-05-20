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
public class S_HeritageGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_HeritageGenericite_testMiniJava() {
	}
  S_HeritageGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
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
  private void regle25() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	T_testMiniJava x_3 = new T_testMiniJava(scanner ) ;
	S_InstanceGenericite_testMiniJava x_4 = new S_InstanceGenericite_testMiniJava(scanner,att_eval) ;
	S_SuiteHeritageGenericite_testMiniJava x_5 = new S_SuiteHeritageGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_25(x_3, x_4, x_5);
	x_2.analyser(LEX_testMiniJava.token_extension);
	x_3.analyser(LEX_testMiniJava.token_identificateur_type);
	x_4.analyser() ;
	x_5.analyser() ;
if  (att_eval)	  action_ast_25(x_3, x_4, x_5);
  }
  private void regle26() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_26();
  }
private void action_ast_25(T_testMiniJava x_3, S_InstanceGenericite_testMiniJava x_4, S_SuiteHeritageGenericite_testMiniJava x_5) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
if (this.att_tds.knows(x_3.att_txt)){
loc_f=this.att_tds.get(x_3.att_txt);
loc_d=loc_f.get();
if (((InstanceGenericite==null))){
if (loc_d instanceof Objet ){
x_5.att_ast.addFirst(((Objet)loc_d).getType());
this.att_ast=x_5.att_ast;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_DECL_not_an_object, testMiniJavaMessages.DECL_not_an_object,new Object[]{""+x_3.att_txt});


}
}
else {
if (loc_d instanceof Objet ){
x_5.att_ast.addFirst(this.att_factory.createTypeGenerique(((Objet)loc_d), x_4.att_ast));
this.att_ast=x_5.att_ast;
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_DECL_not_an_object, testMiniJavaMessages.DECL_not_an_object,new Object[]{""+x_3.att_txt});


}
}
}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), ItestMiniJavaMessages.id_Undefined_ident, testMiniJavaMessages.Undefined_ident,new Object[]{""+x_3.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","HeritageGenericite -> extension identificateur_type InstanceGenericite SuiteHeritageGenericite #ast ;", e });
}
  }
private void action_ast_26() throws Exception {
try {
// instructions
this.att_ast=null;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","HeritageGenericite -> #ast ;", e });
}
  }
private void action_auto_inh_25(T_testMiniJava x_3, S_InstanceGenericite_testMiniJava x_4, S_SuiteHeritageGenericite_testMiniJava x_5) throws Exception {
try {
// instructions
x_4.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
x_4.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","HeritageGenericite -> extension identificateur_type InstanceGenericite SuiteHeritageGenericite #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_testMiniJava.token_extension : // 70
        regle25 () ;
      break ;
      case LEX_testMiniJava.token_virgule : // 39
        regle26 () ;
      break ;
      case LEX_testMiniJava.token_superieur : // 34
        regle26 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_unexpected_token,testMiniJavaMessages.testMiniJava_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
