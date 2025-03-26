package practica1ej7;

import java.util.*;


public class EjercicioSucesion {
    List<Integer> lista=new LinkedList<>();
    
    public List<Integer> calcularSucesion(int n){
        lista.add(n);
        if (n != 1){
            if ((n % 2)==0){
                calcularSucesion(n/2);
            }
            else {
                calcularSucesion((3*n)+1);
            }
        } 
        return lista;
    }
    
}
