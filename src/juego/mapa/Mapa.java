package juego.mapa;

import java.util.Random;
import java.util.Scanner;

import juego.mapa.casillas.Casilla;
import juego.mapa.casillas.comida.Comida;
import juego.mapa.casillas.pared.Pared;

public class Mapa {
	private int dimX;
	private int dimY;
	private Casilla[][] mapa;
	private Random rand = new Random();
	private final int PAREDES = 4;
	private final int COMIDA = 100;

	public void crearMapa() {
		Scanner sc = new Scanner(System.in);

		crearDimensiones(sc);
		mapa = new Casilla[dimX][dimY];
		// Llenar mapa con casillas internas vacias
		for (int i = 1; i < dimX - 1; i++) {
			for (int j = 1; j < dimY - 1; j++) {
				mapa[i][j] = new Casilla();
				mapa[i][j].setForma("   ");
			}
		}

		// Llenar pared superior e inferior
		for (int x = 0; x < dimX; x++) {
			mapa[x][0] = new Pared("***");
			mapa[x][dimY-1] = new Pared("***");
		}
		// Llenar paredes laterales
		for (int y = 0; y < dimY; y++) {
			if (y == (dimY/2)) {
				Casilla especial = new Casilla();
				especial.setcasEspecial(true);
				especial.setForma(" ");
				especial.setRevisada(true);
				mapa[0][y] = especial;
				mapa[dimX-1][y] = especial;
				mapa[1][y].setRevisada(true);
				mapa[dimX-2][y].setRevisada(true);
				continue;
			}
			mapa[0][y] = new Pared("*");
			mapa[dimX-1][y] = new Pared("*");
		}
		// Generamos paredes
		for (int y = 1; y < (dimY-1); y++) {
			for (int x = 1; x < (dimX-1); x++) {
				if (!mapa[x][y].isRevisada()) {
					generarPared(x, y);
				}
			}
		}
		// Vamos a establecer por lo menos la aparicion aleatoraia
		// de 1 item de comida de cada uno
		int[] pos = posAleatoria();
		mapa[pos[0]][pos[1]] = new Comida(-10, " # ", pos[0], pos[1]);
		pos = posAleatoria();
		mapa[pos[0]][pos[1]] = new Comida(15, " $ ", pos[0], pos[1]);
		pos = posAleatoria();
		mapa[pos[0]][pos[1]] = new Comida(10, " @ ", pos[0], pos[1]);
		// Los demas items de comida seran aleatorios dependiendo del
		// Tamanio de la matriz
		for (int i = 0; i < dimX*dimY; i++) {
			int num = rand.nextInt(COMIDA);
			if (num == 0) {
				pos = posAleatoria();
				mapa[pos[0]][pos[1]] = new Comida(-10, " # ", pos[0], pos[1]);
			} else if (num == 1) {
				pos = posAleatoria();
				mapa[pos[0]][pos[1]] = new Comida(15, " $ ", pos[0], pos[1]);				
			} else if (num == 2) {
				pos = posAleatoria();
				mapa[pos[0]][pos[1]] = new Comida(10, " @ ", pos[0], pos[1]);
			}
		}
	}	

	private int[] posAleatoria() {
		int[] pos = new int[2];
		pos[0] = rand.nextInt(dimX);
		pos[1] = rand.nextInt(dimY);
		while (!mapa[pos[0]][pos[1]].isVacia()) {
			pos[0] = rand.nextInt(dimX);
			pos[1] = rand.nextInt(dimY);
		}
		return pos;
	}

	private void generarPared(int x, int y) {
		int num = rand.nextInt(PAREDES);
		int numVecin = contarVecinos(x, y);
		int[][] vecinDisp = new int[numVecin][2];
		int cont = 0;
		// Llenamos una array con coordenadas de vecinos dispobiles
		if (!mapa[x-1][y].isRevisada()) {
			vecinDisp[cont][0] = x-1;
			vecinDisp[cont][1] = y;
			cont++;
		}
		if (!mapa[x][y-1].isRevisada()) {
			vecinDisp[cont][0] = x;
			vecinDisp[cont][1] = y-1;
			cont++;
		}
		if (!mapa[x+1][y].isRevisada()) {
			vecinDisp[cont][0] = x+1;
			vecinDisp[cont][1] = y;
			cont++;
		}
		if (!mapa[x][y+1].isRevisada()) {
			vecinDisp[cont][0] = x;
			vecinDisp[cont][1] = y+1;
			cont++;
		}
		
		/* Si el numero aleatorio es 0 entonces vamos a iniciar a generar una
		 * pared. y marcar las casillas cercanas como ya visitadas para dejar
		 * Espacios en blanco
		 * Luego vamos a llamar nuevamente la funcion para seguir generando
		 * la pared, hasta que salga otro numero, en dado caso marcamos la
		 * Casilla como una casilla vacia y visitada
		 */

		if (num == 0) {
			// Vamos a seleccionar un vecino aleatorio de la array que creamos
			int vecino;
			if (numVecin != 0) {
				vecino = rand.nextInt(numVecin);
				mapa[x][y] = new Pared(" * ");
			} else {
				mapa[x][y] = new Pared(" * ");
				return;
			}
			int posX = vecinDisp[vecino][0];
			int posY = vecinDisp[vecino][1];
			// Colocamos el resto de vecinos como no vacios
			for (int i = 0; i<numVecin; i++) {
				mapa[vecinDisp[i][0]][vecinDisp[i][1]].setRevisada(true);
			}
			// modificamos la array principal para mostrar la pared
			// Volvemos a probar suerte en la casilla que salio como candidata
			mapa[x][y].setRevisada(true);
			generarPared(posX, posY);
		}
		mapa[x][y].setRevisada(true);
	}	
	
	
	private int contarVecinos(int x, int y) {
		int vecinos = 0;
		if (!mapa[x-1][y].isRevisada()) {
			vecinos++;
		}
		if (!mapa[x][y-1].isRevisada()) {
			vecinos++;
		}
		if (!mapa[x+1][y].isRevisada()) {
			vecinos++;
		}
		if (!mapa[x][y+1].isRevisada()) {
			vecinos++;
		}
		
		return vecinos;
	}

	public void imprimirMapa () {
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