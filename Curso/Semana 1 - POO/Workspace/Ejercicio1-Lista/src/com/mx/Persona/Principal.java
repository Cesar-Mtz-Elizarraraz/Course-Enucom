package com.mx.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Respetar el CamelCase, es la forma de escribir en java, donde, las mayúsculas hacen la separación de las palabras 
// Ej. Apellido Paterno = apellidoPaterno
// Las clases no pueden ser creadas en plural y deben de iniciar con mayúscula

public class Principal {
	// Método que hace que se compile el programa
	public static void main(String[] args) {
		// Instanciar los objetos(Crear el objeto con los métodos declarados en mi clase Persona)
		// Se manda a llamar a la clase, para darle el valor de esa clase a una variable
		Persona gente1 = new Persona ("Raul", "jimenez", 23, "Mexicana"); 
		Persona gente2 = new Persona ("Jorge", "Hernandez", 25, "Mexicana"); 
		Persona gente3 = new Persona ("Carlos", "Jaramillo", 24, "Mexicana"); 
		Persona gente4 = new Persona ("Eduardo", "Blanco", 23, "Mexicana"); 
		Persona gente5 = new Persona ("sergio", "covarrubias", 33, "mexicano"); 
		Persona persona1 = new Persona ("Takio", "Sanchez", 31, "Mexicana");
		
		// Crear una lista para almacenar los objetos
		// Lista: Es una estructura de datos que permite almacenar objetos de manera ordenada y dinámica
		// List<Persona> lista = new ArrayList<Persona>();
		// List: Es la interfaz que viene de java.util <...> se le conoce como operación diamante
		// Nombre de la lista: Es asignada por el programador
		// = y new palabra reservada que manda a traer al contructor, y ArrayList, es el arreglo que voy a utilizar
		
		List<Persona> lista = new ArrayList<Persona>();
		
		// Agregar los objetos a la lista 
		lista.add(gente1); 
		lista.add(gente2);
		lista.add(gente3); 
		lista.add(gente4); 
		lista.add(gente5); 
		lista.add(persona1);
		
		/*
		 * 
		 * // Mostrar lo que tiene la lista System.out.println(lista);
		 * 
		 * // Crear un auxiliar
		 * 
		 * Persona persona_aux = null;
		 * 
		 * 
		 * // Buscar elemento en la lista
		 * 
		 * persona_aux = lista.get(0); System.out.println(persona_aux);
		 * 
		 * // Editar elemento en la lista
		 * 
		 * persona_aux = lista.get(2); persona_aux.setNombre("Mariana");
		 * persona_aux.setEdad(45); System.out.println(persona_aux);
		 * 
		 * // Eliminar un elemento lista.remove(5);
		 * System.out.println("Lista actualizada: " + lista);
		 * 
		 * // Contar elementos en la lista System.out.println("Existen: " + lista.size()
		 * + " personas registradas");
		 * 
		 * // Limpiar la lista lista.clear();
		 * 
		 * // Validar si la lista esta vacía if(lista.isEmpty())
		 * System.out.println("La lista esta vacía"); else
		 * System.out.println("Esta es la lista:\n" + lista);
		 */
		
		// Replicar el ejercicio, desde su creación, Crear un nuevo proyecto, el paquete y las clases
		
		// Crear un auxiliar
		Persona persona_aux = null;
		
		// Crear un menú interactivo  
		
		Scanner scan = null;
		String nombreBusqueda;
		int menuPrincipal = 0, menuSecundario = 0, menuAtributo = 0, indice = 0;
		boolean nombreValido;
		
		// Los menús son variables que van a almacenar opciones
		// El índice va a simular el índice de un objeto
		
		// Variables locales
		String nombre, apellido, nacionalidad;
		int edad;
		
		
		// Inicio del menú interactivo
		/*
		 * Uso del ciclo do-while: En java es una estructura que permite ejecutar el bloque de código al menos una vez
		 * y este continua su ejecución mientras se cumpla la condición
		 * */
		
		do {
			System.out.println("\n--- M E N Ú ----");
			System.out.println("1.- AGREGAR UN NUEVO REGISTRO");
			System.out.println("2.- MOSTRAR LA LISTA");
			System.out.println("3.- EDITAR");
			System.out.println("4.- BUSCAR UN ELEMENTO EN LA LISTA");
			System.out.println("5.- ELIMINAR UN ELEMENTO");
			System.out.println("6.- CONTAR TODOS LOS ELEMENTOS");
			System.out.println("7.- SALIR DEL MENÚ");
			System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
			
			scan = new Scanner(System.in);
			menuPrincipal = scan.nextInt();
			
			// Método de switch o método case: Es una estructura de control que permite ejecutar diferentes bloques de código
			// basados en el valor de la expresión, tambien es conocido como método case, porque dentro de un switch se 
			// utilizan diferentes case para manejar los diferentes casos de una posible expresión
			
			switch(menuPrincipal) {
				case 1:
					System.out.println("--- 1.- AGREGAR UN NUEVO REGISTRO ---");
					System.out.println("Escriba el nombre de la persona");
					scan = new Scanner(System.in);
					nombre = scan.nextLine();
					
					System.out.println("Escriba el apellido de la persona");
					scan = new Scanner(System.in);
					apellido = scan.nextLine();
					
					System.out.println("Escriba la edad de la persona");
					scan = new Scanner(System.in);
					edad = scan.nextInt();
					
					System.out.println("Escriba el nacionalidad de la persona");
					scan = new Scanner(System.in);
					nacionalidad = scan.nextLine();
					
					persona_aux = new Persona(nombre, apellido, edad, nacionalidad);
					
					// Guardar registro
					lista.add(persona_aux);
					System.out.println("Persona registrada correctamente");
					
					break; // Se rompe el case 1
				case 2:
					System.out.println("--- 2.- MOSTRAR LA LISTA ---");
					System.out.println("La información de la lista es:\n" + lista);
					break;
				case 3:
					System.out.println("--- 3.- EDITAR ---");
					System.out.println("Ingresa el índice de la persona a editar");
					scan = new Scanner(System.in);
					indice = scan.nextInt();
					
					persona_aux = lista.get(indice);
					do {
						System.out.println("1.- Editar nombre");
						System.out.println("2.- Editar apellido");
						System.out.println("3.- Editar edad");
						System.out.println("4.- Editar nacionalidad");
						System.out.println("5.- Regresar al menú principal");
						System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
						
						scan = new Scanner(System.in);
						menuSecundario = scan.nextInt();
						
						switch(menuSecundario) {
							case 1:
								System.out.println("Escriba el nuevo nombre de la persona");
								scan = new Scanner(System.in);
								nombre = scan.nextLine();
								persona_aux.setNombre(nombre);
								break;
							case 2:
								System.out.println("Escriba el nuevo apellido de la persona");
								scan = new Scanner(System.in);
								apellido = scan.nextLine();
								persona_aux.setApellido(apellido);
								break;
							case 3:
								System.out.println("Escriba la nueva edad de la persona");
								scan = new Scanner(System.in);
								edad = scan.nextInt();
								persona_aux.setEdad(edad);
								break;
							case 4:
								System.out.println("Escriba la nueva nacionalidad de la persona");
								scan = new Scanner(System.in);
								nacionalidad = scan.nextLine();
								persona_aux.setNacionalidad(nacionalidad);
								break;
							case 5:
								System.out.println("REGRESANDO...");
								break;
							default:
								System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
								break;
						}
						
						if(menuSecundario >= 1 && menuSecundario <= 4) {
							lista.set(indice, persona_aux);
							System.out.println("Persona editada correctamente");
						}
								
					} while(menuSecundario != 5);
					break;
				case 4:
					System.out.println("--- 4.- BUSCAR UN ELEMENTO EN LA LISTA ---");
					System.out.println("¿Cúal índice desdea buscar?");
					scan = new Scanner(System.in);
					indice = scan.nextInt();
					persona_aux = lista.get(indice);
					
					System.out.println("Elemento encontrado:\n" + persona_aux);
					break;
				case 5:
					System.out.println("--- 5.- ELIMINAR UN ELEMENTO---");
					System.out.println("¿Qué desdea eliminar?");
					scan = new Scanner(System.in);
					indice = scan.nextInt();
					
					lista.remove(indice);
					System.out.println("El elemento ha sido eliminado.\nLista actualizada:\n" + lista);
					break;
				case 6:
					System.out.println("--- 6.- CONTAR TODOS LOS ELEMENTOS ---");
					System.out.println("Contenido total de la lista de personas: " + lista.size());
					break;
				case 7:
					System.out.println("SALIENDO DEL PROGRAMA...");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
					break;
			}
		} while(menuPrincipal != 7);
		
	}
}
