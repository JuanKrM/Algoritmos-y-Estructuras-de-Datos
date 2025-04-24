/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2ej9;

import practica2ej2.BinaryTree;

public class ParcialArbol {
    
    public BinaryTree<NodoLoco> ArbolNew(BinaryTree<Integer> arbol){
        if (arbol.isEmpty()){
            return new BinaryTree<>(); // Si el original esta vacio retorno arbol vacio
        }
        BinaryTree<NodoLoco> arbNew= new BinaryTree<NodoLoco>();
        int valorRaiz = arbol.getData();
        arbNew.setData(new NodoLoco(valorRaiz,0));
        
        crearArbolSumaDif(arbol,arbNew,valorRaiz);
        return arbNew;
    }
    
    private void crearArbolSumaDif(BinaryTree<Integer> arbol, BinaryTree<NodoLoco> arbNew,int suma){
        int act = arbol.getData();
        
        //Hijo Izquierdo
        if (arbol.hasLeftChild()){
            BinaryTree<Integer> hijoIzqOriginal = arbol.getLeftChild(); //Nodo hijo ORIGINAL
            //Nuevo Nodo Hijo MODIFICADO
            BinaryTree<NodoLoco> hijoIzqNuevo = new BinaryTree<>(new NodoLoco(suma+ hijoIzqOriginal.getData(), hijoIzqOriginal.getData() - act));
            //Agregado al nuevo arbol
            arbNew.addLeftChild(hijoIzqNuevo);
            //Llamado recurisvo
            crearArbolSumaDif(hijoIzqOriginal, hijoIzqNuevo,suma+ hijoIzqOriginal.getData());
        }
        
        //Hijo Derecho (Repito lo de arriba)
        if (arbol.hasRightChild()){
            BinaryTree<Integer> hijoDerOriginal = arbol.getRightChild();
            BinaryTree<NodoLoco> hijoDerNuevo = new BinaryTree<>(new NodoLoco(suma+ hijoDerOriginal.getData(), hijoDerOriginal.getData() - act));
            arbNew.addRightChild(hijoDerNuevo);
            crearArbolSumaDif(hijoDerOriginal, hijoDerNuevo,suma+ hijoDerOriginal.getData());
        }
    }

}

