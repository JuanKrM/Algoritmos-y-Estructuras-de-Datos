/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2ej7;

import practica2ej2.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> ab;
    
    public ParcialArboles (BinaryTree<Integer> unArbol){
        this.ab = unArbol;
    }

    public BinaryTree<Integer> getAb() {
        return ab;
    }
    
    public int contarHijoUNICO (BinaryTree<Integer> ab){ //Contar nodos con un solo hijo en el subárbol de arb.
        int cant = 0;
        if (ab.hasLeftChild()) cant += contarHijoUNICO(ab.getLeftChild());
        if (ab.hasRightChild()) cant += contarHijoUNICO(ab.getRightChild());
        if( (ab.hasLeftChild() && !ab.hasRightChild()) || (!ab.hasLeftChild() && ab.hasRightChild())) cant++;
        return cant;
    }
    
    private boolean isLeftTree (BinaryTree<Integer> ab){ // Determinar si el subárbol izquierdo de arb tiene más nodos con un solo hijo que el derecho.
        int Hizq=-1;
        int Hder=-1;
        if (ab.hasLeftChild()) Hizq = contarHijoUNICO(ab.getLeftChild());
        if (ab.hasRightChild()) Hder = contarHijoUNICO(ab.getRightChild());        
        return Hizq>Hder;
    }
    
    private BinaryTree<Integer> buscar (BinaryTree<Integer> ab, int num) { // Buscar un nodo con valor num en el árbol.
    if(ab.getData() == num)
        return ab;
    
    BinaryTree<Integer> res = new BinaryTree<Integer>();
    if(ab.hasLeftChild()) {
        res = buscar(ab.getLeftChild(), num);
    }
    if((ab.hasRightChild()) && (res.isEmpty())) { // PRIORIZANDO HIJO IZQ
        res = buscar(ab.getRightChild(), num);
    }
    return res;
    }
    
    public boolean isLeftTree (int num){ //Busca el nodo con valor num.
        BinaryTree<Integer> arb = buscar(ab, num);
        if (!arb.isEmpty()){
            return isLeftTree(ab);
        } else {
           return false;
        }
    }
    
    public static void main (String[] args) { 
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
        
        ParcialArboles parcialArb = new ParcialArboles(ab);
        System.out.println("Resultado=" + parcialArb.isLeftTree(2));
    }
}
