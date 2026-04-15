package Practica2;

public class Transformation {
	private BinaryTree<Integer> arbol;

	public Transformation(BinaryTree<Integer> arbol) {
		super();
		this.arbol = arbol;
	}
	
	private int su(BinaryTree<Integer> arbol){
		int iz=0;
		int de=0;
		int valor=arbol.getData();
		if(arbol.hasLeftChild())
			iz=this.su(arbol.getLeftChild());
		if(arbol.hasRightChild())
			de=this.su(arbol.getRightChild());
		arbol.setData(iz+de);
		return valor+iz+de;
	}
		
	
	public BinaryTree<Integer> suma(){
		if((this.arbol==null) && (this.arbol.isEmpty())) return null;
		else {
			su(this.arbol);
			return this.arbol;
		}
	}	
}
