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
public class S_Affectable_Bloc {
LEX_Bloc scanner;
  S_Affectable_Bloc() {
	}
  S_Affectable_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Assignable att_ast;
  LEX_Bloc att_scanner;
  private void regle68() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Affectable_Bloc x_3 = new S_Affectable_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_68(x_3);
	x_2.analyser(LEX_Bloc.token_multiplication);
	x_3.analyser() ;
if  (att_eval)	  action_ast_68(x_3);
  }
  private void regle67() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Affectable_Bloc x_3 = new S_Affectable_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_67(x_3);
	x_2.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_parenthese_fermante);
if  (att_eval)	  action_ast_67(x_3);
  }
  private void regle8() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_SuiteAffectable_Bloc x_4 = new S_SuiteAffectable_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_8(x_2, x_4);
	x_2.analyser(LEX_Bloc.token_identificateur);
if  (att_eval)	  action_inh_8(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_8(x_2, x_4);
  }
private void action_auto_inh_8(T_Bloc x_2, S_SuiteAffectable_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Affectable -> identificateur #inh SuiteAffectable #ast ;", e });
}
  }
private void action_auto_inh_67(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Affectable -> parenthese_ouvrante Affectable1 parenthese_fermante #ast ;", e });
}
  }
private void action_auto_inh_68(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Affectable -> multiplication Affectable1 #ast ;", e });
}
  }
private void action_inh_8(T_Bloc x_2, S_SuiteAffectable_Bloc x_4) throws Exception {
try {
// locales
Optional<Declaration> loc_o;
Declaration loc_d;
// instructions
if ((this.att_tds.knows(x_2.att_txt))){
loc_o=this.att_tds.get(x_2.att_txt);
loc_d=loc_o.get();
System.out.print(""+("Declaration "+loc_d));
if (loc_d instanceof VariableDeclaration ){
x_4.att_support=this.att_factory.createVariableAssignment(((VariableDeclaration)loc_d));
}
else if (loc_d instanceof ConstantDeclaration ){
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_not_a_variable, BlocMessages.BLOC_not_a_variable,new Object[]{""+x_2.att_txt});

}

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_undefined_ident, BlocMessages.BLOC_undefined_ident,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","Affectable -> identificateur #inh SuiteAffectable #ast ;", e });
}
  }
private void action_ast_8(T_Bloc x_2, S_SuiteAffectable_Bloc x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Affectable -> identificateur #inh SuiteAffectable #ast ;", e });
}
  }
private void action_ast_67(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Affectable -> parenthese_ouvrante Affectable1 parenthese_fermante #ast ;", e });
}
  }
private void action_ast_68(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createPointerAssignment(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Affectable -> multiplication Affectable1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_identificateur : // 70
        regle8 () ;
      break ;
      case LEX_Bloc.token_parenthese_ouvrante : // 36
        regle67 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 51
        regle68 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
