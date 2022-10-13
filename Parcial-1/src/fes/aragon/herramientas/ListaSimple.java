package fes.aragon.herramientas;

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

	public void agregarEnCola(E dato) {
		if (cabeza == null) {
			cabeza = cola = new Nodo<E>(dato);
		} else {
			cola.setSiguiente(new Nodo<E>(dato));
			cola = cola.getSiguiente();
		}
		longitud++;
	}

	public boolean insertarEnIndice(E dato, int indice) {
		boolean seinserto = false;
		if (indice >= 0 && indice <= longitud - 1) {
			if (indice == 0) {
				this.agregarEnCabeza(dato);
				seinserto = true;
			} else {
				Nodo<E> prv, tmp = null;
				int contador = 0;
				for (prv = null, tmp = cabeza; contador < indice; contador++, prv = tmp, tmp = tmp.getSiguiente())
					;
				prv.setSiguiente(new Nodo<E>(dato, tmp));
				longitud++;
				seinserto = true;
			}
		}
		return seinserto;
	}
	
	public void imprimirElementos() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
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
	
	public int buscar(E dato) { /* Buscar en lista no es oficial */
		int indice;
		boolean encontrado = false;
		Nodo<E> tmp = null;
		tmp = cabeza;
		if (longitud == 0) {
			return -1;
		}
		for (indice = 0; tmp != null; indice++, tmp = tmp.getSiguiente()) {
			if (tmp.getDato().equals(dato)) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == true) {
			return indice;
		} else {
			return -1;
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
				for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente()) {
				}
//					;
				tmp.setSiguiente(null);
				cola = tmp;
				longitud--;
			}
		}
	}
	
	public boolean eliminarEnIndice(int indice) {
		boolean borrado = false;
		if (indice >= 0 && indice <= longitud - 1) {
			if (cabeza != null) {
				if (cabeza == cola && indice == 0) {
					cabeza = cola = null;
					borrado = true;
					longitud--;
				} else if (indice == 0) {
					cabeza = cabeza.getSiguiente();
					borrado = true;
					longitud--;
				} else {
					Nodo<E> prd, tmp;
					int contador = 1;
					for (prd = cabeza, tmp = cabeza.getSiguiente(); contador < indice; prd = prd
							.getSiguiente(), tmp = tmp.getSiguiente(), contador++)
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
		}
		return borrado;
	}
	

}
