package practica1ej1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner Scan = new Scanner(System.in);
		int a=Scan.nextInt();
		int b=Scan.nextInt();
		Ej1.enumFor(a,b);
		System.out.println("---");				
		Ej1.enumWhile(a, b);
		System.out.println("---");
		Ej1.enumRec(a, b);

	}

}
