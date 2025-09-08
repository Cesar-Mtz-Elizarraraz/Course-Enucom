package com.mx.Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

import com.mx.Entidades.Alumno;

public class Principal {
	public static void main(String[] args) {
		// INSTANCIAR
		Alumno al1 = new Alumno(7891, "Marian", "Goméz", "Ruiz", 22, "Lic. Medicina", "BUAP");
		Alumno al2 = new Alumno(4523, "Belen", "paz", "diaz", 21, "Lic. Psicologia", "BuAp");
		Alumno al3 = new Alumno(89562, "Armando", "Cuevas", "Guzman", 25, "Lic. en Ofimatica", "UTT");
		Alumno al4 = new Alumno(4937, "Juan", "Pérez", "López", 20, "Ing. Computacional", "UNAM");
		Alumno al5 = new Alumno(78524,"Sergio","Cova","Camargo", 33,"Bioquimica", "Poli");
		Alumno al6 = new Alumno(8923, "Mariel", "zarate", "Sanchez", 21, "Administracion", "IEU");
		
		List<Alumno> alumnos = new ArrayList<Alumno>();
		
		alumnos.add(al1);
		alumnos.add(al2);
		alumnos.add(al3);
		alumnos.add(al4);
		alumnos.add(al5);
		alumnos.add(al6);
		
		/*
		 * SINTAXIS LAMBDA
		 * (arg1) -> (cuerpo)
		 * 			(tipo1, tipo1, arg1) -> (cuerpo)
		 */
		
		/*
		// forEAch: Método que recorre cada elemento de la lista
		// Por cada alumno que encuentre se imprimirá el mensaje que declare en la función lambda
		alumnos.forEach(alumno -> System.out.println("Nombre del alumno: " + alumno.getNombre()));
		
		// MÉTODO IMPRIMIR
		System.out.println();
		alumnos.stream() // STREAM: Convierte la lista en un flujo de datos para procesamiento funcional
			   	.filter(alumno -> "buap".equalsIgnoreCase(alumno.getUniversidad()))
			   	.forEach(alumno -> System.out.println("Nombre: " + alumno.getNombre() + " " + alumno.getaPaterno() + 
			   			" estudia la carrera de " + alumno.getCarrera() + " de la universidad " + alumno.getUniversidad()));
		
		// EXPRESIONES LAMBDA CON INTERFACES FUNCIONALES
		ISaludo mensaje = (saludos, despedida) -> saludos + " y " + despedida;
		
		System.out.println("\nExpresiones lamba con 2 parametros:\n" + mensaje.saludar("Hola con expresiones lambda", "Hasta luego con expresiones lambda"));
		*/

		// Filtar los alumnos que tengan una edad mayor a 22 años
		System.out.println("------- EJERICIO 1 --------");
		alumnos.stream()
	   		.filter(alumno -> alumno.getEdad() > 22)
	   		.forEach(alumno -> System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getaPaterno() + " tiene la edad de " + alumno.getEdad()));
		
		// Filtar los alumnos cuyo nombre comienza con la letra "A"
		System.out.println("\n------- EJERICIO 2 --------");
		alumnos.stream()
   			.filter(alumno -> alumno.getNombre().startsWith("A"))
   			.forEach(alumno -> System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getaPaterno()));
		
		// Ordenar los alumnos por su nombre
		System.out.println("\n------- EJERICIO 3 --------");
		alumnos.stream()
	    	.sorted(Comparator.comparing(alumno -> alumno.getNombre()))
	    	.forEach(alumno -> System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getaPaterno()));
		
		// Contar los alumnos de la carrera de Medicina
		System.out.println("\n------- EJERICIO 4 --------");
		long alumnosMedicina = alumnos.stream()
								.filter(alumno -> alumno.getCarrera().contains("Medicina"))
								.count();
		System.out.println("Cantidad de alumnos de medicina: " + alumnosMedicina);
		
		// mapear los nombres de los alumnos a mayusculas
		System.out.println("\n------- EJERICIO 5 --------");
		alumnos.stream()
			.map(alumno -> alumno.getNombre().toUpperCase())
			.forEach(alumnoMayuscula -> System.out.println("Alumno: " + alumnoMayuscula));
		
		// calcular el promedio de las edades de todos los alumnos
		System.out.println("\n------- EJERICIO 6 --------");
		double promedioEdades = alumnos.stream().mapToInt(alumno -> alumno.getEdad()).average().getAsDouble();
		System.out.println("El promedio de la edades es: " + promedioEdades);
		
		// verificar si axite un alumno en la carrera de Ing. Sofware
		System.out.println("\n------- EJERICIO 7 --------");
		boolean alumnosSoftware = alumnos.stream().anyMatch(alumno -> "Ing. Software".equalsIgnoreCase(alumno.getCarrera()));
		System.out.println(alumnosSoftware ? "Si hay alumnos de software" : "No hay alumnos de software");
		
		// filtar alumnos por univeridad "buap" y la cerrara de "lic.Psicologia.
		System.out.println("\n------- EJERICIO 8 --------");
		alumnos.stream()
			.filter(alumno -> "buap".equalsIgnoreCase(alumno.getUniversidad()) && "lic. Psicologia".equalsIgnoreCase(alumno.getCarrera()))
			.forEach(alumno -> System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getaPaterno() + 
		   			" estudia la carrera de " + alumno.getCarrera() + " de la universidad " + alumno.getUniversidad()));
		
		
	}
}
