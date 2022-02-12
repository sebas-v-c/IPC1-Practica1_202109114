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

	public static Historial[] ordenarH(Historial[] historial, Historial entrada) {
	    // Corremos el historial 1 a la izquierda
	    for (int i = 1; i < 11; i++) {
	    	historial[i-1] = historial[i];
	    }
	    historial[10] = entrada;
	    
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
