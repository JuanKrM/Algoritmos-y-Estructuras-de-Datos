/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica1ej7;

import java.util.ArrayList;
import java.util.Arrays;

public class EjercicioInvertir {
    ArrayList<Integer> lista=new ArrayList<>(Arrays.asList(5,4,3,2,1)); //consultar si está bien
    ArrayList<Integer> aux=new ArrayList<>();
    
    public void invertirArrayList(ArrayList<Integer> l){
        if (!l.isEmpty()){
           aux.add(l.remove(l.size()-1));
           invertirArrayList(l);
        }
        lista=aux;
    }
}
