package Practica2;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	private int contarHojas(BinaryTree<Integer> arbol) {
		int contador=0;
		if(!arbol.isLeaf()) {
			if((arbol.hasLeftChild()) && (!arbol.hasRightChild()))
				contador = 1 + this.contarHojas(arbol.getLeftChild());
			else {
				if((!arbol.hasRightChild()) && (arbol.hasLeftChild()))
					contador = 1 +this.contarHojas(arbol.getRightChild());
			}
	            contador = 0 + contarHojas(arbol.getLeftChild()) + 
	            		contarHojas(arbol.getRightChild());
		}
		return contador;
	}

	private BinaryTree<Integer> buscar(BinaryTree<Integer> arbol, int num) {
		BinaryTree<Integer> nuevo = null;
		if(arbol.getData().equals(num)) {
			nuevo=arbol;
		}
		else {
			if((arbol.hasLeftChild()) && (nuevo == null))
				nuevo=buscar(arbol.getLeftChild(),num);
			if((arbol.hasRightChild()) && (nuevo == null))
				nuevo=buscar(arbol.getLeftChild(),num);
		}
		return nuevo;
	}

	public boolean isLeftTree (int num) {
		boolean hojas=false;
		if((arbol!=null) && (!arbol.isEmpty())) {
			BinaryTree<Integer> nuevo = null;
			nuevo=this.buscar(arbol,9);
			if(nuevo != null) {
				if(nuevo.hasLeftChild()) {
					int izquierda=this.contarHojas(nuevo.getLeftChild());
					int derecha=-1;
					if(nuevo.hasRightChild())
						derecha=this.contarHojas(nuevo.getRightChild());
					if(izquierda>derecha)
						hojas=true;
				}
			}
		}
		return hojas;	
	}
}
