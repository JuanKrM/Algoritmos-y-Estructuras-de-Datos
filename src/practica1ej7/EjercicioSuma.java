/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1ej7;

import java.util.LinkedList;

/**
 *
 * @author alumnos
 */
public class EjercicioSuma {
    Integer aux=0;
    
    public int sumarLinkedList(LinkedList<Integer> lista){
        if (!lista.isEmpty()){
            aux+=lista.remove(0);
            sumarLinkedList(lista);
        }
        return aux;
    }
    
}
