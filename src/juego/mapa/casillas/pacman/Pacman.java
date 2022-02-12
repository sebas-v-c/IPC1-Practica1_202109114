package juego.mapa.casillas.pacman;

import juego.mapa.casillas.Casilla;

public class Pacman extends Casilla{
	
	public Pacman(String forma){
		this.setForma(forma);
		this.setVacia(false);
		this.setRevisada(true);
		this.setX(0);
		this.setY(0);
		this.tipo = "pacman";
	}

}
