package egg;
import java.util.*;
import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import fr.n7.stl.util.*;
import mg.egg.eggc.runtime.libjava.EGGException;
import mg.egg.eggc.runtime.libjava.ISourceUnit;
import mg.egg.eggc.runtime.libjava.lex.LEX_CONTEXTE;
import mg.egg.eggc.runtime.libjava.problem.IProblemReporter;
import mg.egg.eggc.runtime.libjava.problem.IProblem;
import mg.egg.eggc.runtime.libjava.problem.ProblemSeverities;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class testMiniJava {
  LEX_testMiniJava scanner;
  protected IProblemReporter problemReporter;
	private S_Programme_testMiniJava axiome ;
	public  S_Programme_testMiniJava getAxiom(){return axiome;}
  public testMiniJava(IProblemReporter pr){
	   this.problemReporter = pr;
  }
  public void compile(ISourceUnit cu) throws Exception {
	try{
	  System.err.println("testMiniJava Version 0.0.1");
	  LEX_CONTEXTE contexte;
	  contexte = new LEX_CONTEXTE(cu);
	  scanner = new LEX_testMiniJava(problemReporter, contexte, 2);
	  scanner.analyseur.fromContext(contexte);
	  att_scanner = scanner;
	  axiome = new S_Programme_testMiniJava(scanner,att_eval);
	  axiome.att_scanner = this.att_scanner ;
	  axiome.att_eval = this.att_eval ;
	  axiome.analyser() ;
	  this.att_ast = axiome.att_ast ;
	  scanner.accepter_fds() ;
	}catch (EGGException e){
	  problemReporter.handle(e.getCategory(), e.getCode(),0, NLS.bind(e.getId(),e.getArgs()),ProblemSeverities.Error,0,0,e.getArgs());
	}
	}
  boolean att_eval;
  public void set_eval(boolean a_eval){
	att_eval = a_eval;
  }
  public boolean get_eval(){
	return att_eval;
  }
  Block att_ast;
  public void set_ast(Block a_ast){
	att_ast = a_ast;
  }
  public Block get_ast(){
	return att_ast;
  }
  LEX_testMiniJava att_scanner;
  public void set_scanner(LEX_testMiniJava a_scanner){
	att_scanner = a_scanner;
  }
  public LEX_testMiniJava get_scanner(){
	return att_scanner;
  }
  }
