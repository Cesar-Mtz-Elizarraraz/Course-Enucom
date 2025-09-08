package com.mx.Principal;
import com.mx.Entidades.*;

public class Principal {

	public static void main(String[] args) {
		
		Serie serie_aux = new Serie();
		Videojuego videojuego_aux = new Videojuego();
		
		// CREACIÓN DE ARRAYS
		Serie[] series = new Serie[5];
		Videojuego[] videojuegos = new Videojuego[5];
		
		// CREACIÓN DE OBJETOS POR CADA POSICIÓN
		series[0] = new Serie("The boys", 5, "Drama", "Eric Kripke");
		series[1] = new Serie("The Office", "Greg Daniels");
		series[2] = new Serie("Breaking Bad", "Vince Gilligan");
		series[3] = new Serie("Dark", 3, "Misterio", "Baran bo Odar");
		series[4] = new Serie("Los Simpson", 35, "Animación", "Matt Groening");

		videojuegos[0] = new Videojuego("Tetris", 5);
		videojuegos[1] = new Videojuego("FIFA 24", 80, "Deportes", "EA Sports");
		videojuegos[2] = new Videojuego("Flappy Bird", 2);
		videojuegos[3] = new Videojuego("Call of Duty: Modern Warfare", 60, "Shooter", "Activision");
		videojuegos[4] = new Videojuego("Minecraft", 100);
		
		System.out.println("Series actuales:");
		imprimirDatos(series);
		
		System.out.println("\nVideojuegos actuales:");
		imprimirDatos(videojuegos);
		
		// ENTREGA DE VIDEOJUEGOS Y SERIES
		series[2].entregar();
		series[4].entregar();
		videojuegos[1].entregar();
		videojuegos[3].entregar();
		videojuegos[0].entregar();

		System.out.println("\n--- ENTREGA DE VIDEOJUEGOS Y SERIES ---");
		System.out.println("Series actualizadas:");
		imprimirDatos(series);
		
		System.out.println("\nVideojuegos actualizados:");
		imprimirDatos(videojuegos);
		
		System.out.println("\n--- CONTAR VIDEOJUEGOS Y SERIES ENTREGADAS ---");
		System.out.println("Total de series entregadas: " + getSeriesEntregadas(series));
		System.out.println("Total de videojuegos entregados: " + getVideojuegosEntregados(videojuegos));
		
		System.out.println("\n--- COMPARACIONES ---");
		serie_aux.compareTo(series);
		videojuego_aux.compareTo(videojuegos);
	}

	private static void imprimirDatos(Object[] obj) {
		for(Object o : obj) {
			System.out.println(o);
		}
	}
	
	private static int getVideojuegosEntregados(Videojuego[] videojuegos) {
		int contador = 0;
		for(Videojuego v : videojuegos) {
			if(v.isEntregado()) contador++;
		}
		return contador;
	}
	
	private static int getSeriesEntregadas(Serie[] series) {
		int contador = 0;
		for(Serie s : series) {
			if(s.isEntregado()) contador++;
		}
		return contador;
	}
}
