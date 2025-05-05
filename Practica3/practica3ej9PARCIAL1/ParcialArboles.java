/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3ej9PARCIAL1;

import java.util.*;
import practica3ej1.GeneralTree;

public class ParcialArboles {
 
    // Un árbol general es de selección si cada nodo tiene en su raíz el valor del menor de sus hijos
    // Yo para resolverlo use recorrido en profunidad Post Order 
    // ya que primero proceso los hijos y luego compraro con su padre
    
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        //Devuelve tru si es Seleccion, false si no lo es
        if (arbol == null || arbol.isEmpty()){
            return false;
        }
        return esDeSeleccionRecorrdio(arbol);
    }
    
    private static boolean esDeSeleccionRecorrdio(GeneralTree<Integer> ab){
        if (ab.isLeaf()){
            return true;
        }
        
        List<GeneralTree<Integer>> hijos = ab.getChildren();
        int minimoHijo = Integer.MAX_VALUE;
        for (GeneralTree<Integer> hijo : hijos){
            if (!esDeSeleccionRecorrdio(hijo)){
                return false;
            }
            int valorHijo = hijo.getData();
            if (valorHijo < minimoHijo){
                minimoHijo = valorHijo;
            }
        }
        return ab.getData().equals(minimoHijo);
    }
 
    public static void main(String[] args) {
        List <GeneralTree<Integer>> subChildren1 = new LinkedList <GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(35));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(35, subChildren1);
        
        List <GeneralTree<Integer>> subChildren2 = new LinkedList <GeneralTree<Integer>>();
        subChildren2.add(subAb1);
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(35, subChildren2);
        
        List <GeneralTree<Integer>> subChildren3 = new LinkedList <GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(35));
        subChildren3.add(new GeneralTree<Integer>(83));
        subChildren3.add(new GeneralTree<Integer>(90));
        subChildren3.add(new GeneralTree<Integer>(33));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(33, subChildren3);
        
        List <GeneralTree<Integer>> subChildren4 = new LinkedList <GeneralTree<Integer>>();
        subChildren4.add(new GeneralTree<Integer>(14));
        subChildren4.add(new GeneralTree<Integer>(12));
        //subChildren4.add(new GeneralTree<Integer>(18));
        subChildren4.add(subAb3);
        //GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(12, subChildren4);
        GeneralTree<Integer> subAb4 = new GeneralTree<Integer>(18, subChildren4);
        
        List <GeneralTree<Integer>> subArbIzq = new LinkedList <GeneralTree<Integer>>();
        subArbIzq.add(subAb2);
        subArbIzq.add(subAb4);
        GeneralTree<Integer> arbIzq = new GeneralTree<Integer>(12, subArbIzq);
        
        List <GeneralTree<Integer>> subArbDer = new LinkedList <GeneralTree<Integer>>();
        subArbDer.add(new GeneralTree<Integer>(25));
        GeneralTree<Integer> arbDer = new GeneralTree<Integer>(25, subArbDer);
        
        List <GeneralTree<Integer>> arbol = new LinkedList <GeneralTree<Integer>>();
        arbol.add(arbIzq);
        arbol.add(arbDer);
        GeneralTree<Integer> a = new GeneralTree<Integer>(12, arbol); 
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
    }
}

