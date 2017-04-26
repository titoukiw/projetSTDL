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
public class S_SuiteNomEtendu_Bloc {
LEX_Bloc scanner;
  S_SuiteNomEtendu_Bloc() {
	}
  S_SuiteNomEtendu_Bloc(LEX_Bloc scanner, boolean eval) {
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
  private void regle75() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_75();
  }
  private void regle74() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	T_Bloc x_3 = new T_Bloc(scanner ) ;
	S_SuiteNomEtendu_Bloc x_5 = new S_SuiteNomEtendu_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_74(x_5);
	x_2.analyser(LEX_Bloc.token_crochet_ouvrant);
	x_3.analyser(LEX_Bloc.token_crochet_fermant);
if  (att_eval)	  action_inh_74(x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_74(x_5);
  }
private void action_auto_inh_74(S_SuiteNomEtendu_Bloc x_5) throws Exception {
try {
// instructions
x_5.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","SuiteNomEtendu -> crochet_ouvrant crochet_fermant #inh SuiteNomEtendu1 #ast ;", e });
}
  }
private void action_inh_74(S_SuiteNomEtendu_Bloc x_5) throws Exception {
try {
// instructions
x_5.att_type=this.att_factory.createArrayType(this.att_type);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","SuiteNomEtendu -> crochet_ouvrant crochet_fermant #inh SuiteNomEtendu1 #ast ;", e });
}
  }
private void action_ast_74(S_SuiteNomEtendu_Bloc x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteNomEtendu -> crochet_ouvrant crochet_fermant #inh SuiteNomEtendu1 #ast ;", e });
}
  }
private void action_ast_75() throws Exception {
try {
// instructions
this.att_ast=this.att_type;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","SuiteNomEtendu -> #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_crochet_ouvrant : // 34
        regle74 () ;
      break ;
      case LEX_Bloc.token_affectation : // 45
        regle75 () ;
      break ;
      case LEX_Bloc.token_parenthese_fermante : // 37
        regle75 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
