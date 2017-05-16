/**
 *
 */

package fr.n7.stl.block.ast;
import java.util.LinkedList;


public interface InterfaceFactory {

	/* createInterface */
	public Interface createInterface(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<Type> heritages, LinkedList<ElementInterface> elements);
	public Interface createInterface(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<ElementInterface> elements);
<<<<<<< HEAD
	public Interface createInterface (LinkedList<Type> heritages,String nom,LinkedList<ElementInterface> elements );
	public Interface createInterface (String nom, LinkedList<ElementInterface> elements);
=======
	public Interface createInterface(String nom, LinkedList<Type> heritages,LinkedList<ElementInterface> elements );
	public Interface createInterface(String nom, LinkedList<ElementInterface> elements);
>>>>>>> 51a67209267c984e59fc1c65d03cd0b24a746cd9

	/* Genericite*/
	public Type createArgumentGenericite(Objet obj, LinkedList<Type> instGen);
	public Type createArgumentGenericite(Objet obj);
	public Type createGenericType(Objet obj, LinkedList<Type> instGen);


	/* ElementInterface*/
	public ElementInterface createSignature(String id, LinkedList<Parametre> listParam);
	public ElementInterface createSignature(String id, Type type, LinkedList<Parametre> listParam);
	public Parametre createParametre(String id, Type type);

}