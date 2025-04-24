package practica2ej5;

import practica2ej2.BinaryTree;

public class ProfundidadArbolJuanma {
    private BinaryTree<Integer> arbol=new BinaryTree<>(); 

    public ProfundidadArbolJuanma(BinaryTree<Integer> arbolTest) {
        arbol=arbolTest;
    }
    
    public int tomarElementos(BinaryTree<Integer> nodo,int profundidad,int act){
        int suma=0;
        if (act==profundidad){
            return nodo.getData();
        }else{
            if (nodo.hasLeftChild()) suma += tomarElementos(nodo.getLeftChild(),profundidad,act+1);
            if (nodo.hasRightChild()) suma += tomarElementos(nodo.getRightChild(),profundidad,act+1);
            return suma;
        }
    }
    
    public int sumaElementosProfundidad (int profundiad){
        return tomarElementos(arbol,profundiad,0);
    }
 
}
