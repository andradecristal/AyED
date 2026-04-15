package Practica2;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;

	public ParcialArboles(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	private int left(BinaryTree<Integer> arbol) {
		int cont=0;
		if ((arbol.hasRightChild()) & !(arbol.hasLeftChild())) 
			cont += 1 + this.left(arbol.getRightChild()); 
		if (arbol.hasLeftChild() & !(arbol.hasRightChild()))
			cont += 1 + this.left(arbol.getLeftChild());
		return cont;
	}
	
	private boolean tree(BinaryTree<Integer> arbol, int num) {
		if(arbol.getData()==num) {
			int iz;
			int de;
			if(arbol.hasLeftChild())
				iz=this.left(arbol.getLeftChild());
			else
				iz=-1;
			if(arbol.hasRightChild())
				de=this.left(arbol.getRightChild());
			else
				de=-1;
			return (iz>de) ? true : false;	
		}
		boolean esta=false;
		if((arbol.hasLeftChild()) && !(arbol.hasRightChild()))
			esta= this.tree(arbol.getLeftChild(), num);
		if((arbol.hasRightChild()) && !(arbol.hasLeftChild()))
			esta= this.tree(arbol.getRightChild(), num);
		return esta;
		
	}
	
	public boolean isLeftTree (int num) {
		if((this.arbol==null) && (this.arbol.isEmpty())) return false;
		else return tree(this.arbol,num);
		
	}
}
