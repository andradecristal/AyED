package Practica2;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
	   if(this.isEmpty() || this.data==null)
		   return 0;
	   if(this.isLeaf())
		   return 1;
	   int contar=0;
	   if(this.hasLeftChild())
		   contar=+ this.leftChild.contarHojas();
	   if(this.hasRightChild())
		   contar=+this.rightChild.contarHojas();
	   return contar;
	}
		
    
    public BinaryTree<T> espejo() {
        if (this.isEmpty()) {
            return new BinaryTree<>();
        }
        BinaryTree<T> arbolEspejo = new BinaryTree<>(this.getData());
        if (this.hasLeftChild()) {
            arbolEspejo.addRightChild(this.getLeftChild().espejo());
        }
        if (this.hasRightChild()) {
            arbolEspejo.addLeftChild(this.getRightChild().espejo());
        }
        return arbolEspejo;
    }
    public void imprimirInOrden(BinaryTree<T> arbol) {
		// Verificamos que el árbol no sea nulo ni esté vacío por seguridad
		if (arbol != null && !arbol.isEmpty()) {
			
			// 1. Recorremos primero todo el subárbol IZQUIERDO
			if (arbol.hasLeftChild()) {
				imprimirInOrden(arbol.getLeftChild());
			}
			
			// 2. Imprimimos el dato de la RAÍZ (nodo actual)
			System.out.print(arbol.getData() + " ");
			
			// 3. Recorremos finalmente todo el subárbol DERECHO
			if (arbol.hasRightChild()) {
				imprimirInOrden(arbol.getRightChild());
			}
		}
	}
    
    

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		cola.add(this);
		int nivel=0;
		while(!cola.isEmpty() && nivel <= m) {
			int nodosEnEsteNivel = cola.size();
			for (int i = 0; i < nodosEnEsteNivel; i++) {
	            BinaryTree<T> arbolActual = cola.poll();
	            if (nivel >= n) {
	                System.out.print(arbolActual.getData() + " ");
	            }
	            if (arbolActual.hasLeftChild()) {
	                cola.add(arbolActual.getLeftChild());
	            }
	            if (arbolActual.hasRightChild()) {
	                cola.add(arbolActual.getRightChild());
	            }
	        }
	        nivel++;
   }
		
}
}

