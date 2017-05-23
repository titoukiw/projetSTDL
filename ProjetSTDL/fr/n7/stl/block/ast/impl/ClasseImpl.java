package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import java.util.LinkedList;

public class ClasseImpl implements Classe {

		private String nom;
		private LinkedList<Interface> implementsInterfaces;
		private LinkedList<Classe> extendsClasses;
		private LinkedList<ElementClasse> elements;

		public ClasseImpl(String nom, LinkedList<Interface> implementsInterfaces, LinkedList<Classe> extendsClasses, LinkedList<ElementClasse> elements){
			this.nom = nom;
			this.implementsInterfaces = implementsInterfaces;
			this.extendsClasses = extendsClasses;
			this.elements = elements;
		}

		public String getName(){
			return this.nom;
		}

		public Type getType(){
			return new ClasseTypeImpl(this);
		}

		public boolean equalsTo(Classe classe){
			return this.nom.equals(classe.getName());
		}

		public boolean containsAttribut(String id){
			for(ElementClasse elem : this.elements){
				if (elem instanceof AttributImpl && elem.getName().equals(id)){
					return true;
				}
			}
			return false;
		}

		public Expression getAttribut(String id){
			for(ElementClasse elem : this.elements){
				if (elem instanceof AttributImpl && elem.getName().equals(id)){
					return elem;
				}
			}
			return null;
		}

		public String toString(){
			String toString = "\n (Classe) " + this.nom;
			if(this.implementsInterfaces.size() > 0){
				toString += " implements";
				for (Interface inter : this.implementsInterfaces) {
					toString += " " + inter.getName() + " ," ;
				}
			}

			if(this.extendsClasses.size() > 0) {
				toString += " extends";
				for(Classe classe : this.extendsClasses){
					toString += " " + classe.getName() + " ,";
				}
			}

			toString += " { \n";

			for(ElementClasse element : this.elements) {
				toString += "\n\t" + element.toString();
			}

			toString += "\n }";
			return toString;
		}

}
