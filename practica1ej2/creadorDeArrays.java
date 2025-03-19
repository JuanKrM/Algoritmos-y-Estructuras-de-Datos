package practica1ej2;

public class creadorDeArrays {
	public static int[] crear(int n) {
		int[] aux= new int[n];
		for (int i=1;i<=n;i++) {
			aux[i-1]=n*i;
		}
		return aux;
	}
	public static void Informar(int[] v) {
		String aux="";
		for (int elto: v) {
			aux+=elto+" ";
		}
		System.out.println(aux);
	}
}
