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
		ArrayList<Integer> Alista=new ArrayList<Integer>(Arrays.asList(2,3,5,3,2));
		System.out.println(test.esCapicua(Alista));
		System.out.println(Alista);
		Alista.set(1, 5);
		System.out.println(test.esCapicua(Alista));
		System.out.println(Alista);
	}

}
