/**
 *
 */

package fr.n7.stl.block.ast;
import java.util.LinkedList;


public interface ClasseFactory {

	/* createClasse */
	public Classe createClasse(String nom, LinkedList<Classe> heritages, LinkedList<Interface> impl,LinkedList<ElementClasse> elements);


	/* Genericite*/

	/* Elements Classe*/
	public Constructeur createConstructeur(String id, String classeCourante, DroitAcces droit, LinkedList<Parametre> listParam, Block body);
	public Methode createMethode(String id, String classeCourante, DroitAcces droit, 
							     LinkedList<Parametre> listParam, Bloc body, boolean statique, Type returnType);
	public Attribut createAttribut(String id, String classeCourante, Type type, DroitAcces droit, boolean statique);


}