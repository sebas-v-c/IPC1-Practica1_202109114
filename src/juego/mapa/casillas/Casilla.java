package juego.mapa.casillas;

public class Casilla {
	private int x;
	private int y;
	private char forma;
	private boolean vacio = true;

	public char getForma() {
		return forma;
	}
	public void setForma(char forma) {
		this.forma = forma;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isVacio() {
		return vacio;
	}
	public void setVacio(boolean vacio) {
		this.vacio = vacio;
	}

}
