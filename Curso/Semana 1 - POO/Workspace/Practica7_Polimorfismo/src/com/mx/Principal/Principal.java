package com.mx.Principal;
import com.mx.Entidades.*;

public class Principal {
	public static void main(String[] args) {
		// ARRAY DE 4 ELEMENTOS
		Instrumento[] instrumentos = new Instrumento[4];
		
		instrumentos[0] = new Instrumento("Violonchelo M2", "Viento", 1800);
		instrumentos[1] = new Guitarra("Guitarra Fender", "Cuerdas", 650, 6, true);
		instrumentos[2] = new Piano("Piano Yamaha", "Teclado", 5200, 88, true);
		instrumentos[3] = new Tambor("Tambor Conga", "Percusión", 1599.99, "Grande", false);
		
		for(Instrumento i : instrumentos) {
			System.out.println(i.mostrarDatos());
			System.out.println(i + "\n");
		}
		
	}
}
