package Practica2;

import java.util.Stack;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;

	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	
	
		private int retardoReenvio(BinaryTree<Integer> red) {
	        int retHI = 0;
	        int retHD = 0;
	        if(!red.isLeaf()) {
	            retHI = retardoReenvio(red.getLeftChild());
	            retHD = retardoReenvio(red.getRightChild());
	        }
	        return (Math.max(retHI, retHD)+ red.getData());
	 }
		
		private int otra(BinaryTree<Integer> red) {
			if(red.isLeaf()) {
				return red.getData();
			}
			else
				return (Math.max(this.retardoReenvio(red.getLeftChild()), this.retardoReenvio(red.getRightChild()))+red.getData());
		}
	
	
	 public int retardoReenvio() {
		 if((this.arbol==null) && (this.arbol.isEmpty())) return 0;
		 else return retardoReenvio(this.arbol);
	 }
	 
	 public static BinaryTree<Integer> crearArbolDeLaImagen() {
	        
	        // --- NIVEL 0 ---
	        // Creamos la raíz
	        BinaryTree<Integer> raiz = new BinaryTree<>(10);

	        // --- NIVEL 1 ---
	        // Creamos los hijos de la raíz
	        BinaryTree<Integer> nodo2 = new BinaryTree<>(2);
	        BinaryTree<Integer> nodo3 = new BinaryTree<>(3);
	        
	        // Los conectamos a la raíz
	        raiz.addLeftChild(nodo2);
	        raiz.addRightChild(nodo3);

	        // --- NIVEL 2 ---
	        // Creamos los hijos del nodo 2 (rama izquierda)
	        BinaryTree<Integer> nodo5 = new BinaryTree<>(5);
	        BinaryTree<Integer> nodo4 = new BinaryTree<>(4);
	        nodo2.addLeftChild(nodo5);
	        nodo2.addRightChild(nodo4);

	        // Creamos los hijos del nodo 3 (rama derecha)
	        BinaryTree<Integer> nodo9 = new BinaryTree<>(9);
	        BinaryTree<Integer> nodo8 = new BinaryTree<>(8);
	        nodo3.addLeftChild(nodo9);
	        nodo3.addRightChild(nodo8);

	        // --- NIVEL 3 (Hojas) ---
	        // Hijos del nodo 5
	        nodo5.addLeftChild(new BinaryTree<>(7));
	        nodo5.addRightChild(new BinaryTree<>(8));

	        // Hijos del nodo 4
	        nodo4.addLeftChild(new BinaryTree<>(5));
	        nodo4.addRightChild(new BinaryTree<>(6));

	        // Hijos del nodo 9
	        nodo9.addLeftChild(new BinaryTree<>(12));
	        nodo9.addRightChild(new BinaryTree<>(8));

	        // Hijos del nodo 8
	        nodo8.addLeftChild(new BinaryTree<>(2));
	        nodo8.addRightChild(new BinaryTree<>(1));

	        // Devolvemos el árbol ya completamente armado
	        return raiz;
	    }

	    public static void main(String[] args) {
	      
	        BinaryTree<Integer> miArbol = crearArbolDeLaImagen();
	       
	       RedBinariaLlena red= new RedBinariaLlena(miArbol);
	        
	        System.out.println(red.retardoReenvio());
	    }
}
