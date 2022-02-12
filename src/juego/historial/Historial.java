package juego.historial;

import java.util.Scanner;

public class Historial {
	private String nombre = "XXXXXXXX";
	private int edad;
	private int puntaje;
	private int movimientos;
	public static Scanner sc = new Scanner(System.in);
	
	public Historial(){
		puntaje = 0;
		movimientos = 0;
	}

	// Algoritmo simple para ordenar las entradas del historial de menor a mayor
	// Vamos a utilizar el metodo de burbuja
	public static Historial[] ordenarH(Historial[] historial, Historial entrada) {
	    boolean ordenado = false;
	    Historial temp;
	    historial[0] = entrada;
	    while(!ordenado) {
	        ordenado = true;
	        for (int i = 0; i < 10; i++) {
	            if (historial[i].getTotal() > historial[i+1].getTotal()) {
	                temp = historial[i];
	                historial[i] = historial[i+1];
	                historial[i+1] = temp;
	                ordenado = false;
	            }
	        }
	    }
		return historial;
	}

	public static void imprimirH(Historial[] historial) {
		System.out.println("*********************************");
		for (int i = 1; i < 11; i++) {
			if (!historial[i].nombre.equals("XXXXXXXX")) {
				System.out.println("Nombre: " + historial[i].getNombre());
				System.out.println("Edad: " + historial[i].getEdad());
				System.out.println("Puntaje: " + historial[i].getPuntaje());
				System.out.println("Movimientos: " + historial[i].getMovimientos());
				System.out.println("*********************************");
			}
		}
		System.out.println("Ingresa cualquier caracter para salir");
		sc.next();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public int getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
	public double getTotal() {
		double movs = movimientos;
		return puntaje - (movs/100);
	}

	public static void llenar(Historial[] historial) {
		for (int i = 0; i < 11; i++) {
			historial[i] = new Historial();
		}

		
	}
}
