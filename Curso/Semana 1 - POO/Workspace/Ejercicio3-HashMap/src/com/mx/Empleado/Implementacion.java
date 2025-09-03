package com.mx.Empleado;

import java.util.HashMap;

public class Implementacion implements IMetodos{
	//Sintaxis del HashMap
	// HashMap<CLAVE, VALOR> hashEmpleados = new HashMap<CLAVE, VALOR>();
	// HashMAp es una librería de java.util
	// KeyDataType -> Clase contenedora del dato primitivo CLAVE
	// ValueDataType -> El nombre de la clase
	// new -> Palabra reservada para llamar al constructor
	
	HashMap<String, Empleado> hashEmpleados = new HashMap<String, Empleado>();

	@Override
	public void guardar(Empleado empleado) {
		hashEmpleados.put(empleado.getNombre(), empleado);
		
	}

	@Override
	public Empleado buscar(Empleado empleado) {
		
		return hashEmpleados.get(empleado.getNombre());
	}

	@Override
	public void editar(Empleado empleado) {
		hashEmpleados.replace(empleado.getNombre(), empleado);
		
	}

	@Override
	public void eliminar(Empleado empleado) {
		hashEmpleados.remove(empleado.getNombre());
		
	}

	@Override
	public void mostrar() {
		System.out.println(hashEmpleados);
		
	}
	
	// MÉTODO PERSONALIZADO
	public void contar() {
		System.out.println("El hash contiene " + hashEmpleados.size() + " empleados registrados");
	}

}
