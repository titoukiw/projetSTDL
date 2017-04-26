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
public class S_Instructions_Bloc {
LEX_Bloc scanner;
  S_Instructions_Bloc() {
	}
  S_Instructions_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  LEX_Bloc att_scanner;
  LinkedList<Instruction> att_list;
  private void regle6() throws Exception {

	//declaration
	S_Instruction_Bloc x_2 = new S_Instruction_Bloc(scanner,att_eval) ;
	S_Instructions_Bloc x_3 = new S_Instructions_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_6(x_2, x_3);
	x_2.analyser() ;
	x_3.analyser() ;
if  (att_eval)	  action_ast_6(x_2, x_3);
  }
  private void regle5() throws Exception {

	//declaration
	//appel
if  (att_eval)	  action_ast_5();
  }
private void action_ast_5() throws Exception {
try {
// instructions
this.att_list= new LinkedList<Instruction>();
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instructions -> #ast ;", e });
}
  }
private void action_auto_inh_6(S_Instruction_Bloc x_2, S_Instructions_Bloc x_3) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
x_3.att_factory=this.att_factory;
x_2.att_tds=this.att_tds;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Instructions -> Instruction Instructions1 #ast ;", e });
}
  }
private void action_ast_6(S_Instruction_Bloc x_2, S_Instructions_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_list.addFirst(x_2.att_ast);
this.att_list=x_3.att_list;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Instructions -> Instruction Instructions1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_accolade_fermante : // 31
        regle5 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 70
        regle6 () ;
      break ;
      case LEX_Bloc.token_parenthese_ouvrante : // 36
        regle6 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 51
        regle6 () ;
      break ;
      case LEX_Bloc.token_si : // 58
        regle6 () ;
      break ;
      case LEX_Bloc.token_tant_que : // 61
        regle6 () ;
      break ;
      case LEX_Bloc.token_afficher : // 60
        regle6 () ;
      break ;
      case LEX_Bloc.token_constante : // 68
        regle6 () ;
      break ;
      case LEX_Bloc.token_typedef : // 64
        regle6 () ;
      break ;
      case LEX_Bloc.token_type_bool : // 66
        regle6 () ;
      break ;
      case LEX_Bloc.token_type_int : // 65
        regle6 () ;
      break ;
      case LEX_Bloc.token_inferieur : // 38
        regle6 () ;
      break ;
      case LEX_Bloc.token_identificateur_type : // 71
        regle6 () ;
      break ;
      case LEX_Bloc.token_enregistrement : // 67
        regle6 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
