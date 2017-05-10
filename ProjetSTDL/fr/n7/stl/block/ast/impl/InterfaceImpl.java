package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.interface;

public class InterfaceImpl implements Interface {

		private String nom;
		private 


		public InterfaceImpl(String nom, LinkedList<ElementInterface> elements){
			this.nom = nom;
		}

		public InterfaceImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<Type> heritages, LinkedList<ElementInterface> elements){
			this.nom = nom;
		}

		public InterfaceImpl(String nom, LinkedList<ParametreGenericite> parametresGen, LinkedList<ElementInterface> elements){
			this.nom = nom;
		}

		public InterfaceImpl(String nom, LinkedList<Type> heritages, LinkedList<ElementInterface> elements){
			this.nom = nom;
		}



		public String getName(){
			return this.nom;
		}

}