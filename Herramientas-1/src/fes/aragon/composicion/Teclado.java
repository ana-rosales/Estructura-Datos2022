package fes.aragon.composicion;

public class Teclado {
	private String marca, modelo;
	
	public Teclado() {
		
	}
	
	public Teclado(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getModelo() {
		return this.modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public String toString() {
		return "Teclado{" + "marca=" + marca + ", modelo=" + modelo + '}';
	}
	
}
