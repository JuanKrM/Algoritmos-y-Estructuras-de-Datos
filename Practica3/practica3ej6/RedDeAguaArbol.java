package practica3ej6;

import practica3ej1.GeneralTree;
import java.util.*;

public class RedDeAguaArbol {
    private GeneralTree<Character> ab;

    public RedDeAguaArbol(GeneralTree<Character> ab) {
        this.ab = ab;
    }
    
    public double minimoCaudal(double caudal){
        if (ab.isEmpty()){
            return 0;
        }else{
            if (!ab.isLeaf()){ //Si se cumple el es el unico nodo del arbol
                return minimoCaudalRecorrido(caudal,ab);
            }else{
                return caudal;
            }
        }
    }
    
    private double minimoCaudalRecorrido(double caudal, GeneralTree<Character> ab){
        if (ab.isLeaf()){
            return caudal;
        }
        
        List<GeneralTree<Character>> hijos = ab.getChildren();
        int cantHijos = hijos.size();
        
        //caudal para cada hijo
        double caudalxHijo = caudal / cantHijos;
        double minimo = Double.MAX_VALUE;
        
        //Recorremos y obtenesmos el minimo caudal por hoja
        for (GeneralTree<Character> hijo : hijos){
            double caudalHijo = minimoCaudalRecorrido(caudalxHijo,hijo);
            if (caudalHijo < minimo){
                minimo = caudalHijo;
            }
        }
        return minimo;
    }
}
