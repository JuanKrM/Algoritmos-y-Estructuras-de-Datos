package practica2ej3;

import java.util.LinkedList;

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
		ContadorArbol pruebaPar=new ContadorArbol();
		pruebaPar.numerosParesIn(A);
		System.out.println(pruebaPar.l.toString());
		pruebaPar.l=new LinkedList<>();
		pruebaPar.numerosParesPos(A);
		System.out.println(pruebaPar.l.toString());
	}

}
