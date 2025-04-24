
package practica2ej6;

import practica2ej2.BinaryTree;
        
public class TrasformacionJuanma {
    BinaryTree<Integer> arb; 
    
    public TrasformacionJuanma(BinaryTree<Integer> unArbol){
        arb = unArbol;
    }
    
    public int suma (BinaryTree<Integer>ab){
        int suma =0;
        if (arb.isLeaf()){
            suma = ab.getData();
            ab.setData(0);
            return suma;                              
        }
        if (ab.hasLeftChild()) suma+= suma(ab.getLeftChild());
        if (ab.hasRightChild()) suma+= suma(ab.getRightChild());
        int act = ab.getData();
        ab.setData(suma);
        return suma+act;
    }
    
    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        ab.imprimirArbol();
	Transformacion trasformado=new Transformacion(ab);
	trasformado.raiz.entreNiveles(0, 2);
	
	trasformado.suma();
	trasformado.raiz.entreNiveles(0, 2);
	}
}
