package juego.menu;

public class Menu {
	private boolean opcValida = false;
	private String modo;
	
	public void setModo(int opcion) {
		if ((opcion != 1) && (opcion != 2) && (opcion != 3)) {
			opcValida = false;
			mostrarMenu();
			System.out.println("Opcion invalida!");
			return;
		}
		opcValida = true;

		switch (opcion) {
		case 1:
			modo = "Juego";
			break;
		case 2:
			modo = "Historial";
			break;
		case 3:
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
		System.out.println("*****************************************************");
		System.out.println("*                BIENVENIDO A PAC-MAN!              *");
		System.out.println("*****************************************************");
		System.out.println("*   1. Jugar                                        *");
		System.out.println("*   2. Historial                                    *");
		System.out.println("*   3. Salir                                        *");
		System.out.println("*****************************************************");
	}
	
	
}
