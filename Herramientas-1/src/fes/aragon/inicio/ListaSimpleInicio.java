package fes.aragon.inicio;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class ListaSimpleInicio {
	public static void main(String[] args) {
		ListaSimple<Integer> numeros = new ListaSimple<>();
		numeros.agregarEnCabeza(89);
		numeros.agregarEnCabeza(852);
		numeros.agregarEnCabeza(456);
		numeros.agregarEnCabeza(54);
		numeros.agregarEnCabeza(5);
		numeros.agregarEnCabeza(26);
		numeros.agregarEnCabeza(98);
		numeros.agregarEnCabeza(100);
		numeros.agregarEnCabeza(37);
		numeros.agregarEnCabeza(41);
		numeros.agregarEnCabeza(18);
		numeros.agregarEnCabeza(75);
		numeros.agregarEnCabeza(1896);
		numeros.agregarEnCabeza(786);
		numeros.agregarEnCabeza(489);
		numeros.agregarEnCabeza(4);
		numeros.agregarEnCabeza(66);
		numeros.agregarEnCabeza(789);
		numeros.agregarEnCabeza(1);
		numeros.agregarEnCabeza(82);
		numeros.imprimirElementos();
	}
}
