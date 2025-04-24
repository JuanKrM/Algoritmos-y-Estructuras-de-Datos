package practica2ej2;

import java.util.*;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int aux=0;
		if (this.isLeaf()) {
			return 1;
		} else {
			if(this.hasLeftChild()) {
				aux+=this.getLeftChild().contarHojas();
			}
			if (this.hasRightChild()) {
				aux+=this.getRightChild().contarHojas();
			}
		}
	    return aux;
	}
	 
    public BinaryTree<T> espejo(){
        BinaryTree<T> aux = new BinaryTree<T>(this.getData()); //Creacion del nodo

        if(this.hasLeftChild()) 
            aux.addRightChild(this.getLeftChild().espejo()); //Si tiene hijo izquierdo agrego hijo derecho

        if(this.hasRightChild()) 
            aux.addLeftChild(this.getRightChild().espejo()); //Si tiene hijo derecho agrego hijo izquierdo

        return aux; 
        }
    
	
	// 0<=n<=m
    public void entreNiveles(int n, int m) {
        if (this.isEmpty() || n < 0 || m < n) return;

        Queue<BinaryTree<T>> cola = new LinkedList<>(); 
        cola.add(this); // Agrega el nodo raíz (asumiendo que "this" es el árbol)

        int nact = 0;

        while (!cola.isEmpty() && nact <= m) {
            int nodosenact = cola.size();

            if (nact >= n && nact <= m) {
                String aux = "";
                for (int i = 0; i < nodosenact; i++) {
                    
                    BinaryTree<T> nodo = cola.poll(); // Usa poll() para obtener y remover el elemento
                    aux += nodo.getData() + " | ";

                    if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
                System.out.println(aux); // Imprime el nivel actual
            } else {
                // Si no está en el rango, solo remueve los nodos del nivel actual
                for (int i = 0; i < nodosenact; i++) {
                    BinaryTree<T> nodo = cola.poll();
                    if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
                    if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
                }
            }

            nact++;
        }
    }

	public void imprimirArbol() {
        if(this.hasLeftChild()) 
            this.getLeftChild().imprimirArbol();

        System.out.print(this.getData() + " ");

        if(this.hasRightChild()) 
            this.getRightChild().imprimirArbol();
    }
	
	
		
}

