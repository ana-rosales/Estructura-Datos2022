package fes.aragon.inicio;

import fes.aragon.auxiliar.ListaSimpleNotas;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class ListaSimpleContador {
	public static void main(String[] args) {
		ListaSimple<Integer> lista = new ListaSimple<>();
		ListaSimple<ListaSimpleNotas> lnotas = new ListaSimple<>();
		int max = 20, min = 1;

		for (int i = 0; i < 50; i++) {
			lista.agregarEnCabeza((int) (Math.random() * (max - min + 1) + min));
		}
		for (int i = 0; i < 50; i++) {
			Integer valor = lista.obtenerNodo(i);
			if (lnotas.esVacia()) {
				ListaSimpleNotas lsn = new ListaSimpleNotas(valor);
				lnotas.agregarEnCabeza(lsn);
			} else {
				boolean encontrada = false;
				for (int j = 0; j < lnotas.getLongitud(); j++) {
					if(valor == lnotas.obtenerNodo(j).getNumero()) {
						lnotas.obtenerNodo(j).contar();
						encontrada = true;
						break;
					}
				}
				if(!encontrada) {
					ListaSimpleNotas lsn = new ListaSimpleNotas(valor);
					lnotas.agregarEnCabeza(lsn);
				}
			}
		}
		lnotas.imprimirElementos();
	}
}
