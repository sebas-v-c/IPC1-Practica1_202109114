package juego.mapa;

import java.util.Scanner;

public class Mapa {

	public void crearMapa() {
		int[] dimensiones = new int[2];
		Scanner sc = new Scanner(System.in);

		dimensiones = crearDimensiones(sc);
		
		// TODO agregar resto de parametros
		
		System.out.println("Se creo una matriz de "
		+ dimensiones[0] + " x " + dimensiones[1] + "!");
		
	}

	private int[] crearDimensiones(Scanner sc) {
		boolean datosValidos = false;
		int[] dimensiones = new int[2];
		System.out.println("Por favor ingrese el tamaño del mapa en el que\n"
				+ "usted desea jugar. (Mínimo 8 x 8)");

		while (!datosValidos) {
			System.out.print("Ingrese Ancho del mapa: ");
			dimensiones[0] = sc.nextInt();
			System.out.print("Ingrese Alto del mapa: ");
			dimensiones[1] = sc.nextInt();
			
			if (!((dimensiones[0] < 8) || (dimensiones[1] < 8))) {
				datosValidos = true;
				continue;
			}
			System.out.println("Datos invalidos, por favor vuelva a ingresarlos");
		}
		return dimensiones;
	}

}
