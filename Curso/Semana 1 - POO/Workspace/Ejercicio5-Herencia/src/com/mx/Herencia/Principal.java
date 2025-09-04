package com.mx.Herencia;

public class Principal {
	public static void main(String[] args) {
		// Instanciar el objeto Hijo
		Hijo hijo1 = new Hijo("Martin", "Morales", 12, "Moreno", 1.20, "Mexicana", "Delgado", "Negro", "Negro");
		System.out.println(hijo1);
		
		hijo1.setEdad(21);
		hijo1.setAltura(1.92);
		hijo1.setNombre("Julian");
		System.out.println("Hijo actualizado:\n" + hijo1);
		hijo1.trabajar();
		
		// Replicar ejercicio con 2 entidades diferentes
	}
}
