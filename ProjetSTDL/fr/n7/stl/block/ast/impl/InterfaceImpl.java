package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.interface;

public class InterfaceImpl implements Interface {

		private String nom;
		private LinkedList<Signature> listSign;
		private LinkedList<FinalStaticField> listFSField;


		public InterfaceImpl(String nom, LinkedList<ElementInterface> elements){
			this.nom = nom;
			for (ElementInterface e : elements){
				if (e instanceof Signature ){
					listSign.append(e);
				} else {
					listFSField.append(e);
				}
			}
		}

		public String getName(){
			return "(Interface)" + this.nom;
		}

}