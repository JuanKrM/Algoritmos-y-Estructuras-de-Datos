package practica1ej1;
import java.util.Scanner;

public class Ej1 {
Scanner Scan = new Scanner(System.in);

	public static void enumFor(int a, int b) {
		for (int i=a;i<=b;i++) {
			System.out.println(i);
		}
	}
	
	public static void enumWhile(int a, int b) {
		while (a<=b){
			System.out.println(a);
			a++;
		}
	}
	
	public static void enumRec(int a, int b) {
		if (a<=b) {
			System.out.println(a);
			a++;
			enumRec(a,b);
		}
	}
	
}
