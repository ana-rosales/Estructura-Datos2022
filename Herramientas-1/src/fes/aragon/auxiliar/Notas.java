package fes.aragon.auxiliar;

public class Notas {
	Integer numero,contador;
	
	public Notas(Integer numero, Integer contador) {
		this.numero = numero;
		this.contador = contador;
	}
	
	public Integer getNumero() {
		return this.numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public Integer getContador() {
		return this.contador;
	}
	
	public void setContador(Integer contador) {
		this.contador = contador;
	}
	
	@Override
	public String toString() {
		return "Nota{ no.=" + numero + ", contador=" + contador + '}';
	}
	
}