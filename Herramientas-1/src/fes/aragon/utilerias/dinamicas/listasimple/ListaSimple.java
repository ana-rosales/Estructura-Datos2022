package fes.aragon.utilerias.dinamicas.listasimple;

public class ListaSimple<E> {
	protected Nodo<E> cabeza, cola;
	protected int longitud = 0;

	public ListaSimple() {
		// TODO Auto-generated constructor stub
		cabeza = cola = null;
	}

	public void agregarEnCabeza(E dato) {
		cabeza = new Nodo<E>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	public void agregarEnCola(E dato) {// TODO
		Nodo<E> tmp = new Nodo<E>(dato, null);
		if (cola == null && cabeza == null) {
			cola = tmp;
			cabeza = cola;
		} else {
			cola.setSiguiente(tmp);
			cola = tmp;
		}
		longitud++;
	}

	public void imprimirElementos() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.getDato());
		}
	}

	public E obtenerCabeza() {
		return cabeza.getDato();
	}
	
	public E obtenerCola() {
		return cola.getDato();
	}

	public int estaEnLista(E dato) {
		int indice;
		Nodo<E> tmp = null;
		tmp = cabeza;
		for (indice = 0; indice < longitud - 1 && tmp != null
				&& tmp.getDato().equals(dato); indice++, tmp = tmp.getSiguiente())
			;

		if (tmp != null) {
			return indice; // devuelve el índice del dato
		} else {
			return -1; // no se encontró
		}
	}

	public E obtenerNodo(int indice) {
		Nodo<E> tmp = null;
		if (indice <= longitud) {
			tmp = cabeza;
			for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
				;
		}
		if (tmp != null) {
			return tmp.getDato(); // devuelve el dato del índice
		} else {
			return null; // no hay nada
		}
	}

	public boolean eliminar(E dato) {
		boolean borrado = false;
		if (cabeza != null) {
			if (cabeza == cola && dato.equals(cabeza.getDato())) {
				cabeza = cola = null;
				borrado = true;
				longitud--;
			} else if (dato == cabeza.getDato()) {
				cabeza = cabeza.getSiguiente();
				borrado = true;
				longitud--;
			} else {
				Nodo<E> prd, tmp;
				for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null
						&& !tmp.getDato().equals(dato); prd = prd.getSiguiente(), tmp = tmp.getSiguiente())
					;
				if (tmp != null) {
					borrado = true;
					longitud--;
					prd.setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = prd;
					}
				}
			}
		}
		return borrado;
	}

	public int getLongitud() {
		if (longitud < 0) {
			longitud = 0;
		}
		return longitud;
	}

	public boolean esVacia() {
		return cabeza == null; // true or false
	}

	public void eliminarEnCabeza() {
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				cabeza = cabeza.getSiguiente();
				longitud--;
			}
		}
	}

	public void eliminarEnCola() {
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				Nodo<E> tmp;
				for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente())
					;
				tmp.setSiguiente(null);
				cola = tmp;
				longitud--;
			}
		}
	}

}
