package juego.mapa.casillas.comida;

import juego.mapa.casillas.Casilla;

public class Comida extends Casilla{
	private int valor;
	
	Comida (int valor, char forma) {
		this.valor = valor;
		setForma(forma);
	}

	public int getValor() {
		return valor;
	}
}
