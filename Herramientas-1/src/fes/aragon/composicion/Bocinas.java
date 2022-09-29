package fes.aragon.composicion;

public class Bocinas {
	private String marca, conexion;
	
	public Bocinas() {
			
	}
		
	public Bocinas(String marca, String conexion) {
		this.marca = marca;
		this.conexion = conexion;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public String getConexion() {
		return this.conexion;
	}
		
	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
		
	@Override
	public String toString() {
		return "Bocinas{" + "marca=" + marca + ", conexion=" + conexion + '}';
	}
}
