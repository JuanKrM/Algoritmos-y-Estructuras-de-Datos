package practica1ej2;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int n=input.nextInt();
		while (n != 69) {
			creadorDeArrays.Informar(creadorDeArrays.crear(n));
			n=input.nextInt();
		}
	}

}
