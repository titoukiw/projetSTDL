package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */
public interface Constructeur extends ElementClasse {

	public boolean isEqual(Constructeur cons);

	public LinkedList<Parametre> getParametres();

	public String getClasseCourante();
}