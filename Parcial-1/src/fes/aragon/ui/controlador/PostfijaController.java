package fes.aragon.ui.controlador;

import static javafx.scene.control.Alert.AlertType.WARNING;

import fes.aragon.herramientas.ListaSimple;
import fes.aragon.herramientas.Pila;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PostfijaController {

	@FXML
	private Button btnConvertir;

	@FXML
	private Button btnEvaluar;

	@FXML
	private TextField txtEvaluar;

	@FXML
	private TextField txtInfija;

	@FXML
	private TextField txtPostfija;

	static ListaSimple<String> operadores = new ListaSimple<>();
	Pila<String> pila = new Pila<>();
	Pila<Double> operandos = new Pila<>();
	String[] operacion;
	String salida = "";
	Integer indice = 0;
	Double resultado;
	Alert alerta;

	@FXML
	void convertir(ActionEvent event) throws Exception {
		txtPostfija.setText("");
		salida = "";
		indice = 0;
		operadores.agregarEnCola("(");// 1
		operadores.agregarEnCola("^");// 2
		operadores.agregarEnCola("/");// 3
		operadores.agregarEnCola("*");// 4
		operadores.agregarEnCola("+");// 5
		operadores.agregarEnCola("-");// 6

		String entrada = txtInfija.getText();
		if (entrada != "") {
			operacion = entrada.split(" ");// [12],[+],[12]

			while (indice < operacion.length) {
				String simbolo = operacion[indice];
				if (!operador(simbolo)) {
					salida += " " + simbolo;
					System.out.println(salida);
				} else if (simbolo.equals("(")) {
					pila.insertar(simbolo);
				} else if (simbolo.equals(")")) {
					String limite = pila.extraer();
					while (!limite.equals("(") && !pila.estaVacia()) {
						salida += " " + limite;
						limite = pila.extraer();
					}
				} else {
					while (!pila.estaVacia() && precedencia(pila.elementoSuperior(), simbolo)) {
						if (!pila.elementoSuperior().equals("(") && !pila.elementoSuperior().equals(")")) {
							String simboloArriba = pila.extraer();
							salida += " " + simboloArriba;
						} else
							break;
					}
					pila.insertar(simbolo);
				}
				indice++;
			}

			while (!pila.estaVacia()) {
				String simbolo = pila.extraer();
				salida += " " + simbolo;
			}
			txtPostfija.setText(salida);
		} else {
			estaVacia();
		}
	}

	@FXML
	void evaluar(ActionEvent event) throws Exception {
		txtEvaluar.setText("");
		operandos.borrar();
		if (salida != "") {
			operacion = salida.split(" ");// [12],[12],[+],[212],[*]
			for (int i = 0; i < operacion.length; i++) {
				if (operacion[i].equals("+")) {
					resultado = operandos.extraer() + operandos.extraer();
					operandos.insertar(resultado);
				} else if (operacion[i].equals("-")) {
					Double sustraendo = operandos.extraer();
					resultado = operandos.extraer() - sustraendo;
					operandos.insertar(resultado);
				} else if (operacion[i].equals("*")) {
					resultado = operandos.extraer() * operandos.extraer();
					operandos.insertar(resultado);
				} else if (operacion[i].equals("/")) {
					Double divisor = operandos.extraer();
					resultado = operandos.extraer() / divisor;
					operandos.insertar(resultado);
				} else if (operacion[i].equals("^")) {
					Double exp = operandos.extraer();
					resultado = Math.pow(operandos.extraer(), exp);
					operandos.insertar(resultado);
				} else if (!operacion[i].equals("")) {
					operandos.insertar(Double.parseDouble(operacion[i]));
				}
			}
			txtEvaluar.setText(operandos.elementoSuperior() + "");
		} else {
			estaVacia();
		}
	}

	@FXML
	void limpiar(ActionEvent event) {
		txtEvaluar.setText("");
		txtInfija.setText("");
		txtPostfija.setText("");
		salida = "";
		indice = 0;
		operandos.borrar();
	}

	private static boolean precedencia(String elementoSuperior, String simbolo) {
		if (operadores.buscar(elementoSuperior) <= operadores.buscar(simbolo)) {
			return true;
		}
		return false;
	}

	public static boolean operador(String s) {
		if (s.equals("(") || s.equals(")") || s.equals("^") || s.equals("*") || s.equals("/") || s.equals("+")
				|| s.equals("-")) {
			return true;
		}
		return false;
	}

	private void estaVacia() {
		alerta = new Alert(WARNING);
		alerta.setTitle("ADVERTENCIA");
		alerta.setHeaderText("Campo vacio, no se puede proceder.");
		alerta.setContentText("Algún campo debe estar vacío. Por favor, llénelo.");
		alerta.showAndWait();
	}
}
