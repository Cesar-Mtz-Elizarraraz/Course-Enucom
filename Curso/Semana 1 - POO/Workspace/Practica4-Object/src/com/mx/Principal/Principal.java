package com.mx.Principal;

import com.mx.Entidades.*;
import com.mx.Implementaciones.*;

public class Principal {
	public static void main(String[] args) {
		// IMPLEMENTACIONES
		ImplementacionAnimal impAnimal = new ImplementacionAnimal();
		ImplementacionLibro impLibro = new ImplementacionLibro();
		ImplementacionTeclado impTeclado = new ImplementacionTeclado();
		
		// ============================== ANIMAL ==============================
		System.out.println("============================== ANIMAL ==============================");
		
		// INSTANCIAS
		Animal animal1 = new Animal("Firulais", "Macho", "Perro", 12.5, 0.45);
		Animal animal2 = new Animal("Misu", "Hembra", "Gato", 4.2, 0.25);
		Animal animal3 = new Animal("Dumbo", "Macho", "Elefante", 5400.0, 3.2);
	
		// AUXILIAR
		Animal animal_aux = null;
		
		// GUARDAR
		impAnimal.guardar(animal1);
		impAnimal.guardar(animal2);
		impAnimal.guardar(animal3);
		
		// MOSTRAR
		System.out.println("--- MOSTRAR ---");
		impAnimal.mostrar();
		
		// EDITAR
		System.out.println("\n--- EDITAR ---");
		animal_aux = (Animal) impAnimal.buscar(0);
		System.out.println("Animal seleccionado:\n" + animal_aux);
		animal_aux.setEspecie("Gato");
		animal_aux.setAltura(0.90);
		impAnimal.editar(0, animal_aux);
		System.out.println("Animal editado:\n" + animal_aux);
		
		// ELIMINAR
		System.out.println("--- ELIMINAR ---");
		impAnimal.eliminar(1);
		System.out.println("Lista actualizada:");
		impAnimal.mostrar();
		
		// CONTAR
		System.out.println("\n--- CONTAR ---");
		impAnimal.contar();
		
		
		// ============================== LIBRO ==============================
		System.out.println("\n============================== LIBRO ==============================");
		
		// INSTANCIAS
		Libro libro1 = new Libro(1001, "El principito", "Antoine de Saint-Exupéry", 2500, "Fantasía", 1000);
		Libro libro2 = new Libro(1002, "Cien años de soledad", "Gabriel García Márquez", 3200, "Realismo mágico", 500);
		Libro libro3 = new Libro(1003, "1984", "George Orwell", 2800, "Distopía", 750);
		
		// AUXILIAR
		Libro libro_aux = null;
		
		// GUARDAR
		impLibro.guardar(libro1);
		impLibro.guardar(libro2);
		impLibro.guardar(libro3);

		// MOSTRAR
		System.out.println("--- MOSTRAR ---");
		impLibro.mostrar();

		// EDITAR
		System.out.println("\n--- EDITAR ---");
		libro_aux = (Libro) impLibro.buscar(1);
		System.out.println("Libro seleccionado:\n" + libro_aux);
		libro_aux.setAutor("Nuevo Autor");
		libro_aux.setNumeroCopias(2000);
		impLibro.editar(1, libro_aux);
		System.out.println("Libro editado:\n" + libro_aux);

		// ELIMINAR
		System.out.println("--- ELIMINAR ---");
		impLibro.eliminar(2);
		impLibro.eliminar(1);
		System.out.println("Lista actualizada:");
		impLibro.mostrar();

		// CONTAR
		System.out.println("\n--- CONTAR ---");
		impLibro.contar();
		
		
		// ============================== TECLADO ==============================
		System.out.println("\n============================== TECLADO ==============================");
		
		// INSTANCIAS
		Teclado teclado1 = new Teclado(1001, "Logitech", "K380", 45.99, "Inalámbrico", "Negro");
		Teclado teclado2 = new Teclado(1002, "Razer", "BlackWidow V3", 129.99, "Mecánico", "Verde");
		Teclado teclado3 = new Teclado(1003, "Corsair", "K95 RGB Platinum", 199.99, "Mecánico", "Gris");
		
		// AUXILIAR
		Teclado teclado_aux = null;
		
		// GUARDAR
		impTeclado.guardar(teclado1);
		impTeclado.guardar(teclado2);
		impTeclado.guardar(teclado3);

		// MOSTRAR
		System.out.println("--- MOSTRAR ---");
		impTeclado.mostrar();

		// EDITAR
		System.out.println("\n--- EDITAR ---");
		teclado_aux = (Teclado) impTeclado.buscar(2);
		System.out.println("Teclado seleccionado:\n" + teclado_aux);
		teclado_aux.setTipo("Inalámbrico");
		teclado_aux.setPrecio(250);
		teclado_aux.setMarca("Gigabyte");
		impTeclado.editar(2, teclado_aux);
		System.out.println("Teclado editado:\n" + teclado_aux);

		// ELIMINAR
		System.out.println("--- ELIMINAR ---");
		impTeclado.eliminar(0);
		System.out.println("Lista actualizada:");
		impTeclado.mostrar();

		// CONTAR
		System.out.println("\n--- CONTAR ---");
		impTeclado.contar();
		
		// COMMIT
	}
}
