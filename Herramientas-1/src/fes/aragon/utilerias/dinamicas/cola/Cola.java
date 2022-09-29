package fes.aragon.utilerias.dinamicas.cola;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Cola<E> {
	private ListaSimple<E> cola = new ListaSimple<>();
	
	public void borrar() {
		cola = new ListaSimple<>();
	}
	
	public boolean estaVacia() {
		return cola.esVacia();
	}
	
	public void insertar(E dato) {
		cola.agregarEnCola(dato);
	}
	
	public E extraer() throws Exception {
		E tmp = null;
		if(!estaVacia()) {
			tmp = cola.obtenerCabeza();
			cola.eliminarEnCabeza();
		} else {
			throw new Exception("cola vacía");
		}
		return tmp;
	}
	
	
}
