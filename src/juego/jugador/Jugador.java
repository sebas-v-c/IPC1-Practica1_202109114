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
		entrada.setEdad(edad);
		entrada.setNombre(nombre);
		entrada.setPuntaje(punteo);
		entrada.setMovimientos(movimientos);
		return entrada;
	}


	public void pedirInfo(Scanner sc) {
		System.out.print("Ingrese su nombre: ");
		this.nombre = sc.next(); 
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


	public String getNombre() {
		return nombre;
	}


	public int getPunteo() {
		return punteo;
	}
	
	public void setPunteo(int punteo) {
		this.punteo = punteo;
	}


	public int getMovimientos() {
		return movimientos;
	}


	public void setMovimientos(int movimientos) {
		this.movimientos = movimientos;
	}
}
