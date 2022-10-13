package fes.aragon.modelo;

public class Parentesis {
	private int abre,cierra;

	public Parentesis() {
		// TODO Auto-generated constructor stub
	}
	
	public Parentesis(int abre, int cierra) {
		this.abre = abre;
		this.cierra = cierra;
	}

	public int getAbre() {
		return abre;
	}

	public void setAbre(int abre) {
		this.abre = abre;
	}

	public int getCierra() {
		return cierra;
	}

	public void setCierra(int cierra) {
		this.cierra = cierra;
	}

	@Override
	public String toString() {
		return "Parentesis [abre=" + abre + ", cierra=" + cierra + "]";
	}
	
}
