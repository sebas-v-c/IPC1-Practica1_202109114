package juego.mapa.casillas.pared;

import juego.mapa.casillas.Casilla;

public class Pared extends Casilla{
	public Pared (String forma){
		this.setForma(forma);
		this.setVacia(false);
		this.setRevisada(true);
		this.tipo = "pared";
	}

}
