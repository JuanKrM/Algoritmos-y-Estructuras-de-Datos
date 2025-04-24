package practica3ej2;

import practica3ej1.GeneralTree;
import java.util.*;

public class RecorridoAg {
    private GeneralTree<Integer>a;

    public RecorridoAg(GeneralTree<Integer> a) {
        this.a = a;
    }

    public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a,Integer n){
        List <Integer> l = new LinkedList<Integer>(); //CREO LISTA VACIA
        if (!a.isEmpty()) this.numerosImparesMayoresQuePreOrden(a,n,l); //SI EL ARBOL TIENEN DATOS LLAMO AL METODO PRIVADO
        return l; //DEVUELVO LA LISTA TODA HERMOSA
    }

    private void numerosImparesMayoresQuePreOrden(GeneralTree <Integer> a,Integer n,List <Integer> l){
        int dato=a.getData();                                      // ALMACENO DATO ACTUAL
        if (dato %2 != 0 && dato>n){                               // Verifico si es PAR  y mayor que N
            l.add(dato);                                           // AÑADO AL DATO A LA LISTA
        }
        List <GeneralTree<Integer>> hijitos = a.getChildren();     // OBTIENE A LOS HIJOS 
        for (GeneralTree<Integer> bebe: hijitos){                  // RECORRE A SU HIJOS
            numerosImparesMayoresQuePreOrden(bebe,n,l);            // LLAMADO RECURSIVO
        }
    }

    public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n){
        List <Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty())
            this.numerosImparesMayoresQueInOrden(a,n,l);
        return l;
    }

    private void numerosImparesMayoresQueInOrden (GeneralTree <Integer> a,Integer n,List <Integer> l){
        if(a.hasChildren()) {
            numerosImparesMayoresQueInOrden(a.getChildren().get(0), n, l);    //PRIMER  HIJO
        }
        int dato = a.getData();
        if (dato %2 != 0 && dato>n){            // RAIZ 
            l.add(dato);
        }
        for (int i=1;i< a.getChildren().size();i++){
            numerosImparesMayoresQueInOrden(a.getChildren().get(i),n,l);     //HIJOS RESTANTES
        }
    }

    public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a,Integer n){
        List <Integer> l = new LinkedList<Integer>();
        if (!a.isEmpty()){
            this.numerosImparesMayoresQuePostOrden(a,n,l);
        }
        return l;
    }

    private void numerosImparesMayoresQuePostOrden(GeneralTree <Integer> a, Integer n, List <Integer> l){
        
        //Porcesamos PRIMERO HIJOS
        for (GeneralTree<Integer> hijo : a.getChildren()){
            numerosImparesMayoresQuePostOrden(hijo,n,l);
        }
        
        //Procesamos ULTIMO RAIZ
        int dato = a.getData();
        if (dato%2!=0 && dato>n){
            l.add(dato);
        } 
    }   
        
    public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a,Integer n){
        List <Integer> l = new LinkedList<Integer>();
        GeneralTree<Integer> aux;
        Queue<GeneralTree<Integer>> queue = new LinkedList<>(); //QUEUE JAVA UTIL
        queue.add(a); //Encolamos raiz arbol
        
        while (!queue.isEmpty()){ //Mientra tenga nodos
            aux = queue.poll(); //Desencolamos el primer nodo
            if (!aux.isEmpty()){ //Si el nodo no esta vacio
                int dato = aux.getData();
                if (dato%2 != 0 && dato > n) //Si cumple
                    l.add(dato); //Agrego a la lista
            }
            for (GeneralTree<Integer> hijos : aux.getChildren()){ //Encolo todos los hijos
                queue.add(hijos);
            }
        } 
        return l;
    }

}
