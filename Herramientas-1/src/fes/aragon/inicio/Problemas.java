package fes.aragon.inicio;

import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.utilerias.estaticas.Arreglos;

public class Problemas {
	public static void main(String[] args) throws IndiceFueraDeRango {
		Arreglos<Integer> numeros = new Arreglos<>(10);
		Integer aux,prom,mediana;

		numeros.intervalo(1, 10);
		System.out.print("El arreglo\n");
		numeros.imprime();
		aux = numeros.maximo();
		prom = numeros.promedio();
		System.out.print("\nEl mayor es= " + aux);
		System.out.print("\nEl promedio es= " + prom);
		numeros.ordenar();
		System.out.print("\nEl arreglo ordenado\n");
		numeros.imprime();
		mediana = numeros.mediana();
		System.out.println("\nEl valor central es= "+mediana);
	}
}
