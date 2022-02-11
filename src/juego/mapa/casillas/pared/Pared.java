package juego.mapa.casillas.pared;

import juego.mapa.casillas.Casilla;

public class Pared extends Casilla{
	public Pared (String forma, int coordenadaX, int coordenadaY){
		this.setForma(forma);
		this.setX(coordenadaX);
		this.setY(coordenadaY);
		this.setVacio(false);
	}

}
