package Practica2;

import java.util.Stack;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	private int suma(int p, BinaryTree<Integer> arbol) {
			if(p==0) {
				return this.arbol.getData();
				}
			int iz=0;
			int de=0;
			if(this.arbol.hasLeftChild())
				iz=this.suma(p-1, arbol.getLeftChild());
			if(this.arbol.hasRightChild())
				de=this.suma(p-1,arbol.getRightChild());
			return iz+de;
		 
	}
	
	private int sumaElementosProfundidad (int p) {
		 if((this.arbol==null) && (this.arbol.isEmpty())) return 0;
		 else return suma(p,arbol);
	}
}
