package Practica2;

public class ejer8 {
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		boolean es=true;
		if((arbol1==null) || (arbol1.isEmpty()))
			es=false;
		else {
			if((arbol2==null) || (arbol2.isEmpty()))
				es=false;
			else {
				if(arbol1.getData().equals(arbol2.getData())) {
					if((arbol1.hasLeftChild()) && (es))
						es=this.esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
					if((arbol1.hasRightChild()) && (es))
						es=this.esPrefijo(arbol1.getRightChild(), arbol2.getRightChild()); 
				}
				else
					es=false;
			}
		}
		return es;
	}
	
}