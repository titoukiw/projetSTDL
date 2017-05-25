package fr.n7.stl.block.ast;


import java.util.LinkedList;
/**
 * @author okeee
 *
 */
public interface ElementInterface extends Declaration {
	/*TODO : PublicStaticField ; DONE: Signature*/
	public String getInterfaceCourrante();
	public boolean checkType();
}