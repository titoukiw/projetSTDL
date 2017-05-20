package fr.n7.stl.block.ast;

/**
 * @author okeee
 *
 */
import java.util.LinkedList;

public interface Signature extends ElementInterface{



	public Type getType();

	public LinkedList<Parametre> getParametres();

	public String getInterfaceCourrante();

	public boolean isEqual(Signature sin);

	
}
