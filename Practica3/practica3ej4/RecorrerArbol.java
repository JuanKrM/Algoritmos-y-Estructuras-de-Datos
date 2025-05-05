package practica3ej4;
import java.util.*;
import practica3ej1.GeneralTree;
import practica3ej1.Queue; 


public class RecorrerArbol {
    public double devolverMaximoProm (GeneralTree<AreaEmpresa>arbol){
        if (arbol.isEmpty())
            return -1;
        else
        {
            if (!arbol.isLeaf()){
                return devolverMaximoPromedioExtendido(arbol);
            }else{
                return arbol.getData().getTardanza();
            }
        }
    }
    
    private double devolverMaximoPromedioExtendido(GeneralTree<AreaEmpresa>arbol){
        double suma = 0;
        double max = 0;
        int cant = 0;
        GeneralTree<AreaEmpresa> aux;
        Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        cola.enqueue(arbol);
        cola.enqueue(null);
        while (!cola.isEmpty()){
            aux = cola.dequeue();//Extraer nodo actual en nuestra auxiliar
            if (aux != null){ //Si es un nodo valido Operamos con el mismo
                cant++;
                suma += aux.getData().getTardanza();
                
                //Encolamos sus hijos para el proximo nivel
                List<GeneralTree<AreaEmpresa>> hijos = aux.getChildren();
                for (GeneralTree<AreaEmpresa> hijo: hijos){ //Agregamos a sus hermanos
                    cola.enqueue(hijo);
                }
            }else
                if (!cola.isEmpty()){ //Si es null y la cola NO esta vacia tendremos que calcular el promedio
                    double promedio = suma / cant;
                    max = Math.max(promedio,max);
                    
                    //Preparacion para el siguiente nivel
                    cola.enqueue(null); // Nueva marca de fin de nivel;
                    suma = 0;   //REINICIAMOS CONTADORES
                    cant = 0;
                }
            }
            return max; 
        }
    
    public static void main(String[] args) {
        List<GeneralTree<AreaEmpresa>> children1 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("A",4)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("B",7)));
        children1.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("C",5)));
        GeneralTree<AreaEmpresa> a1 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("J",13), children1);
        
        List<GeneralTree<AreaEmpresa>> children2 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("D",6)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("E",10)));
        children2.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("F",18)));
        GeneralTree<AreaEmpresa> a2 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("K",25), children2);
        
        List<GeneralTree<AreaEmpresa>> children3 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("G",9)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("H",12)));
        children3.add(new GeneralTree<AreaEmpresa>(new AreaEmpresa("I",19)));
        GeneralTree<AreaEmpresa> a3 = new GeneralTree<AreaEmpresa>(new AreaEmpresa("L",10), children3);
        
        List<GeneralTree<AreaEmpresa>> children4 = new LinkedList<GeneralTree<AreaEmpresa>>();
        children4.add(a1);
        children4.add(a2);
        children4.add(a3);
        GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa("M",14), children4);
        
        RecorrerArbol arb = new RecorrerArbol ();
        System.out.println("El mayor promedio entre todos los valores promedios de los niveles es: " + arb.devolverMaximoProm(a));
    }
    
}
