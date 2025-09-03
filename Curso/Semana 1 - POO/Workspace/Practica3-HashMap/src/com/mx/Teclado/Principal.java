package com.mx.Teclado;

public class Principal {
	public static void main(String[] args) {
		// INSTANCIAR
		Teclado teclado1 = new Teclado(1001, "Logitech", "K380", 45.99, "Inalámbrico", "Negro");
		Teclado teclado2 = new Teclado(1002, "Razer", "BlackWidow V3", 129.99, "Mecánico", "Verde");
		Teclado teclado3 = new Teclado(1003, "Corsair", "K95 RGB Platinum", 199.99, "Mecánico", "Gris");
		Teclado teclado4 = new Teclado(1004, "Microsoft", "Surface Keyboard", 89.50, "Inalámbrico", "Plata");
		Teclado teclado5 = new Teclado(1005, "HP", "K1500", 17.99, "Con cable", "Negro");
		
		Teclado teclado = null;
		Implementacion imp = new Implementacion();
		
		// AÑADIR
		imp.guardar(teclado1);
		imp.guardar(teclado2);
		imp.guardar(teclado3);
		imp.guardar(teclado4);
		imp.guardar(teclado5);

		// MOSTRAR
		System.out.println("--- MOSTRAR ---");
		imp.mostrar();
		
		// BUSCAR
		System.out.println("\n--- BUSCAR ---");
		teclado = new Teclado(1001);
		teclado = imp.buscar(teclado);
		System.out.println("Teclado encontrado:\n" + teclado);
		
		// EDITAR
		System.out.println("--- EDITAR ---");
		teclado = new Teclado(1004);
		teclado = imp.buscar(teclado);
		System.out.println("Teclado seleccionado:\n" + teclado);
		teclado.setColor("Gris oscuro");
		teclado.setMarca("Gigabyte");
		imp.editar(teclado);
		System.out.println("Teclado actualizado:\n" + teclado);
		
		// ELIMINAR
		System.out.println("--- ELIMINAR ---");
		teclado = new Teclado(1005);
		imp.eliminar(teclado);
		System.out.println("Hash actualizado:");
		imp.mostrar();
		
		// CONTAR
		System.out.println("\n--- CONTAR ---");
		imp.contar();
		
	}
}
