package juego.historial;

import java.util.Scanner;

import juego.colores.Colores;

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
	    for (int i = 1; i < 20; i++) {
	    	historial[i-1] = historial[i];
	    }
	    historial[10] = entrada;
	    
		return historial;
	}

	public static void imprimirH(Historial[] historial) {
		System.out.println(Colores.GREEN + "*********************************" + Colores.RESET);
		for (int i = 1; i < 20; i++) {
			if (!historial[i].nombre.equals("XXXXXXXX")) {
				System.out.println(Colores.CYAN + "  Nombre: " +Colores.RESET+ Colores.RED + historial[i].getNombre() + Colores.RESET);
				System.out.println(Colores.CYAN + "  Edad: " +Colores.RESET+ Colores.RED + historial[i].getEdad() + Colores.RESET);
				System.out.println(Colores.CYAN + "  Puntaje: " +Colores.RESET+ Colores.RED + historial[i].getPuntaje() + Colores.RESET);
				System.out.println(Colores.CYAN + "  Movimientos: " +Colores.RESET+ Colores.RED + historial[i].getMovimientos() + Colores.RESET);
				System.out.println(Colores.GREEN + "*********************************" + Colores.RESET);
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
		for (int i = 0; i < 20; i++) {
			historial[i] = new Historial();
		}
	}
}
