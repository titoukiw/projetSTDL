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
public class S_NomEtendu_Bloc {
LEX_Bloc scanner;
  S_NomEtendu_Bloc() {
	}
  S_NomEtendu_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  boolean att_eval;
  Type att_ast;
  LEX_Bloc att_scanner;
  Type att_type;
  String att_nom;
  private void regle72() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_NomEtendu_Bloc x_4 = new S_NomEtendu_Bloc(scanner,att_eval) ;
	T_Bloc x_5 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_72(x_4);
	x_2.analyser(LEX_Bloc.token_parenthese_ouvrante);
if  (att_eval)	  action_inh_72(x_4);
	x_4.analyser() ;
	x_5.analyser(LEX_Bloc.token_parenthese_fermante);
if  (att_eval)	  action_ast_72(x_4);
  }
  private void regle73() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_SuiteNomEtendu_Bloc x_4 = new S_SuiteNomEtendu_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_73(x_2, x_4);
	x_2.analyser(LEX_Bloc.token_identificateur);
if  (att_eval)	  action_inh_73(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_73(x_2, x_4);
  }
  private void regle71() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_NomEtendu_Bloc x_4 = new S_NomEtendu_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_71(x_4);
	x_2.analyser(LEX_Bloc.token_multiplication);
if  (att_eval)	  action_inh_71(x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_71(x_4);
  }
private void action_auto_inh_73(T_Bloc x_2, S_SuiteNomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","NomEtendu -> identificateur #inh SuiteNomEtendu #ast ;", e });
}
  }
private void action_inh_73(T_Bloc x_2, S_SuiteNomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_type=this.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","NomEtendu -> identificateur #inh SuiteNomEtendu #ast ;", e });
}
  }
private void action_ast_71(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
this.att_nom=x_4.att_nom;
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","NomEtendu -> multiplication #inh NomEtendu1 #ast ;", e });
}
  }
private void action_ast_72(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
this.att_nom=x_4.att_nom;
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","NomEtendu -> parenthese_ouvrante #inh NomEtendu1 parenthese_fermante #ast ;", e });
}
  }
private void action_ast_73(T_Bloc x_2, S_SuiteNomEtendu_Bloc x_4) throws Exception {
try {
// instructions
this.att_nom=x_2.att_txt;
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","NomEtendu -> identificateur #inh SuiteNomEtendu #ast ;", e });
}
  }
private void action_inh_72(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_type=this.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","NomEtendu -> parenthese_ouvrante #inh NomEtendu1 parenthese_fermante #ast ;", e });
}
  }
private void action_inh_71(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_type=this.att_factory.createPointerType(this.att_type);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","NomEtendu -> multiplication #inh NomEtendu1 #ast ;", e });
}
  }
private void action_auto_inh_71(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","NomEtendu -> multiplication #inh NomEtendu1 #ast ;", e });
}
  }
private void action_auto_inh_72(S_NomEtendu_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","NomEtendu -> parenthese_ouvrante #inh NomEtendu1 parenthese_fermante #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_multiplication : // 51
        regle71 () ;
      break ;
      case LEX_Bloc.token_parenthese_ouvrante : // 36
        regle72 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 70
        regle73 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
