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
public class S_Comparatif_Bloc {
LEX_Bloc scanner;
  S_Comparatif_Bloc() {
	}
  S_Comparatif_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Bloc att_scanner;
  BinaryOperator att_bin_op;
  private void regle43() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_inferieur);
if  (att_eval)	  action_texte_43();
  }
  private void regle42() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_different);
if  (att_eval)	  action_texte_42();
  }
  private void regle19() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_egalite);
if  (att_eval)	  action_texte_19();
  }
  private void regle46() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_superieur_egal);
if  (att_eval)	  action_texte_46();
  }
  private void regle45() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_superieur);
if  (att_eval)	  action_texte_45();
  }
  private void regle44() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_inferieur_egal);
if  (att_eval)	  action_texte_44();
  }
private void action_texte_42() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Different;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> different #texte ;", e });
}
  }
private void action_texte_44() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.LesserOrEqual;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> inferieur_egal #texte ;", e });
}
  }
private void action_texte_43() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Lesser;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> inferieur #texte ;", e });
}
  }
private void action_texte_19() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Equals;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> egalite #texte ;", e });
}
  }
private void action_texte_46() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.GreaterOrEqual;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> superieur_egal #texte ;", e });
}
  }
private void action_texte_45() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Greater;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#texte","Comparatif -> superieur #texte ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_egalite : // 46
        regle19 () ;
      break ;
      case LEX_Bloc.token_different : // 49
        regle42 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 38
        regle43 () ;
      break ;
      case LEX_Bloc.token_inferieur_egal : // 40
        regle44 () ;
      break ;
      case LEX_Bloc.token_superieur : // 39
        regle45 () ;
      break ;
      case LEX_Bloc.token_superieur_egal : // 41
        regle46 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
