package fes.aragon.composicion;

public class TarjetaGrafica {
	private String marca;
	private Double tamanoRAM;
	
	public TarjetaGrafica() {
			
	}
		
	public TarjetaGrafica(String marca, Double tamanoRAM) {
		this.marca = marca;
		this.tamanoRAM = tamanoRAM;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public Double getRAM() {
		return this.tamanoRAM;
	}
		
	public void setRAM(Double tamanoRAM) {
		this.tamanoRAM = tamanoRAM;
	}
		
	@Override
	public String toString() {
		return "Grafica{" + "marca=" + marca + ", tamanio RAM(GB)=" + tamanoRAM + '}';
	}

}
