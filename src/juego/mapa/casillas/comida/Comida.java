package juego.mapa.casillas.comida;

import juego.mapa.casillas.Casilla;

public class Comida extends Casilla{
	private int valor;
	
	Comida (int valor, String forma) {
		this.valor = valor;
		setForma(forma);
		this.setVacio(false);
	}

	public int getValor() {
		return valor;
	}
}
