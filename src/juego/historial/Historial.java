package juego.historial;

public class Historial {
	private String nombre;
	private int edad;
	private int puntaje;
	private int movimientos;
	
	public Historial(){
		puntaje = 0;
		movimientos = 0;
	}

	public static Historial[] ordenarH(Historial[] historial, Historial entrada) {
		// TODO Auto-generated method stub
		return historial;
		
	}

	public static void imprimirH(Historial[] historial) {
		System.out.println("*********************************");
		for (int i = 0; i < 10; i++) {
			System.out.println("Nombre: " + historial[i].getNombre());
			System.out.println("Edad: " + historial[i].getEdad());
			System.out.println("Puntaje: " + historial[i].getPuntaje());
			System.out.println("Movimientos: " + historial[i].getMovimientos());
			System.out.println("*********************************");
		}
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public int getMovimientos() {
		return movimientos;
	}

}
