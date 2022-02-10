package juego.mapa;

import java.util.Scanner;

public class Mapa {

	public void crearMapa() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner();
		
	}

	static int[] leerTamanio(Scanner sc) {
		boolean datosValidos = false;
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
	}

}
