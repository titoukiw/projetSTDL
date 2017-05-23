/**
 *
 */

package fr.n7.stl.block.ast;
import java.util.LinkedList;
import fr.n7.stl.block.ast.impl.*;

public interface ClasseFactory {

	/* createClasse */
	public Classe createClasse(String nom, LinkedList<Classe> heritages, LinkedList<Interface> impl,LinkedList<ElementClasse> elements);


	/* Genericite*/

	/* Elements Classe*/
	public Constructeur createConstructeur(String id, String classeCourante, DroitAcces droit, LinkedList<Parametre> listParam, Block body);
	public Methode createMethode(String id, String classeCourante, DroitAcces droit, 
							     LinkedList<Parametre> listParam, Block body, boolean statique, Type returnType);
	public Attribut createAttribut(String id, String classeCourante, Type type, DroitAcces droit, boolean statique);

	public ClasseTypeImpl createClasseType(Classe classe);
	public ClasseDeclaration createClasseDeclaration(String name, Type type, Expression expression);

	public Expression createClasseUse(ClasseDeclaration classe);

	public ClassePrincipale createClassePrincipale(String nom,Block bloc);


	public Expression createAttributUse(ElementClasse attribut);

}