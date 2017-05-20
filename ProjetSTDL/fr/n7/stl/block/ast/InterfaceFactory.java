/**
 *
 */

package fr.n7.stl.block.ast;
import java.util.LinkedList;


public interface InterfaceFactory {

	/* createInterface */
	// public Interface createInterface(String nom, LinkedList<ArgumentGenericite> parametresGen, LinkedList<Type> heritages, LinkedList<ElementInterface> elements);
	// public Interface createInterface(String nom, LinkedList<ArgumentGenericite> parametresGen, LinkedList<ElementInterface> elements);
	// public Interface createInterface (LinkedList<Type> heritages,String nom,LinkedList<ElementInterface> elements );
	// public Interface createInterface (String nom, LinkedList<ElementInterface> elements);
	public Interface createInterface(String nom, LinkedList<Interface> heritages, LinkedList<ElementInterface> elements);
//	public Interface createInterface(String nom, LinkedList<Type> heritages,LinkedList<ElementInterface> elements );
//	public Interface createInterface(String nom, LinkedList<ElementInterface> elements);

	/* Genericite*/
	public ArgumentGenericite createArgumentGenericite(Objet obj, LinkedList<Type> instGen);
	public ArgumentGenericite createArgumentGenericite(Objet obj);
	public Type createGenericType(Objet obj);
	public Type createGenericType(Objet obj, LinkedList<Type> instGen);


	/* ElementInterface*/
	public Signature createSignature(String id, LinkedList<Parametre> listParam, String nomInterface);
	public Signature createSignature(String id, Type type, LinkedList<Parametre> listParam, String nomInterface);
	public Parametre createParametre(String id, Type type);

}

/*identificateur_type^ast -> String
ElementsInterface^ast -> LinkedList<ElementInterface>
Genericite^ast -> LinkedList<ArgumentGenericite>
HeritageInterface^ast -> LinkedList<Type>

String, LinkedList<ElementInterface>
LinkedList<Type>,String,LinkedList<ElementInterface>
String, LinkedList<ArgumentGenericite>, LinkedList<ElementInterface>
String, LinkedList<ArgumentGenericite>, LinkedList<Type>, LinkedList<ElementInterface>*/