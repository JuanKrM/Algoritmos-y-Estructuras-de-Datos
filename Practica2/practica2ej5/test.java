package practica2ej5;

import practica2ej2.BinaryTree;

public class test {

	public static void main(String[] args) {
		BinaryTree<Integer> B=new BinaryTree<>();
		B.setData(2);
		B.addLeftChild(new BinaryTree<>(3));
		B.addRightChild(new BinaryTree<>(4));
		BinaryTree<Integer> A=new BinaryTree<>(1);
		A.addLeftChild(B);
		A.addRightChild(new BinaryTree<>(5));
		A.getRightChild().addRightChild(new BinaryTree<>(7));
		A.getRightChild().addLeftChild(new BinaryTree<>(6));
		A.entreNiveles(0, 2);
		ProfundidadDeArbolBinario pruebaP= new ProfundidadDeArbolBinario(A);
		System.out.println("compaa "+pruebaP.sumaElemtosProfundidad(2));
	}

}
