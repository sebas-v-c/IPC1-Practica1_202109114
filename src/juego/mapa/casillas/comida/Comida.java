package juego.mapa.casillas.comida;

import juego.mapa.casillas.Casilla;

public class Comida extends Casilla{
	private int valor;
	
	public Comida (int valor, String forma, int coordenadaX, int coordenadaY) {
		this.valor = valor;
		setForma(forma);
		this.setVacio(false);
		this.setX(coordenadaX);
		this.setY(coordenadaY);
	}

	public int getValor() {
		return valor;
	}
}
