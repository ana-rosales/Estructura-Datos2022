package fes.aragon.auxiliar;

public class ListaSimpleNotas {
	private Integer numero;
	private Integer contador = 1;
	
	public ListaSimpleNotas(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return "ListaSimpleNotas [numero=" + numero + ", contador=" + contador + "]";
	}
	
	public void contar() {
		this.contador++;
	}
	
}
