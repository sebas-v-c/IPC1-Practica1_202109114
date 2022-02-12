package juego.menu;

import juego.colores.Colores;

public class Menu {
	private boolean opcValida = false;
	private String modo;
	
	public void setModo(String opcion) {
		if ((!opcion.equals("1")) && (!opcion.equals("2")) && (!opcion.equals("3"))) {
			opcValida = false;
			mostrarMenu();
			System.out.println("Opcion invalida!");
			return;
		}
		opcValida = true;

		switch (opcion) {
		case "1":
			modo = "Juego";
			break;
		case "2":
			modo = "Historial";
			break;
		case "3":
			modo = "Salir";
			break;
		}
	}
	
	// Getter de la variable opcion valida
	public boolean opcValida() {
		return opcValida;
	}
	
	public String getModo() {
		return modo;
	}

	public void mostrarMenu() {
		opcValida = false;
		for (int i = 0; i < 20; i++) {
			System.out.println("");
		}
		System.out.println(Colores.YELLOW + "*****************************************************" + Colores.RESET);
		System.out.println(Colores.YELLOW  + "*    "  + Colores.RESET +"            BIENVENIDO A PAC-MAN!          " + Colores.YELLOW +"    *"+ Colores.RESET);
		System.out.println(Colores.YELLOW + "*****************************************************" + Colores.RESET);
		System.out.println(Colores.YELLOW  + "*   "  + Colores.RESET +"1. Jugar                                    " + Colores.YELLOW +"    *"+ Colores.RESET);
		System.out.println(Colores.YELLOW  + "*   "  + Colores.RESET +"2. Historial                                " + Colores.YELLOW +"    *"+ Colores.RESET);
		System.out.println(Colores.YELLOW  + "*   "  + Colores.RESET +"3. Salir                                    " + Colores.YELLOW +"    *"+ Colores.RESET);
		System.out.println(Colores.YELLOW + "*****************************************************" + Colores.RESET);
	}
	
	
}
