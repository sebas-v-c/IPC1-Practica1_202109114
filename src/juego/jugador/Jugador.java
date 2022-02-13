package juego.jugador;

import java.util.Scanner;

import juego.colores.Colores;
import juego.historial.Historial;
import juego.mapa.Mapa;
import juego.mapa.casillas.Casilla;
import juego.mapa.casillas.comida.Comida;
import juego.mapa.casillas.pacman.Pacman;

public class Jugador {
	private String nombre;
	private int edad;
	private int punteo = 10;
	private int agregados;
	private int movimientos = 0;
	private Scanner sc = new Scanner(System.in);
	private Pacman pacman;
	
	
	public Historial infoPartida() {
		Historial entrada = new Historial();
		entrada.setEdad(edad);
		entrada.setNombre(nombre);
		entrada.setPuntaje(punteo);
		entrada.setMovimientos(movimientos);
		return entrada;
	}


	public void pedirInfo() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("Ingrese su nombre: ");
		this.nombre = sc.nextLine(); 
		if (this.nombre.isBlank()) {
			this.nombre = "XXXXXXX";
		}
		System.out.print("Ingrese su edad: ");
		this.edad = sc.nextInt(); 
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}


	public void jugar(Mapa mapa) {
		String letra;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("   Muevete con WASD");
		System.out.println("   (pulsa M para salir)");
		pacman = new Pacman(" V ");
		mapa.colocarCasilla(pacman, pacman.getX(), pacman.getY());
		imprimirInfo();
		mapa.imprimirMapa();

		while (true) {
			if (punteo <= 0) {
				System.out.println(Colores.RED + "   Perdiste, Juego terminado :(" + Colores.RESET);
				System.out.println("   Ingresa cualquier cosa para continuar");
				sc.next();
				break;
			} 
			if (punteo > 100) {
				System.out.println(Colores.GREEN + "   Ganaste! " + nombre + Colores.RESET);
				System.out.println("   Ingresa cualquier cosa para continuar");
				sc.next();
				break;
			}
			System.out.print("   Ingresa un Movimiento (WASD o M): ");
			letra = sc.next();		
			System.out.println(letra);
			if (letra.equals("M") || letra.equals("m")) {
				System.out.print(Colores.RED + "\n   Seguro deseas selir del juego? (S/N): " + Colores.RESET);
				letra = sc.next();		
				if (letra.equals("s") || letra.equals("S")) {
					break;
				}
			}
			switch (letra) {
			case "w", "W":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				mover(mapa, 0,-1);
				imprimirInfo();
				mapa.imprimirMapa();
				break;
				
			case "a", "A":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				mover(mapa, -1,0);
				imprimirInfo();
				mapa.imprimirMapa();
				break;
			
			case "s", "S":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				mover(mapa, 0,1);
				imprimirInfo();
				mapa.imprimirMapa();
				break;
				
			case "d", "D":
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				mover(mapa, 1,0);
				imprimirInfo();
				mapa.imprimirMapa();
				break;
				
			default:
				System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
				System.out.println(Colores.RED + "   Letra inválida!" + Colores.RESET);
				imprimirInfo();
				mapa.imprimirMapa();
			}
			
		}
	}


	private void mover(Mapa mapa, int i, int j) {
		int dimX;
		dimX = mapa.getDimX();
		int posX = pacman.getX();
		int posY = pacman.getY();
		Casilla sigCas = mapa.getCasilla(i+posX, j+posY);
		System.out.println();
		if (sigCas.isVacia()) {
			mapa.cambiarCasillas(pacman, sigCas);
			movimientos++;
		}
		else if (sigCas.isCasEspecial()) {
			System.out.println(Colores.CYAN + "   Teletransportación!!" + Colores.RESET);
			Casilla cas = new Casilla();
			cas.setForma("   ");
			cas.setY(sigCas.getY());
			if (pacman.getX() == 1) {
				cas.setX(dimX-2);
			} else if (pacman.getX() == dimX-2){
				cas.setX(1);
			}
			movimientos++;
			mapa.cambiarCasillas(pacman, cas);
		}
		else if (sigCas.getTipo().equals("comida")) {
			Comida com = (Comida) sigCas;
			Casilla cas = new Casilla();
			cas.setForma("   ");
			cas.setX(com.getX());
			cas.setY(com.getY());
			if (com.getValor() > 0) {
				System.out.println(Colores.PURPLE + "   Ñam Ñam Ñam" + Colores.RESET);
			} else {
				System.out.println(Colores.RED + "   iuuugh!" + Colores.RESET);
			}
			agregados = com.getValor();
			punteo += com.getValor();
			mapa.cambiarCasillas(pacman, cas);
			mapa.colocarCasilla(sigCas, sigCas.getX(), sigCas.getY());
			movimientos++;
		}
		else {
			System.out.println(Colores.YELLOW + "   Pared!" + Colores.RESET);
		}
	}


	private void imprimirInfo() {
		System.out.println(Colores.BLUE + "   Nombre: "  + Colores.RESET + nombre);
		if (agregados > 0) {
			System.out.println(Colores.BLUE + "   Punteo: " + Colores.RESET + punteo +
					Colores.GREEN + " (+" + agregados + ")" + Colores.RESET);
		} else if (agregados < 0) {
			System.out.println(Colores.BLUE + "   Punteo: " + Colores.RESET + punteo +
					Colores.RED + " (" + agregados + ")" + Colores.RESET);
		}
		else {
			System.out.println(Colores.BLUE + "   Punteo: " + Colores.RESET + punteo);
		}
		agregados = 0;
		System.out.println(Colores.BLUE + "   Movimiento: " + Colores.RESET + movimientos);
		
	}
}
