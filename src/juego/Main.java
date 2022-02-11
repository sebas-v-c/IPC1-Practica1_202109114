package juego;

import java.util.Scanner;

import juego.historial.Historial;
import juego.jugador.Jugador;
import juego.mapa.Mapa;
import juego.menu.Menu;

public class Main {
	public static void main(String[] args) {
		boolean continuarJuego = true;
		int opcion;
		Menu menu = new Menu();
		Scanner sc = new Scanner(System.in);
		Historial[] historial = new Historial[10];

		while (continuarJuego) {		
			menu.mostrarMenu();
			while (!menu.opcValida()) {
				opcion = sc.nextInt();
				menu.setModo(opcion);
			}	
			
			limpiarConsola();
			switch(menu.getModo()) {
			case "Juego":
				System.out.println("Inicio modo de juego");
				Mapa mapa = new Mapa();
				Jugador jugador = new Jugador();
				// Completo
				jugador.pedirInfo(sc);
				// Incompleto
				mapa.crearMapa();
				// No iniciado
//				jugador.jugar(mapa);
				// Incompleto
//				historial = Historial.ordenarH(historial, jugador.infoPartida());
				break;

			case "Historial":
				System.out.println("Acceso al historial");
				// Incompleto
//				Historial.imprimirH(historial);
				break;

			case "Salir":
				continuarJuego = false;
				break;
			}
		}
		System.out.println("Adiosito");
	}
	
	static void limpiarConsola() {
		for (int i = 0; i < 15; i++) {
			System.out.println("");
		}
	}	
}
