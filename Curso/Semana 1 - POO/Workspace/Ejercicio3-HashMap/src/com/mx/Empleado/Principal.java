package com.mx.Empleado;

public class Principal {

	public static void main(String[] args) {
		// Instancia
		Empleado e1 = new Empleado("Jesus", "Diaz", 30, 538272019, "Aux. Administrativo", "Finanzas", 6500.80);
		Empleado e2 = new Empleado("jorge", "contreas", 25, 238123478, "Programador", "TI", 7500.00); 
		Empleado e3 = new Empleado("Pepe", "Blanco", 25, 23811998, "CEO", "Redes", 8920.80); 
		Empleado e4 = new Empleado("Cesar", "Martinez", 24, 551978773, "Programador Jr.", "Desarrollo", 7999.99);
		Empleado e5 = new Empleado("Sergio", "Covarrubias", 38, 656324895, "Auxiliar.comtable","finanzas", 8500.90);
		
		Empleado emp = null;
		
		// Implementación
		Implementacion imp = new Implementacion();
		
		// Guardar
		imp.guardar(e1);
		imp.guardar(e2);
		imp.guardar(e3);
		imp.guardar(e4);
		imp.guardar(e5);
		
		// Mostrar
		imp.mostrar();
		
		// Buscar
		emp = new Empleado("jorge");
		imp.buscar(emp);
		System.out.println("Información completa: " + emp);
		
		// Editar
		emp = new Empleado("Pepe");
		emp = imp.buscar(emp);
		emp.setPuesto("Barrendero");
		emp.setSueldo(12000);
		imp.editar(emp);
		System.out.println("Empleado actualizado: " + emp);
		
		// Eliminar
		emp = new Empleado("Jesus");
		emp = imp.buscar(emp);
		imp.eliminar(emp);
		System.out.println("Lista actualizada");
		imp.mostrar();
		
		// Contar
		imp.contar();
		
		// Actividad: Realizar la replicación del ejercicio con un objeto diferente
	}

}
