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
public class S_ArgumentGenericite_testMiniJava {
LEX_testMiniJava scanner;
  S_ArgumentGenericite_testMiniJava() {
	}
  S_ArgumentGenericite_testMiniJava(LEX_testMiniJava scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  ArgumentGenericite att_ast;
  LEX_testMiniJava att_scanner;
  private void regle34() throws Exception {

	//declaration
	T_testMiniJava x_2 = new T_testMiniJava(scanner ) ;
	S_InstanceGenericite_testMiniJava x_3 = new S_InstanceGenericite_testMiniJava(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_34(x_2, x_3);
	x_2.analyser(LEX_testMiniJava.token_identificateur_type);
	x_3.analyser() ;
if  (att_eval)	  action_ast_34(x_2, x_3);
  }
private void action_auto_inh_34(T_testMiniJava x_2, S_InstanceGenericite_testMiniJava x_3) throws Exception {
try {
// instructions
x_3.att_tds=this.att_tds;
x_3.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#auto_inh","ArgumentGenericite -> identificateur_type InstanceGenericite #ast ;", e });
}
  }
private void action_ast_34(T_testMiniJava x_2, S_InstanceGenericite_testMiniJava x_3) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if (this.att_tds.knows(x_2.att_txt)){
loc_o=this.att_tds.get(x_2.att_txt);
loc_d=loc_o.get();
if (loc_d instanceof Objet ){
if ((x_3.att_ast==null)){
this.att_ast=this.att_factory.createArgumentGenericite(((Objet)loc_d));
}
else {
this.att_ast=this.att_factory.createArgumentGenericite(((Objet)loc_d), x_3.att_ast);
}
}

}

}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "testMiniJava", "#ast","ArgumentGenericite -> identificateur_type InstanceGenericite #ast ;", e });
}
  }
  public void analyser () throws Exception {
    regle34 () ;
  }
  }
