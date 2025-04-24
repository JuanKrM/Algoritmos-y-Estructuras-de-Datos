package practica2ej5;

import practica2ej2.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> ab=new BinaryTree<>(); 

	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbolaprobar) {
		ab=arbolaprobar;
	}
	
	public int tomarElemento(BinaryTree<Integer> n,int p, int nact) {
		int suma=0;
		if (nact==p) {
			return n.getData();
		} else {
			if (n.hasLeftChild()) suma+=tomarElemento(n.getLeftChild(),p,nact+1);
			if (n.hasRightChild()) suma+=tomarElemento(n.getRightChild(),p,nact+1);
			return suma;
		}
	}
	
	public int sumaElemtosProfundidad (int p) {
		return tomarElemento(ab,p,0);
	}
	
}
