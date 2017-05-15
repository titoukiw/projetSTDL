package egg;
import java.util.Arrays;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.messages.NLS;
import mg.egg.eggc.runtime.libjava.lex.LEXICAL4;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
public class LEX_testMiniJava extends LEXICAL4  {
 public static final int EOF = 0 ;
 public static final int token_faux = 1 ;
 public static final int token_sinon = 2 ;
 public static final int token_vide = 3 ;
 public static final int token_point = 4 ;
 public static final int token_public = 5 ;
 public static final int token_accolade_fermante = 6 ;
 public static final int token_accolade_ouvrante = 7 ;
 public static final int token_interface = 8 ;
 public static final int token_type_bool = 9 ;
 public static final int token_identificateur = 10 ;
 public static final int token_vrai = 11 ;
 public static final int token_deux_points = 12 ;
 public static final int token_negation = 13 ;
 public static final int token_nouveau = 14 ;
 public static final int token_commentaire = 15 ;
 public static final int token_ou = 16 ;
 public static final int token_addition = 17 ;
 public static final int token_superieur_egal = 18 ;
 public static final int token_affectation = 19 ;
 public static final int token_identificateur_type = 20 ;
 public static final int token_soustraction = 21 ;
 public static final int token_afficher = 22 ;
 public static final int token_protege = 23 ;
 public static final int token_crochet_fermant = 24 ;
 public static final int token_principale = 25 ;
 public static final int token_tant_que = 26 ;
 public static final int token_inferieur = 27 ;
 public static final int token_implantation = 28 ;
 public static final int token_division = 29 ;
 public static final int token_adresse = 30 ;
 public static final int token_type_char = 31 ;
 public static final int token_caractere = 32 ;
 public static final int token_chaine = 33 ;
 public static final int token_multiplication = 34 ;
 public static final int token_retour = 35 ;
 public static final int token_type_int = 36 ;
 public static final int token_final = 37 ;
 public static final int token_entier = 38 ;
 public static final int token_virgule = 39 ;
 public static final int token_crochet_ouvrant = 40 ;
 public static final int token_si = 41 ;
 public static final int token_classe = 42 ;
 public static final int token_extension = 43 ;
 public static final int token_superieur = 44 ;
 public static final int token_separateur = 45 ;
 public static final int token_prive = 46 ;
 public static final int token_egalite = 47 ;
 public static final int token_choix = 48 ;
 public static final int token_type_String = 49 ;
 public static final int token_different = 50 ;
 public static final int token_modulo = 51 ;
 public static final int token_statique = 52 ;
 public static final int token_parenthese_fermante = 53 ;
 public static final int token_inferieur_egal = 54 ;
 public static final int token_parenthese_ouvrante = 55 ;
 public static final int token_point_virgule = 56 ;
 public static final int token_nul = 57 ;
 public static final int token_et = 58 ;
  static final int token_autre = 59 ;
  public static final String[][] tokenImages = {
	{"<EOF>"} ,{"faux"},
{"sinon"},
{"vide"},
{"point"},
{"public"},
{"accolade_fermante"},
{"accolade_ouvrante"},
{"interface"},
{"type_bool"},
    {"identificateur"} ,
{"vrai"},
{"deux_points"},
{"negation"},
{"nouveau"},
    {"commentaire"} ,
{"ou"},
{"addition"},
{"superieur_egal"},
{"affectation"},
    {"identificateur_type"} ,
{"soustraction"},
{"afficher"},
{"protege"},
{"crochet_fermant"},
{"principale"},
{"tant_que"},
{"inferieur"},
{"implantation"},
{"division"},
{"adresse"},
{"type_char"},
    {"caractere"} ,
    {"chaine"} ,
{"multiplication"},
{"retour"},
{"type_int"},
{"final"},
    {"entier"} ,
{"virgule"},
{"crochet_ouvrant"},
{"si"},
{"classe"},
{"extension"},
{"superieur"},
    {"separateur"} ,
{"prive"},
{"egalite"},
{"choix"},
{"type_String"},
{"different"},
{"modulo"},
{"statique"},
{"parenthese_fermante"},
{"inferieur_egal"},
{"parenthese_ouvrante"},
{"point_virgule"},
{"nul"},
{"et"},
  } ;
  private int [] separateurs = { 
token_commentaire
, token_separateur
	} ;
  public int[] getSeparateurs(){
	return separateurs;
    }
  private int [] comments = { 
	} ;
  public int[] getComments(){
	return comments;
    }
  private int le_comment = -1;
  public int getComment(){
	return le_comment;
    }
  public LEX_testMiniJava(IProblemReporter pr, LEX_CONTEXTE lc, int k) {
	super(pr, lc,k);
	dernier_accepte = 0 ;
	analyseur = new JLEX_testMiniJava();
  }
  public void setSource ( LEXICAL4 scanner) throws EGGException{
	scanner.analyseur.toContext(scanner.contexte);
	analyseur.fromContext(scanner.contexte);
  }
  public void setReader ( LEXICAL4 scanner) {
	scanner.analyseur.setReader(scanner.contexte.source);
  }
  public void accepter_sucre ( int t ) throws EGGException {
	if ( fenetre[0].code == t ) {
	  dernier_accepte = fenetre[0].ligne ;
	  recovery = false;
	  decaler () ;
	}else {
	  _interrompre(IProblem.Syntax,getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_expected_token, testMiniJavaMessages.testMiniJava_expected_token,new Object[]{fenetre[0].getNom(), Arrays.asList(tokenImages[t])});
	}
  }
  public void accepter_fds() throws EGGException {
	lit ( 1 ) ;
	if ( fenetre[0].code != EOF ) {
	  _interrompre(IProblem.Syntax,getBeginLine(), ItestMiniJavaMessages.id_testMiniJava_expected_token, testMiniJavaMessages.testMiniJava_expected_eof, new Object[]{fenetre[0].getNom()});
	  }
     else {
	  dernier_accepte = fenetre[0].ligne ;
	  }
	}
  public int ligneDepart () {
	return getBeginLine() + getEndLine() ;
	}
  public void _interrompre (int cat,  int line, int id,  String c , Object [] m )  {
	  //recovery = true;
	  recovery = false;
	  contexte.errors++;
	    problemReporter.handle(cat, id,line  , NLS.bind(c,m), getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Error,m);
	}
	public void _signaler ( int cat, int line, int id, String c , Object [] m )  {
	    problemReporter.handle(cat , id, line  , NLS.bind(c,m),getOffset(), getOffset() + getLength() - 1,ProblemSeverities.Warning,m);
	}
  }
