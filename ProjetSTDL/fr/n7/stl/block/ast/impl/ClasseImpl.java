package fr.n7.stl.block.ast.impl;

/**
 * @author okeee
 *
 */

import fr.n7.stl.block.ast.*;
import fr.n7.stl.block.ast.impl.*;
import java.util.LinkedList;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClasseImpl implements Classe {

		private String nom;
		private LinkedList<Interface> implementsInterfaces;
		private LinkedList<Classe> extendsClasses;
		protected LinkedList<ElementClasse> elements;
		private Register register;
		protected int offset;

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

		public boolean checkType(){

			boolean result = true;
			for(ElementClasse elt: elements){
				result = result && elt.checkType();
				if(!result){
					break;
				}
			}
			return result;
		}

		public boolean equalsTo(Classe classe){
			return this.nom.equals(classe.getName());
		}

		public LinkedList<Classe> getHeritage(){
			return this.extendsClasses;
		}

		public LinkedList<Interface> getInterface(){
			return this.implementsInterfaces;
		}

		public LinkedList<Constructeur> getConstructeurs(){
			LinkedList<Constructeur> constructeurs = new LinkedList<Constructeur>();
			for(ElementClasse e : elements){
				if (e instanceof Constructeur){
					constructeurs.add(((Constructeur)e));
				}
			}
			return constructeurs;
		}

		public ClasseImpl makeLiaisonTardive(LinkedList<Classe> classes, LinkedList<Interface> interfaces){
			
			LinkedList<ElementClasse> declaredElements = new LinkedList<ElementClasse>();
			ElementClasse declaredElement;
			for(ElementClasse elem : this.elements){
				declaredElement = elem.makeLiaisonTardive(classes,interfaces);
				if(declaredElement == null){
					throw new SemanticsUndefinedException("Cannot declare " + elem);
				}
				declaredElements.add(declaredElement);

			}
			this.elements = declaredElements;
			return this;

		}


		public boolean containsSignature(String id, LinkedList<Type> listTypeParam){
			for(ElementClasse elem : this.elements){
				if(elem instanceof MethodeImpl){
					LinkedList<Type> listType = new LinkedList<Type>();
					for(Parametre p : ((MethodeImpl)elem).getParametres()){
						listType.addFirst(p.getType());
					}
					if( elem.getName().equals(id) && listType.equals(listTypeParam)) {
						return true;
					} 
				}
			}
			return false;
		}

		public Methode getSignature(String id, LinkedList<Type> listTypeParam){
			for(ElementClasse elem : this.elements){
				if(elem instanceof MethodeImpl){
					LinkedList<Type> listType = new LinkedList<Type>();
					for(Parametre p : ((MethodeImpl)elem).getParametres()){
						listType.addFirst(p.getType());
					}
					if( elem.getName().equals(id) && listType.equals(listTypeParam)) {
						return (MethodeImpl) elem;
					} 
				}
			}
			return null;
		}

		public boolean containsMethode(String id){
			for(ElementClasse elem : this.elements){
				if(elem instanceof MethodeImpl && elem.getName().equals(id)){
					return true;
				}
			}
			return false;
		}

		public Methode getMethode(String id){
			for(ElementClasse elem : this.elements){
				if(elem instanceof MethodeImpl && elem.getName().equals(id)){
					return ((Methode)elem);
				}
			}
			return null;
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

		public LinkedList<ElementClasse> getElements(){
			return elements;
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

		public int allocateMemory(Register _register, int _offset){
			int local_offset = _offset;
			for(ElementClasse elem : elements){
				local_offset += elem.allocateMemory(_register,_offset);
			}

			this.offset = local_offset - _offset;
			this.register = register;
			return local_offset;
		}

		public Fragment getCode(TAMFactory _factory){
			Fragment code = _factory.createFragment();
			for(ElementClasse elem : elements){
				code.append(elem.getCode(_factory));
			}
			return code;
		}

}
