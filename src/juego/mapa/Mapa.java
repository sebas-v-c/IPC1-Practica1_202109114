package juego.mapa;

import java.util.Random;
import java.util.Scanner;

import juego.mapa.casillas.Casilla;
import juego.mapa.casillas.pared.Pared;

public class Mapa {
	private int dimX;
	private int dimY;
	private Casilla[][] mapa;
	private final int X = 0;
	private final int Y = 1;

	public void crearMapa() {
		Scanner sc = new Scanner(System.in);

		crearDimensiones(sc);
		mapa = new Casilla[dimX][dimY];
		// TODO agregar resto de parametros
		// Llenar pared superior e inferior
		for (int x = 0; x < dimX; x++) {
			mapa[x][0] = new Pared("***", x, 0);
			mapa[x][dimY-1] = new Pared("***", x, dimY-1);
		}
		// Llenar paredes laterales
		for (int y = 0; y < dimX; y++) {
			mapa[0][y] = new Pared("*", 0, y);
			mapa[dimX-1][y] = new Pared("*", dimX-1, y);
		}

		
		// TODO Llenar lo demas con paredes o comida
		llenarMapa(1, 1);
		
		
		// Imprimir mapa
		for (int i = 1; i < dimX - 1; i++) {
			for (int j = 1; j < dimY - 1; j++) {
				mapa[i][j] = new Pared(" * ", j, i);
					
				mapa[i][j] = new Casilla();
				mapa[i][j].setForma(" A ");
			}
		}
		
		imprimirMapa();
	}

	private void llenarMapa(int x, int y) {
		Random rand = new Random();
	}	

	private void imprimirMapa () {
		for (int i  = 0; i < (dimY); i++) {
			for (int j = 0; j < (dimX); j++) {
				System.out.print(mapa[j][i].getForma());
			}
			System.out.println();
		}
	}

	private void crearDimensiones(Scanner sc) {
		boolean datosValidos = false;
		System.out.println("Por favor ingrese el tamaño del mapa en el que\n"
				+ "usted desea jugar. (Mínimo 8 x 8)");

		while (!datosValidos) {
			System.out.print("Ingrese Ancho del mapa: ");
			dimX = sc.nextInt();
			dimX += 2; 
			System.out.print("Ingrese Alto del mapa: ");
			dimY = sc.nextInt();
			dimY += 2;
			
			if (!((dimX < 8) || (dimY < 8))) {
				datosValidos = true;
				continue;
			}
			System.out.println("Datos invalidos, por favor vuelva a ingresarlos");
		}
	}
}