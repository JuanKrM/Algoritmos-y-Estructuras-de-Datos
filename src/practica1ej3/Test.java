package practica1ej3;

public class Test {

	public static void main(String[] args) {
		Estudiante[] aEst= new Estudiante[2];
		aEst[0]= new Estudiante("juan","valcarcel",3,"paquito","callefalsa 123");
		aEst[1]= new Estudiante("felipe","dirazar",5,"caquito","callefalsa 124");
		Profesor[] aProf= new Profesor[3];
		aProf[0]= new Profesor("paco","alcazar","gmail","kukarda","unlp");
		aProf[1]= new Profesor("paco","alcazar2","gmail","libertonta","ucalp");
		aProf[2]= new Profesor("paco","alcazar3","gmail","radicheta","unlp");
		for (Estudiante e: aEst) {
			System.out.println(e.tusDatos());
			System.out.println("---");
		}
		for (Profesor p: aProf) {
			System.out.println(p.tusDatos());
			System.out.println("---");
		}
	}

}
