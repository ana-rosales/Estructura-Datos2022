package fes.aragon.ui.controlador;

import fes.aragon.modelo.Parentesis;

import static javafx.scene.control.Alert.AlertType.WARNING;

import fes.aragon.herramientas.Pila;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EncriptadoController {

	@FXML
	private Button btnDesencriptar;

	@FXML
	private Button btnEncriptar;

	@FXML
	private Button btnLimpiar;

	@FXML
	private TextField txtMensaje;

	static StringBuilder temp, texto;
	static int volteo = 0, indicador = 0, indiceAbre = 0, noAvanza = 0;
	static Pila<Parentesis> parejas = new Pila<>();
	static Pila<Character> frase = new Pila<>();
	Alert alerta;
	char c;

	@FXML
	void desencriptar(ActionEvent event) throws Exception {
		String entrada = txtMensaje.getText();
		if (entrada != "") {
			btnEncriptar.setDisable(false);
			btnDesencriptar.setDisable(true);
			while (!parejas.estaVacia()) {
				Parentesis current = parejas.extraer();
				agregaParentesis(current.getCierra(), "cierra");
				agregaParentesis(current.getAbre(), "abre");
			}
			voltear();
			txtMensaje.setText(texto.toString());
			temp = new StringBuilder();
			texto = new StringBuilder();
			volteo = 0;
			indicador = 0;
			indiceAbre = 0;
			noAvanza = 0;
			parejas = new Pila<>();
			frase = new Pila<>();
			char c = ' ';
		} else {
			estaVacia();
		}
	}

	@FXML
	void encriptar(ActionEvent event) throws Exception {
		String entrada = txtMensaje.getText();
		if (entrada != "") {
			btnEncriptar.setDisable(true);
			btnDesencriptar.setDisable(false);
			texto = new StringBuilder(entrada);
			voltear();
			txtMensaje.setText(texto.toString());
		} else {
			estaVacia();
		}
	}

	@FXML
	void limpiar(ActionEvent event) {
		btnEncriptar.setDisable(false);
		btnDesencriptar.setDisable(true);
		temp = new StringBuilder();
		texto = new StringBuilder();
		volteo = 0;
		indicador = 0;
		indiceAbre = 0;
		noAvanza = 0;
		parejas = new Pila<>();
		frase = new Pila<>();
		char c = ' ';
		txtMensaje.setText("");
	}

	private static void agregaParentesis(int parentesis, String tipo) {
		char simbolo = (tipo == "abre") ? '(' : (tipo == "cierra") ? ')' : ' ';
		temp = texto;
		texto = new StringBuilder();
		texto.append(temp.substring(0, parentesis) + simbolo + temp.substring(parentesis));
	}

	private void voltear() throws Exception {
		int indice = 0;
		while (indice < texto.length()) {
			if (volteo == 1) {
				if (!frase.estaVacia()) {
					char reemplazo = frase.extraer();
					texto.setCharAt(indice, reemplazo);
					if (reemplazo == ')' && indicador == 1) {
						indice = indiceAbre;
						volteo--;
					}
				} else {
					volteo--;
				}
			}
			/**
			 * ABRE
			 */
			if (texto.charAt(indice) == '(' && indicador == 0) {
				texto.deleteCharAt(indice);
				indiceAbre = indice;
				if (texto.charAt(indice) == '(' && volteo == 0) {
					indicador++;
				}
				if (volteo == 1) {
					noAvanza++;
				}
				indicador++;
			} else if (texto.charAt(indice) == '(') {
				indicador++;
			}
			/*
			 * CIERRA
			 */
			if (texto.charAt(indice) == ')' && indicador == 1) {
				texto.deleteCharAt(indice);
				Parentesis current = new Parentesis(indiceAbre, indice);
				parejas.insertar(current);
				indice = indiceAbre - 1;
				volteo++;
				indicador--;
			} else if (texto.charAt(indice) == ')') {
				indicador--;
			}
			if (indicador > 0 && volteo == 0) {
				char caracter = (texto.charAt(indice) == '(') ? ')'
						: (texto.charAt(indice) == ')') ? '(' : texto.charAt(indice);
				frase.insertar(caracter);
			}
			if (noAvanza == 0)
				indice++;
			else
				noAvanza--;
		}
	}

	private void estaVacia() {
		alerta = new Alert(WARNING);
		alerta.setTitle("ADVERTENCIA");
		alerta.setHeaderText("Campo vacio, no se puede proceder.");
		alerta.setContentText("Algún campo debe estar vacío. Por favor, llénelo.");
		alerta.showAndWait();
	}
	
	private void noEncripta() {
		alerta = new Alert(WARNING);
		alerta.setTitle("ADVERTENCIA");
		alerta.setHeaderText("Campo inválido, no se puede proceder.");
		alerta.setContentText("El mensaje ingresado no se puede encriptar. Por favor, ingrese uno nuevo.");
		alerta.showAndWait();
	}
}
