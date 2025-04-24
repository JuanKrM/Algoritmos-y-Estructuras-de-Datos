package practica2ej3;

import java.util.LinkedList;
import practica2ej2.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> dato;
	LinkedList<Integer> l=new LinkedList<>();
	
	public boolean esPar(BinaryTree<Integer> d) {
		return ((d.getData()%2)==0);
	}
	
	public void numerosParesIn() {
		numerosParesIn(dato);
	}
	
	public void numerosParesIn(BinaryTree<Integer> next){
		// primera vez
		if (next.hasLeftChild()) {
			numerosParesIn(next.getLeftChild());
		}
		// segunda vez, imprime
		if (esPar(next)) l.add(next.getData());
		if (next.hasRightChild()) {
			numerosParesIn(next.getRightChild());
		}
		// tercera vez
	}
	
	public void numerosParesPos() {
		numerosParesPos(dato);
	}
	
	public void numerosParesPos(BinaryTree<Integer> next) {
		// primera vez
		if (next.hasLeftChild()) {
			numerosParesIn(next.getLeftChild());
		}
		// segunda vez
		if (next.hasRightChild()) {
			numerosParesIn(next.getRightChild());
		}
		// tercera vez, imprime
		if (esPar(next)) l.add(next.getData());
	}
}
