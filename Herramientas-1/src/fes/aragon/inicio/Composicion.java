package fes.aragon.inicio;

import fes.aragon.composicion.Bocinas;
import fes.aragon.composicion.Computadora;
import fes.aragon.composicion.Monitor;
import fes.aragon.composicion.Mouse;
import fes.aragon.composicion.TarjetaGrafica;
import fes.aragon.composicion.Teclado;
import fes.aragon.excep.IndiceFueraDeRango;
import fes.aragon.utilerias.estaticas.Arreglos;

public class Composicion {
	public static void main(String[] args) throws IndiceFueraDeRango {
		Arreglos<Computadora> arrCompus = new Arreglos<>(5);
		arrCompus.insertar(new Computadora("DELL", 2020, 
				new Teclado("DELL", "nose"),
				new Monitor("DELL", 7.0),
				new Mouse("Razer", "óptico"),
				new TarjetaGrafica("AMD",8.0), 
				new Bocinas("Razer", "inalámbrico")));
		//arrCompus.imprime();
		System.out.println(arrCompus.recupera(0).toString());
		arrCompus.insertar(new Computadora("MacPro", 2036, 
				new Teclado("Apple", "sise"),
				new Monitor("Apple", 20.0),
				new Mouse("Apple", "láser"),
				new TarjetaGrafica("Apple",10.0), 
				new Bocinas("Apple", "no inhalámbrico")));
		arrCompus.insertar(new Computadora("Asus", 2022, 
				new Teclado("Asus", "talvez"), 
				new Monitor("Asus", 24.0),
				new Mouse ("Logitech", "laser"),
				new TarjetaGrafica("AMD RX 6800", 24.0), 
				new Bocinas ("Logitech", "Bluetoth")));
		arrCompus.insertar(new Computadora("HP", 2014, 
                new Teclado("Logitech", "KB201"),
                new Monitor("DELL", 14.0),
                new Mouse("Razer", "Laser"),
                new TarjetaGrafica("Nvidia",16.0), 
                new Bocinas("Sony", "Bluetooth")));
		arrCompus.insertar(new Computadora("Lenovo", 2023, 
                new Teclado("Nanwei", "K22"),
                new Monitor("Logitech", 16.0),
                new Mouse("Razer", "Laser"),
                new TarjetaGrafica("Nvidia",16.0), 
                new Bocinas("Samsung", "Bluetooth")));
		//arrCompus.imprime();
	}

}
