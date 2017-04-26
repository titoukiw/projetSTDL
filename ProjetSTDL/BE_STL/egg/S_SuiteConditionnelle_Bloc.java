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
public class S_SuiteConditionnelle_Bloc {
LEX_Bloc scanner;
  S_SuiteConditionnelle_Bloc() {
	}
  S_SuiteConditionnelle_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  Expression att_condition;
  SymbolTable att_tds;
  boolean att_eval;
  Instruction att_ast;
  LEX_Bloc att_scanner;
  Block att_alors;
  private void regle13() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Bloc_Bloc x_4 = new S_Bloc_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_13(x_4);
	x_2.analyser(LEX_Bloc.token_sinon);
if  (att_eval)	  action_inh_13(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_13(x_4);
  }
  private void regle12() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_12();
  }
private void action_inh_13(S_Bloc_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_tds= new SymbolTable(this.att_tds);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","SuiteConditionnelle -> sinon #inh Bloc #ast ;", e });
}
  }
private void action_auto_inh_13(S_Bloc_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","SuiteConditionnelle -> sinon #inh Bloc #ast ;", e });
}
  }
private void action_ast_12() throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createConditional(this.att_condition, this.att_alors);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteConditionnelle -> #ast ;", e });
}
  }
private void action_ast_13(S_Bloc_Bloc x_4) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createConditional(this.att_condition, this.att_alors, x_4.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteConditionnelle -> sinon #inh Bloc #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_identificateur : // 70
        regle12 () ;
      break ;
      case LEX_Bloc.token_parenthese_ouvrante : // 36
        regle12 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 51
        regle12 () ;
      break ;
      case LEX_Bloc.token_si : // 58
        regle12 () ;
      break ;
      case LEX_Bloc.token_tant_que : // 61
        regle12 () ;
      break ;
      case LEX_Bloc.token_afficher : // 60
        regle12 () ;
      break ;
      case LEX_Bloc.token_constante : // 68
        regle12 () ;
      break ;
      case LEX_Bloc.token_typedef : // 64
        regle12 () ;
      break ;
      case LEX_Bloc.token_type_bool : // 66
        regle12 () ;
      break ;
      case LEX_Bloc.token_type_int : // 65
        regle12 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 38
        regle12 () ;
      break ;
      case LEX_Bloc.token_identificateur_type : // 71
        regle12 () ;
      break ;
      case LEX_Bloc.token_enregistrement : // 67
        regle12 () ;
      break ;
      case LEX_Bloc.token_accolade_fermante : // 31
        regle12 () ;
      break ;
      case LEX_Bloc.token_sinon : // 59
        regle13 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
