package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.classe;

public class ClasseImpl implements Classe {

		private String nom;
		private LinkedList<Methode> listMethodes;
		private LinkedList<Attribut> listAttributs;
		//PublicStaticFields ?????

		public InterfaceImpl(String nom, LinkedList<ElementClasse> elements){
			this.nom = nom;
			for (ElementClasse e : elements){
				if (e instanceof Methode ){
					listMethodes.append(e);
				} else {
					listAttributs.append(e);
				}
			}
		}

		public String getName(){
			return "(Classe)" + this.nom;
		}

}

}