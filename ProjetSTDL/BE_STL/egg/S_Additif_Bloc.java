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
public class S_Additif_Bloc {
LEX_Bloc scanner;
  S_Additif_Bloc() {
	}
  S_Additif_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  boolean att_eval;
  LEX_Bloc att_scanner;
  BinaryOperator att_bin_op;
  private void regle48() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_ou);
if  (att_eval)	  action_ast_48();
  }
  private void regle47() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_soustraction);
if  (att_eval)	  action_ast_47();
  }
  private void regle23() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	//appel
	x_2.analyser(LEX_Bloc.token_addition);
if  (att_eval)	  action_ast_23();
  }
private void action_ast_47() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Substract;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Additif -> soustraction #ast ;", e });
}
  }
private void action_ast_48() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Or;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Additif -> ou #ast ;", e });
}
  }
private void action_ast_23() throws Exception {
try {
// instructions
this.att_bin_op=BinaryOperator.Add;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Additif -> addition #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_addition : // 47
        regle23 () ;
      break ;
      case LEX_Bloc.token_soustraction : // 48
        regle47 () ;
      break ;
      case LEX_Bloc.token_ou : // 50
        regle48 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
