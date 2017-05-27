package fr.n7.stl.block.ast;

import java.util.LinkedList;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
/**
 * @author okeee
 *
 */
public interface Classe extends Objet {

	public boolean equalsTo(Classe _classe);
	public boolean containsMethode(String id);		// Depreciated
	public Methode getMethode(String id);			// Depreciated
	public boolean containsSignature(String id, LinkedList<Type> listParam);
	public Methode getSignature(String id, LinkedList<Type> listParam);
	public boolean containsAttribut(String id);
	public Expression getAttribut(String id);
	public LinkedList<ElementClasse> getElements();
	public LinkedList<Classe> getHeritage();
	public LinkedList<Interface> getInterface();
	public LinkedList<Constructeur> getConstructeurs();

	public Fragment getCode(TAMFactory factory);
	public int allocateMemory(Register registre, int offset);


}