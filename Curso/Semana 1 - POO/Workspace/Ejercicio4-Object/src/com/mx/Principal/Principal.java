package com.mx.Principal;

import com.mx.Entidades.Computadora;
import com.mx.Implementacion.ImplementacionCompu;

public class Principal {
	public static void main(String[] args) {
		// Instanciar
		Computadora c1 = new Computadora(3541, "Dell", "IntelCore i7 12th", 16, "512GB", "Negro");
		Computadora c2 = new Computadora(5841, "HP", "AMD Ryzen 3", 8, "1TB", "Azul");
		Computadora c3 = new Computadora(7845, "Toshiba", "Intel Celeron", 4, "1TB", "Morado");
		
		// Objeto Auxiliar
		Computadora compu = null;
		
		// Implementación
		ImplementacionCompu impC = new ImplementacionCompu();
		
		// GUARDAR
		impC.guardar(c1.getSku(), c1);
		impC.guardar(c2.getSku(), c2);
		impC.guardar(c3.getSku(), c3);
		
		// MOSTRAR
		impC.mostrar();
		
		// BUSCAR
		// CASTEO: Cambio de datos
		compu = (Computadora) impC.buscar(c1.getSku());
		System.out.println(compu);
		
		// ELIMINAR
		impC.eliminar(c1.getSku());
		impC.mostrar();
		
		// CONTAR
		impC.contar();
		
		// Realizar el uso de la clase OBject con la LISTA GÉNERICA (NO se usará HashMap)
		// Realizar la replicación del ejercicio con 3 entidades diferentes, ocupando una Lista en lugar de HashMap
		// Para las pruebas, cada entidad debera tener por lo menos 3 instancias y deben llevar todas sus respectivas pruebas
		// [Agregar, Mostar, Editar, Eliminar, Contar]
		
	}
}
