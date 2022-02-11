package juego.mapa.casillas;

public class Casilla {
	protected int x;
	protected int y;
	protected String forma;
	protected boolean vacio = true;
	protected boolean casEspecial = false;

	public String getForma() {
		return forma;
	}
	public void setForma(String forma) {
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
	public boolean iscasEspecial() {
		return casEspecial;
	}
	public void setcasEspecial(boolean cEspecial) {
		this.casEspecial = cEspecial;
	}

}
