package practica1ej7;

import java.util.ArrayList;

public class capicua {
	
	public boolean esCapicua(ArrayList<Integer> lista) {
		ArrayList<Integer> aux=new ArrayList<Integer>(lista);
		int fin=aux.size()-1;
		while (!(aux.size()<=1)) {
			if (aux.get(0).equals(aux.get(fin))) {
				aux.remove(fin); aux.remove(0);
				fin=aux.size()-1;
			}
			else return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
