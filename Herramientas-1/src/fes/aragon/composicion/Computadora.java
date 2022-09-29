package fes.aragon.composicion;

public class Computadora {
	private String marca;
	private int anio;
	private Teclado teclado;
	private Monitor pantalla;
	private Mouse raton;
	private TarjetaGrafica grafica;
	private Bocinas musica;
	
	public Computadora() {
			
	}
		
	public Computadora(String marca, int anio, Teclado teclado, Monitor pantalla, Mouse raton,
			TarjetaGrafica grafica, Bocinas musica) {
		this.marca = marca;
		this.anio = anio;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public int getAnio() {
		return this.anio;
	}
		
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	public Teclado getTeclado() {
		return this.teclado;
	}
		
	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}
	
	public Monitor getMonitor() {
		return this.pantalla;
	}
		
	public void setMonitor(Monitor pantalla) {
		this.pantalla = pantalla;
	}
	
	public Mouse getMouse() {
		return this.raton;
	}
		
	public void setMouse(Mouse raton) {
		this.raton = raton;
	}
	
	public TarjetaGrafica getGrafica() {
		return this.grafica;
	}
		
	public void setGrafica(TarjetaGrafica grafica) {
		this.grafica = grafica;
	}
		
	public Bocinas getBocinas() {
		return this.musica;
	}
		
	public void setBocinas(Bocinas musica) {
		this.musica = musica;
	}
	
	@Override
	public String toString() {
		return "Computadora{" + "marca=" + marca + ", anio=" + anio + ", teclado=" + teclado
				+ ", pantalla=" + pantalla + ", raton=" + raton + ", grafica=" + grafica
				+ ", bocinas=" + musica + '}';
	}
}
