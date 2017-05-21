package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */
public interface Constructeur extends ElementClasse {

	public boolean isEqual(Methode meth);

	public LinkedList<Parametre> getParametres();

	public String getClasseCourante();
}