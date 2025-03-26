package practica1ej7;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;

public class test {
	
	public static void main(String[] args) {
		LinkedList<String> lista= new LinkedList<String>();
		lista.add("juanma");
		lista.add("felipe");
		lista.add("majer_gameplays777");
		//LinkedList<String> lista2=new LinkedList<String>(lista);
		String e="felipe";
		if (!lista.contains(e)) {
			lista.add(e);
		}
		System.out.println(lista.toString());
		//System.out.println(lista2.toString());
		//lista2.set(1, "felidira");
		//System.out.println(lista.toString());
		//System.out.println(lista2.toString());
		capicua test=new capicua();
		ArrayList<Integer> Alista=new ArrayList<>(Arrays.asList(2,3,5,5,3,2));
		System.out.println(test.esCapicua(Alista));
		System.out.println(Alista);
		Alista.set(1, 5);
		System.out.println(test.esCapicua(Alista));
		System.out.println(Alista);
                EjercicioSucesion prueba=new EjercicioSucesion();
                prueba.calcularSucesion(15);
                System.out.println("Esta es la lista de sucesion");
                System.out.println(prueba.lista.toString());
                EjercicioInvertir pruebaI=new EjercicioInvertir();
                pruebaI.invertirArrayList(pruebaI.lista); //consultar si está bien llamado
                System.out.println(pruebaI.lista); 
                LinkedList<Integer> Listasuma= new LinkedList<>(Arrays.asList(5,3,4,4,10,2));
                EjercicioSuma pruebaS=new EjercicioSuma();
                System.out.println(pruebaS.sumarLinkedList(Listasuma));
	}

}
