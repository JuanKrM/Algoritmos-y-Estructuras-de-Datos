package practica3ej1;

import java.util.*;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
        
        
        // ALTURA: Devuelve la altura del árbol, es decir, la longitud del camino más largo
        //         desde el nodo raíz hasta una hoja.
	public int altura() {	 
            if (this.isEmpty()) { // Si el árbol está vacío
            return 0;
            }

            List <GeneralTree<T>> hijos = this.getChildren();
            if (hijos.isEmpty()){   // Si es un nodo HOJA
                return 0;
            }

            int maxAltura = 0;
            for (GeneralTree<T> H : hijos ){
                int hijoAltura = H.altura(); // Altura del subárbol hijo
                if (hijoAltura > maxAltura){
                    maxAltura = hijoAltura; // Actualizar Maximo
                }
            }
            
            return 1 + maxAltura; // UNO arista hacia el hijo más profundo
	}
        
        
        // NIVEL : devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo
        //         es la longitud del único camino de la raíz al nodo.
        
	public int nivel(T dato){
            if (this.isEmpty()){
                return 0;   // ARBOL VACIO
            }
            
            Queue<GeneralTree<T>> queue = new LinkedList <>();
            queue.add(this);// Encolo Raiz
            int nivel = 0;
            
            while (!queue.isEmpty()){
                int nivelSize = queue.size(); // NODOS NIVEL ACTUAL
                for (int i =0;i < nivelSize; i++){
                    GeneralTree<T> l = queue.poll();
                    if (l.getData().equals(dato)){ // SI EL DATO EL IGUAL
                        return nivel;
                    }
                    queue.addAll(l.getChildren()); // ENCOLO A SUS HIJOS
                }
                nivel++; // Siguiente nivel
            }
            return -1; //Dato no encontrado
        }

        
        // ANCHO : la amplitud (ancho) de un árbol se define como la cantidad de nodos que
        //         se encuentran en el nivel que posee la mayor cantidad de nodos.
        
	public int ancho(){
            if (this.isEmpty()){
                return 0; //ARBOL VACIO
            }
            
            Queue<GeneralTree<T>> queue = new LinkedList<>();
            queue.add(this);
            int maxAncho = 0;
            
            while (!queue.isEmpty()){
                int levelSize = queue.size(); // Cantidad de nodos en el nivel actual
                maxAncho = Math.max(maxAncho, levelSize); // Acualizo maximo
                for (int i = 0; i < levelSize; i++){ 
                    GeneralTree<T> l = queue.poll();
                    queue.addAll(l.getChildren());       // Encolar hijos
                }
            }
            return maxAncho;
        }
        
        
}