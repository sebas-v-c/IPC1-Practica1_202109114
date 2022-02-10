package juego.jugador;

import java.util.Scanner;

import juego.historial.Historial;
import juego.mapa.Mapa;

public class Jugador {
	private String nombre;
	private int edad;
	private int punteo = 0;
	private int movimientos = 0;
	
	
	public Historial infoPartida() {
		Historial entrada = new Historial();
		//TODO
		return entrada;
	}


	public void pedirInfo(Scanner sc) {
		System.out.print("Ingrese su nombre: ");
		this.nombre = sc.nextLine(); 
		System.out.print("Ingrese su edad: ");
		this.edad = sc.nextInt(); 
	}


	public void jugar(Mapa mapa) {
		System.out.println("Estoy jugando!");
		System.out.println("Presiona una tecla para salir");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		//TODO
		
	}
}
