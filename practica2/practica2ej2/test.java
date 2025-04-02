package practica2ej2;

public class test {

	public static void main(String[] args) {
		BinaryTree<Character> B=new BinaryTree<>();
		B.setData('B');
		B.addLeftChild(new BinaryTree<>('C'));
		B.addRightChild(new BinaryTree<>('D'));
		BinaryTree<Character> A=new BinaryTree<>('A');
		A.addLeftChild(B);
		A.addRightChild(new BinaryTree<>('E'));
		A.getRightChild().addRightChild(new BinaryTree<>('G'));
		A.getRightChild().addLeftChild(new BinaryTree<>('F'));
		A.imprimirArbol();
		System.out.println(A.contarHojas());
		//A.espejo();
		//A.imprimirArbol();
		A.entreNiveles(0, 2);
	}

}
