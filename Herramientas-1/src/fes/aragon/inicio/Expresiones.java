package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Expresiones {
	public static void main(String[] args) throws Exception { // siempre se me olvida el psvm hdspm
		Pila<Double> operandos = new Pila<>();

		System.out.println("Ingresa algo aquí : ");

		try {
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String entrada = bufferRead.readLine();

			String[] operacion = entrada.split(" ");
			Double resultado;

			for (int i = 0; i < operacion.length; i++) {
				if (operacion[i].equals("+")) {
					resultado = operandos.extraer() + operandos.extraer();
					operandos.insertar(resultado);
				} else if (operacion[i].equals("-")) {
					resultado = operandos.extraer() - operandos.extraer();
					operandos.insertar(resultado);
				} else if (operacion[i].equals("*")) {
					resultado = operandos.extraer() * operandos.extraer();
					operandos.insertar(resultado);
				} else if (operacion[i].equals("/")) {
					resultado = operandos.extraer() / operandos.extraer();
					operandos.insertar(resultado);
				} else {
					operandos.insertar(Double.parseDouble(operacion[i]));
				}
			}

			System.out.println("El resultado es:" + operandos.elementoSuperior());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
