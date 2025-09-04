package com.mx.Principal;
import com.mx.Entidades.*;

public class Principal {
	public static void main(String[] args) {
		// OBJETOS PELICULA
		Pelicula pelicula1 = new Pelicula("Spider Man", 110, "Superhéroes", "Sam Raimi");
		Pelicula pelicula2 = new Pelicula("The conjuring", "James Wan");
		
		System.out.println("============= PELÍCULA =============");
		System.out.println("Películas originales:\n" + pelicula1 + pelicula2);
		
		pelicula1.liberar();
		pelicula2.ocupar();
		pelicula2.setGenero("Terror");
		
		System.out.println("Películas modificadas:\n" + pelicula1 + pelicula2);
		
		System.out.println("La película " + pelicula1.getTitulo() + (pelicula1.isDisponible() ? "" : " no") + " se encuentra disponible");
		System.out.println("La película " + pelicula2.getTitulo() + (pelicula2.isDisponible() ? "" : " no") + " se encuentra disponible");
		
		// OBJETOS SERIE DOCUMENTAL
		SerieDocumental serie1 = new SerieDocumental("Planeta Tierra", "Naturaleza");
		SerieDocumental serie2 = new SerieDocumental("Cosmos", 13, "Ciencia", "Carl Sagan");
		
		System.out.println("\n============= SERIE DOCUMENTAL =============");
		System.out.println("Series originales:\n" + serie1 + serie2);
		
		serie1.ocupar();
		serie2.liberar();
		serie1.setProductor("Victor Von Doom's");
		
		System.out.println("Series modificadas:\n" + serie1 + serie2);
		
		System.out.println("La serie " + serie1.getTitulo() + (serie1.isDisponible() ? "" : " no") + " se encuentra disponible");
		System.out.println("La serie " + serie2.getTitulo() + (serie2.isDisponible() ? "" : " no") + " se encuentra disponible");
	}
}
