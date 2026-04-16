package Practica2;

public class ejer9 {
	
	private BinaryTree<Numero> operar(BinaryTree<Integer> arbol, int suma, int resta) {
		suma+=arbol.getData();
		resta=arbol.getData()-resta;
		Numero n = new Numero(suma,resta);
		BinaryTree<Numero> num= new BinaryTree(n);
		if(arbol.hasLeftChild())
			num.addLeftChild(this.operar(arbol.getLeftChild(),suma,arbol.getData()));
		if(arbol.hasRightChild())
			num.addRightChild(this.operar(arbol.getRightChild(),suma,arbol.getData()));
		return num;
	}
	
	public BinaryTree<Numero> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Numero> num = new BinaryTree<>();
		if(!(arbol == null) && (!arbol.isEmpty()))
			num=this.operar(arbol,0,0);
		return num;
	}
	

}
