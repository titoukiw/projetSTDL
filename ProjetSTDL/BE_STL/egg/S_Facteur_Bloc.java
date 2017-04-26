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
public class S_Facteur_Bloc {
LEX_Bloc scanner;
  S_Facteur_Bloc() {
	}
  S_Facteur_Bloc(LEX_Bloc scanner, boolean eval) {
	this.scanner = scanner;
	this.att_eval = eval;
	this.att_scanner = scanner;
	}
int [] sync= new int[0];
  BlockFactory att_factory;
  SymbolTable att_tds;
  boolean att_eval;
  Expression att_ast;
  LEX_Bloc att_scanner;
  private void regle36() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_36(x_3);
	x_2.analyser(LEX_Bloc.token_premier);
	x_3.analyser() ;
if  (att_eval)	  action_ast_36(x_3);
  }
  private void regle38() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Expressions_Bloc x_3 = new S_Expressions_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_38(x_3);
	x_2.analyser(LEX_Bloc.token_accolade_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_accolade_fermante);
if  (att_eval)	  action_ast_38(x_3);
  }
  private void regle37() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_37(x_3);
	x_2.analyser(LEX_Bloc.token_second);
	x_3.analyser() ;
if  (att_eval)	  action_ast_37(x_3);
  }
  private void regle29() throws Exception {

	//declaration
	S_Valeur_Bloc x_2 = new S_Valeur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_29(x_2);
	x_2.analyser() ;
if  (att_eval)	  action_ast_29(x_2);
  }
  private void regle28() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Expression_Bloc x_3 = new S_Expression_Bloc(scanner,att_eval) ;
	T_Bloc x_4 = new T_Bloc(scanner ) ;
	//appel
if  (att_eval)	  action_auto_inh_28(x_3);
	x_2.analyser(LEX_Bloc.token_parenthese_ouvrante);
	x_3.analyser() ;
	x_4.analyser(LEX_Bloc.token_parenthese_fermante);
if  (att_eval)	  action_ast_28(x_3);
  }
  private void regle61() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_61(x_3);
	x_2.analyser(LEX_Bloc.token_multiplication);
	x_3.analyser() ;
if  (att_eval)	  action_ast_61(x_3);
  }
  private void regle52() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_52(x_3);
	x_2.analyser(LEX_Bloc.token_soustraction);
	x_3.analyser() ;
if  (att_eval)	  action_ast_52(x_3);
  }
  private void regle63() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Type_Bloc x_3 = new S_Type_Bloc(scanner,att_eval) ;
	S_SuiteNouveau_Bloc x_5 = new S_SuiteNouveau_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_63(x_3, x_5);
	x_2.analyser(LEX_Bloc.token_nouveau);
	x_3.analyser() ;
if  (att_eval)	  action_inh_63(x_3, x_5);
	x_5.analyser() ;
if  (att_eval)	  action_ast_63(x_3, x_5);
  }
  private void regle62() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Affectable_Bloc x_3 = new S_Affectable_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_62(x_3);
	x_2.analyser(LEX_Bloc.token_adresse);
	x_3.analyser() ;
if  (att_eval)	  action_ast_62(x_3);
  }
  private void regle53() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Facteur_Bloc x_3 = new S_Facteur_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_53(x_3);
	x_2.analyser(LEX_Bloc.token_negation);
	x_3.analyser() ;
if  (att_eval)	  action_ast_53(x_3);
  }
  private void regle33() throws Exception {

	//declaration
	T_Bloc x_2 = new T_Bloc(scanner ) ;
	S_Acces_Bloc x_4 = new S_Acces_Bloc(scanner,att_eval) ;
	//appel
if  (att_eval)	  action_auto_inh_33(x_2, x_4);
	x_2.analyser(LEX_Bloc.token_identificateur);
if  (att_eval)	  action_inh_33(x_2, x_4);
	x_4.analyser() ;
if  (att_eval)	  action_ast_33(x_2, x_4);
  }
private void action_auto_inh_37(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> second Facteur1 #ast ;", e });
}
  }
private void action_ast_61(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createPointerAccess(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> multiplication Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_38(S_Expressions_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> accolade_ouvrante Expressions accolade_fermante #ast ;", e });
}
  }
private void action_ast_62(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createAddressAccess(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> adresse Affectable #ast ;", e });
}
  }
private void action_auto_inh_28(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
private void action_ast_52(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Opposite, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_ast_63(S_Type_Bloc x_3, S_SuiteNouveau_Bloc x_5) throws Exception {
try {
// instructions
this.att_ast=x_5.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> nouveau Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_auto_inh_29(S_Valeur_Bloc x_2) throws Exception {
try {
// instructions
x_2.att_factory=this.att_factory;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> Valeur #ast ;", e });
}
  }
private void action_ast_53(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createUnaryExpression(UnaryOperator.Negate, x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> negation Facteur1 #ast ;", e });
}
  }
private void action_ast_33(T_Bloc x_2, S_Acces_Bloc x_4) throws Exception {
try {
// instructions
this.att_ast=x_4.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> identificateur #inh Acces #ast ;", e });
}
  }
private void action_ast_36(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createFirst(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> premier Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_62(S_Affectable_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> adresse Affectable #ast ;", e });
}
  }
private void action_ast_37(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createSecond(x_3.att_ast);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> second Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_52(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> soustraction Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_63(S_Type_Bloc x_3, S_SuiteNouveau_Bloc x_5) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_5.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
x_5.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> nouveau Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_ast_38(S_Expressions_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=this.att_factory.createSequence(x_3.att_expressions);
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> accolade_ouvrante Expressions accolade_fermante #ast ;", e });
}
  }
private void action_auto_inh_53(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> negation Facteur1 #ast ;", e });
}
  }
private void action_inh_63(S_Type_Bloc x_3, S_SuiteNouveau_Bloc x_5) throws Exception {
try {
// instructions
x_5.att_type=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","Facteur -> nouveau Type #inh SuiteNouveau #ast ;", e });
}
  }
private void action_ast_28(S_Expression_Bloc x_3) throws Exception {
try {
// instructions
this.att_ast=x_3.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> parenthese_ouvrante Expression parenthese_fermante #ast ;", e });
}
  }
private void action_ast_29(S_Valeur_Bloc x_2) throws Exception {
try {
// instructions
this.att_ast=x_2.att_ast;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#ast","Facteur -> Valeur #ast ;", e });
}
  }
private void action_auto_inh_33(T_Bloc x_2, S_Acces_Bloc x_4) throws Exception {
try {
// instructions
x_4.att_factory=this.att_factory;
x_4.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> identificateur #inh Acces #ast ;", e });
}
  }
private void action_inh_33(T_Bloc x_2, S_Acces_Bloc x_4) throws Exception {
try {
// locales
Optional<Declaration> loc_f;
Declaration loc_d;
// instructions
if ((this.att_tds.knows(x_2.att_txt))){
loc_f=this.att_tds.get(x_2.att_txt);
loc_d=loc_f.get();
if (loc_d instanceof ConstantDeclaration ){
x_4.att_support=((ConstantDeclaration)loc_d).getValue();
}
else if (loc_d instanceof VariableDeclaration ){
x_4.att_support=this.att_factory.createVariableUse(((VariableDeclaration)loc_d));
}

}
else {
att_scanner._interrompre(IProblem.Semantic, att_scanner.getBeginLine(), IBlocMessages.id_BLOC_undefined_ident, BlocMessages.BLOC_undefined_ident,new Object[]{""+x_2.att_txt});

}
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#inh","Facteur -> identificateur #inh Acces #ast ;", e });
}
  }
private void action_auto_inh_36(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> premier Facteur1 #ast ;", e });
}
  }
private void action_auto_inh_61(S_Facteur_Bloc x_3) throws Exception {
try {
// instructions
x_3.att_factory=this.att_factory;
x_3.att_tds=this.att_tds;
}catch(RuntimeException e) {	   att_scanner._interrompre(IProblem.Internal,att_scanner.getBeginLine(),ICoreMessages.id_EGG_runtime_error, CoreMessages.EGG_runtime_error,new Object[] { "Bloc", "#auto_inh","Facteur -> multiplication Facteur1 #ast ;", e });
}
  }
  public void analyser () throws Exception {
    scanner.lit ( 1 ) ;
    switch ( scanner.fenetre[0].code ) {
      case LEX_Bloc.token_parenthese_ouvrante : // 36
        regle28 () ;
      break ;
      case LEX_Bloc.token_entier : // 69
        regle29 () ;
      break ;
      case LEX_Bloc.token_vrai : // 56
        regle29 () ;
      break ;
      case LEX_Bloc.token_faux : // 57
        regle29 () ;
      break ;
      case LEX_Bloc.token_identificateur : // 70
        regle33 () ;
      break ;
      case LEX_Bloc.token_premier : // 62
        regle36 () ;
      break ;
      case LEX_Bloc.token_second : // 63
        regle37 () ;
      break ;
      case LEX_Bloc.token_accolade_ouvrante : // 30
        regle38 () ;
      break ;
      case LEX_Bloc.token_soustraction : // 48
        regle52 () ;
      break ;
      case LEX_Bloc.token_negation : // 54
        regle53 () ;
      break ;
      case LEX_Bloc.token_multiplication : // 51
        regle61 () ;
      break ;
      case LEX_Bloc.token_adresse : // 32
        regle62 () ;
      break ;
      case LEX_Bloc.token_nouveau : // 33
        regle63 () ;
      break ;
      default :
        	   scanner._interrompre(IProblem.Syntax, scanner.getBeginLine(), IBlocMessages.id_Bloc_unexpected_token,BlocMessages.Bloc_unexpected_token,new String[]{scanner.fenetre[0].getNom()});
    }
  }
  }
