/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2ej4;
import practica2ej2.BinaryTree;

public class RedBinaria {
    private BinaryTree<Integer> red;
    
    public RedBinaria(BinaryTree<Integer> unArbol){ //Constructor con arbol
        this.red=unArbol;        
    }
    
    public int retardoLLAMADO(){
        if (!red.isEmpty())
            return retardoSuma(red);
        else
            return 0;
    }
    
    private int retardoSuma(BinaryTree<Integer> red){
        int Hi=0;
        int Hd=0;
        if (red.hasLeftChild())
            Hi = retardoSuma(red.getLeftChild());
        if (red.hasRightChild())
            Hd = retardoSuma(red.getRightChild());
        return (Math.max(Hi, Hd)+ red.getData());
    }
    
    public static void main (String[] args) {       
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        RedBinaria red = new RedBinaria(ab);
        
        System.out.println("El mayor retardo posible es de: " + red.retardoLLAMADO()+ " segundos");
    }
}
