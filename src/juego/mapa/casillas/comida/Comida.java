package juego.mapa.casillas.comida;

import juego.mapa.casillas.Casilla;

public class Comida extends Casilla{
	private int valor;
	
	public Comida (int valor, String forma) {
		this.valor = valor;
		setForma(forma);
		this.setVacia(false);
		this.setRevisada(true);
		this.tipo = "comida";
	}

	public int getValor() {
		return valor;
	}
}
