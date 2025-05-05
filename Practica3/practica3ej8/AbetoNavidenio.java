/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3ej8;

import java.util.*;
import practica3ej1.GeneralTree;

public class AbetoNavidenio {
    private GeneralTree<Integer> ab;

    public AbetoNavidenio(GeneralTree<Integer> ab) {
        this.ab = ab;
    }
    
    //Un abeto navideño tiene exactamente 3 o mas hijos
    
    public String esAbetoNavidenio(){
        boolean aux = esUnAbeto(ab); //Llamo al metodo esUnAbeto que devuelve tru si tieen mas o 3 hijos
        if (aux){
            return "YES";
        }else{
            return "NO";
        }
    }
    
    private boolean esUnAbeto (GeneralTree<Integer> ab){
        int cantNodoHoja = 0; //Inicializo contador
        for (GeneralTree<Integer> hijos : ab.getChildren()){ //Itero la cantidad de hijos del arbol
            if (hijos.isLeaf()){ //Si el nodo actual tiene hijos
                cantNodoHoja++; //Incremento
            }else{              //Si no tiene hijos
                if (!esUnAbeto(hijos)){ //Pregunto si el nodo actual no tiene 3 o mas hijo ya no cumple entonces retorno
                    return false;
                }
            }
        }
        return cantNodoHoja>=3; //Si tiene mas o igual a 3 retorna TRU sino FALSE
    }
    
}
