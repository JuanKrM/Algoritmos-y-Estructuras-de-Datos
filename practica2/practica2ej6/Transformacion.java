package practica2ej6;

import practica2ej2.BinaryTree;

public class Transformacion {
	BinaryTree<Integer> raiz=new BinaryTree<Integer>();
	
	public Transformacion(BinaryTree<Integer> n) {
		raiz=n;
	}
	
	public BinaryTree<Integer> suma() {
		suma(raiz);
		return raiz;
	}
	
	public int suma(BinaryTree<Integer> ab){
		int sum=0;
		if(ab.isLeaf()) {
            sum = ab.getData();
            ab.setData(0);
            return sum;
        }
		if (ab.hasLeftChild()) {
			sum+= suma(ab.getLeftChild());
			}
		if (ab.hasRightChild()) {
			sum+= suma(ab.getRightChild());
			}
		int actual= ab.getData();
		ab.setData(sum);
		return sum+actual;
	}
 	
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
		Transformacion t=new Transformacion(A);
		t.raiz.entreNiveles(0, 2);
		
		t.suma();
		t.raiz.entreNiveles(0, 2);
	}

}
