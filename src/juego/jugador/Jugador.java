package juego.jugador;

import java.util.Scanner;

import juego.historial.Historial;
import juego.mapa.Mapa;
import juego.mapa.casillas.Casilla;
import juego.mapa.casillas.comida.Comida;
import juego.mapa.casillas.pacman.Pacman;

public class Jugador {
	private String nombre;
	private int edad;
	private int punteo = 10;
	private int movimientos = 0;
	private Scanner sc = new Scanner(System.in);
	private Pacman pacman;
	private int dimX;
	
	
	public Historial infoPartida() {
		Historial entrada = new Historial();
		entrada.setEdad(edad);
		entrada.setNombre(nombre);
		entrada.setPuntaje(punteo);
		entrada.setMovimientos(movimientos);
		return entrada;
	}


	public void pedirInfo() {
		System.out.print("Ingrese su nombre: ");
		this.nombre = sc.next(); 
		if (this.nombre.isBlank()) {
			this.nombre = "XXXXXXX";
		}
		System.out.print("Ingrese su edad: ");
		this.edad = sc.nextInt(); 
	}


	public void jugar(Mapa mapa) {
		dimX = mapa.getDimX();
		String letra;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Muevete con WASD");
		System.out.println("(pulsa M para salir)");
		pacman = new Pacman(" V ");
		mapa.colocarCasilla(pacman, pacman.getX(), pacman.getY());

		while (true) {
			if (punteo <= 0) {
				System.out.println("Perdiste, Juego terminado :(");
				System.out.println("Ingresa cualquier cosa para continuar");
				sc.next();
				break;
			} 
			if (punteo > 100) {
				System.out.println("Ganaste!" + nombre);
				System.out.println("Ingresa cualquier cosa para continuar");
				sc.next();
				break;
			}
			imprimirInfo();
			mapa.imprimirMapa();
			System.out.print("Ingresa un Movimiento (WASD o M): ");
			letra = sc.next();		
			if (letra.equals("m") || letra.equals("M")) {
				System.out.print("\nSeguro deseas selir del juego? (S/N): ");
				letra = sc.nextLine();		
				if (letra.equals("s") || letra.equals("S")) {
					System.out.println("Adios!");
					break;
				}
			}
			switch (letra) {
			case "w", "W":
				mover(mapa, 0,-1);
				break;
				
			case "a", "A":
				mover(mapa, -1,0);
				break;
			
			case "s", "S":
				mover(mapa, 0,1);
				break;
				
			case "d", "D":
				mover(mapa, 1,0);
				break;
				
			default:
				System.out.println("Letra invalida!");
			}
			
		}
	}


	private void mover(Mapa mapa, int i, int j) {
		int posX = pacman.getX();
		int posY = pacman.getY();
		Casilla sigCas = mapa.getCasilla(i+posX, j+posY);
		System.out.println();
		if (sigCas.isVacia()) {
			mapa.cambiarCasillas(pacman, sigCas);
			movimientos++;
		}
		else if (sigCas.isCasEspecial()) {
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
			punteo += com.getValor();
			mapa.cambiarCasillas(pacman, cas);
			mapa.colocarCasilla(sigCas, sigCas.getX(), sigCas.getY());
			movimientos++;
		}
	}


	private void imprimirInfo() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Punteo: " + punteo);
		System.out.println("Movimiento: " + movimientos);
		
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
