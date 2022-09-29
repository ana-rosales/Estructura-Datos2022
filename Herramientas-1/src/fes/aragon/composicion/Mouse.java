package fes.aragon.composicion;

public class Mouse {
	private String marca, movimiento;
		
	public Mouse() {
			
	}
		
	public Mouse(String marca, String movimiento) {
		this.marca = marca;
		this.movimiento = movimiento;
	}
		
	public String getMarca() {
		return this.marca;
	}
		
	public void setMarca(String marca) {
		this.marca = marca;
	}
		
	public String getMovimiento() {
		return this.movimiento;
	}
		
	public void setMovimiento(String movimiento) {
		this.movimiento = movimiento;
	}
		
	@Override
	public String toString() {
		return "Mouse{" + "marca=" + marca + ", movimiento=" + movimiento + '}';
	}

}
