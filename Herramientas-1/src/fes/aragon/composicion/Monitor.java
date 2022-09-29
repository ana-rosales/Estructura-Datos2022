package fes.aragon.composicion;

public class Monitor {
	private String marca;
	private Double pulgadas;
		
	public Monitor() {
			
	}
		
	public Monitor(String marca, Double pulgadas) {
		this.marca = marca;
		this.pulgadas = pulgadas;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public Double getPulgadas() {
		return this.pulgadas;
	}
		
	public void setPulgadas(Double pulgadas) {
		this.pulgadas = pulgadas;
	}
		
	@Override
	public String toString() {
		return "Monitor{" + "marca=" + marca + ", pulgadas=" + pulgadas + '}';
	}

}
