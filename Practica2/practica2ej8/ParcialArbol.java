/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2ej8;

import practica2ej2.BinaryTree;

public class ParcialArbol {
    
    public boolean esPrefijo(BinaryTree<Integer> arb1,BinaryTree<Integer> arb2){
        // Caso 1: Ambos vacíos = TRUE
        if (arb1.isEmpty() && arb2.isEmpty()) {
            return true;
        }
        
        // Caso 2: Uno vacío y el otro no = FALSE
        if (arb1.isEmpty() || arb2.isEmpty()) {
            return false;
        }
        
        // Caso 3: Ambos tienen nodos = VERIFICAR
        return esPrefijoChequeo(arb1, arb2);
    }
    
    private boolean esPrefijoChequeo(BinaryTree<Integer> arb1,BinaryTree<Integer> arb2){
        if (arb1.getData() != arb2.getData()) { //VERIFICO SI LOS DATOS DE LOS NODOS SON IGUALES
            return false;
        }
        
        //Chequeo Hijos izquierdo
        if (arb1.hasLeftChild()){ 
            if (!arb2.hasLeftChild()){
                return false;
            }
            if (!esPrefijoChequeo(arb1.getLeftChild(), arb2.getLeftChild())){
                return false;
            }
        }
        
        //Chequeo Hijos derecho
        if (arb1.hasRightChild()){
            if (!arb2.hasRightChild()){
                return false;
            }
            if (!esPrefijoChequeo(arb1.getRightChild(),arb2.getRightChild())){
                return false;
            }
        }
        return true;
    }

}
