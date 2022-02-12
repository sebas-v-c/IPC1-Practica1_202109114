package juego.mapa.casillas;

public class Casilla {
	protected int x;
	protected int y;
	protected String forma;
	protected String tipo = "casilla";
	protected boolean vacia = true;
	protected boolean revisada = false;
	protected boolean casEspecial = false;
	
	
	public boolean isRevisada() {
		return revisada;
	}
	
	public void setRevisada(boolean revisada) {
		this.revisada = revisada;
	}

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
	public boolean isVacia() {
		return vacia;
	}
	public void setVacia(boolean vacio) {
		this.vacia = vacio;
	}
	public boolean isCasEspecial() {
		return casEspecial;
	}
	public void setcasEspecial(boolean cEspecial) {
		this.casEspecial = cEspecial;
	}
	public String getTipo() {
		return tipo;
	}

}
