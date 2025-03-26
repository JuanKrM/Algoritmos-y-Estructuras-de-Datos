package practica1ej5;

public class calcularArray {
	arrayMinMaxProm datosaux=new arrayMinMaxProm();
	
	public static arrayMinMaxProm calcular1(int[] array){
		arrayMinMaxProm aux=new arrayMinMaxProm();
		int min=999; int max=0; float suma=0;
		for (int e: array) {
			if (e>max) max=e;
			if (e<min) min=e;
			suma+=e;
			}
		aux.setMaximo(max);
		aux.setMinimo(min);
		aux.setPromedio(suma/array.length);
		return aux;
	}
	
	public static void calcular2(int[] array, arrayMinMaxProm datos) {
		int min=999; int max=0; float suma=0;
		for (int e: array) {
			if (e>max) max=e;
			if (e<min) min=e;
			suma+=e;
			}
		datos.setMaximo(max);
		datos.setMinimo(min);
		datos.setPromedio(suma/array.length);
	}
	
	public void calcular3() {
		int[] array = {5,3,12,12,12};
		int min=999; int max=0; float suma=0;
		for (int e: array) {
			if (e>max) max=e;
			if (e<min) min=e;
			suma+=e;
			}
		datosaux.setMaximo(max);
		datosaux.setMinimo(min);
		datosaux.setPromedio(suma/array.length);
	}

	public static void main(String[] args) {
		int[] array = {5,3,12,12,12};
		arrayMinMaxProm prueba = new arrayMinMaxProm();
		prueba=calcular1(array);
		System.out.println(prueba.getMinimo()+" "+prueba.getMaximo()+" "+prueba.getPromedio());
		calcular2(array, prueba);
		System.out.println(prueba.getMinimo()+" "+prueba.getMaximo()+" "+prueba.getPromedio());
		calcularArray obj=new calcularArray();
		obj.calcular3();
		System.out.println(obj.datosaux.getMinimo()+" "+obj.datosaux.getMaximo()+" "+obj.datosaux.getPromedio());
		
	}

}