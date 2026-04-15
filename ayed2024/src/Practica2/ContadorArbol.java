package Practica2;

import java.util.ArrayList;
import java.util.List;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;

	public ContadorArbol(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	public List<Integer> numerosPares() {
        List<Integer> pares = new ArrayList<>();
        if (this.arbol != null && !this.arbol.isEmpty()) {
            this.inOrden(pares, this.arbol);
        }
        return pares;
    }

    private void inOrden(List<Integer> pares, BinaryTree<Integer> arbol) {
        if (arbol.hasLeftChild()) {
            this.inOrden(pares, arbol.getLeftChild());
        }
        if (arbol.getData() != null && arbol.getData() % 2 == 0) {
            pares.add(arbol.getData());
        }
        if (arbol.hasRightChild()) {
            this.inOrden(pares, arbol.getRightChild());
        }
    }
    
    public void postOrden(List<Integer> pares, BinaryTree<Integer> arbol) {
    	if(arbol.hasLeftChild()) {
    		this.postOrden(pares, arbol.getLeftChild());
    	}
    	if(arbol.hasRightChild()) {
    		this.postOrden(pares, arbol.getRightChild());
    	}
    	if(arbol.getData() != null && arbol.getData()%2 == 0) {
    		pares.add(arbol.getData());
    	}
    }
    
    public List<Integer> numeroPar(){
    	List<Integer> pares = new ArrayList<>();
    	if(this.arbol != null && !this.arbol.isEmpty()) {
    		this.postOrden(pares,this.arbol);
    	}
    	return pares;
    }
}
