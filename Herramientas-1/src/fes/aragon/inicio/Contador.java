package fes.aragon.inicio;

import fes.aragon.auxiliar.Notas;
import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.utilerias.estaticas.Arreglos;

public class Contador {
	public static void main(String[] args) throws IndiceFueraDeRango {
		Arreglos<Integer> numeros = new Arreglos<>(1000);
		Arreglos<Notas> notas = new Arreglos<>(100);
		Integer i, j, numNota, guardado;

		numeros.intervalo(1, 100);
		
		/*
		 * Si aún no se guarda la nota en el arreglo, se guarda en un espacio nulo.
		 * Si ya se había guardado, únicamente se aumenta el contador.
		 */
		try {
			for (i = 0; i < numeros.longitud(); i++) {
				guardado = 0;
				for (j = 0; guardado == 0 ; j++) {
					if (notas.recupera(j) == null) {
						notas.insertar(new Notas(numeros.recupera(i), 1));
						guardado++;
					} else if (notas.recupera(j).getNumero() == numeros.recupera(i)) {
						numNota = notas.recupera(j).getContador();
						notas.recupera(j).setContador(numNota+1);
						guardado++;
					}
				}
			}
		} catch (Exception e) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
		numeros.imprime();
		notas.imprime();
	}
}

