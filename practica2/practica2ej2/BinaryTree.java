package practica2ej2;

import practica1ej8.*;

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
		BinaryTree<T> aux=null;
		if (this.hasLeftChild()) {
			aux=this.getLeftChild();
		}
		if (this.hasRightChild()) {
			if (aux!=null) {
				this.addLeftChild(this.getRightChild());
				this.addRightChild(aux);
			} else {
				this.addLeftChild(getRightChild());
				this.addRightChild(null);
			}
		} 
		return this;
    }
    
	
	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this.isEmpty() || n<0 || m<n) return;
		Queue<BinaryTree<T>> cola= new Queue<>();
		cola.enqueue(this);
		int nact= 0;
		while (!cola.isEmpty() && nact<=m) {
			int nodosenact=cola.size();
			if (nact>=n && nact<=m) {
				String aux="";
				for (int i=0;i<nodosenact;i++) {
					BinaryTree<T> nodo=cola.dequeue();
					aux+=nodo.getData()+" | ";
					if (nodo.hasLeftChild())  cola.enqueue(nodo.getLeftChild());
					if (nodo.hasRightChild()) cola.enqueue(nodo.getRightChild());
					if (nact>=n && nact<=m) System.out.println();
					}
				System.out.println(aux);
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

