package com.mx.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Instancias de la clase
		Animal animal1 = new Animal("Firulais", "Macho", "Perro", 12.5, 0.45);
		Animal animal2 = new Animal("Misu", "Hembra", "Gato", 4.2, 0.25);
		Animal animal3 = new Animal("Dumbo", "Macho", "Elefante", 5400.0, 3.2);
		Animal animal4 = new Animal("Astra", "Hembra", "Aguila", 6.5, 0.85);
		Animal animal5 = new Animal("Sombra", "Macho", "Tiburon", 1100.0, 4.0);

		List<Animal> listaAnimales = new ArrayList<Animal>();
		
		// AÑADIR ELEMENTOS A LA LISTA
		listaAnimales.add(animal1);
		listaAnimales.add(animal2);
		listaAnimales.add(animal3);
		listaAnimales.add(animal4);
		listaAnimales.add(animal5);
		
		/*
		 * // MOSTRAR System.out.println("Animales registrados:\n" + listaAnimales);
		 * 
		 * // Crear un auxiliar Animal animal_aux = null;
		 * 
		 * // BUSCAR animal_aux = listaAnimales.get(0);
		 * System.out.println("\nAnimal encontrado:\n" + animal_aux);
		 * 
		 * // EDITAR animal_aux = listaAnimales.get(3); animal_aux.setPeso(8.3);
		 * animal_aux.setSexo("Macho"); System.out.println("Animal actualizado:\n" +
		 * animal_aux);
		 * 
		 * // ELIMINAR listaAnimales.remove(4);
		 * System.out.println("Animales actualizados:\n" + listaAnimales);
		 * 
		 * // LIMPIAR listaAnimales.clear();
		 * 
		 * // VALIDAR if(listaAnimales.isEmpty()) {
		 * System.out.println("\nLa lista se encuentra vacía"); } else {
		 * System.out.println("\nLa lista aún contiene registros:\n" + listaAnimales); }
		 */
		
		Animal animal_aux = null;
		
		Scanner scan = null;
		String nombreBusqueda;
		int menuPrincipal = 0, menuSecundario = 0, indice = 0;
		boolean nombreValido;
		
		// VARIABLES LOCALES
		String nombre, sexo, especie;
		double peso, altura;
		
		do {
			System.out.println("\n--- M E N Ú ----");
			System.out.println("1.- AGREGAR UN NUEVO REGISTRO");
			System.out.println("2.- MOSTRAR LA LISTA");
			System.out.println("3.- EDITAR");
			System.out.println("4.- BUSCAR UN ELEMENTO EN LA LISTA POR NOMBRE");
			System.out.println("5.- ELIMINAR UN ELEMENTO POR NOMBRE");
			System.out.println("6.- CONTAR TODOS LOS ELEMENTOS");
			System.out.println("7.- ELIMINAR TODOS LOS ELEMENTOS");
			System.out.println("8.- SALIR DEL MENÚ");
			System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
			
			scan = new Scanner(System.in);
			menuPrincipal = scan.nextInt();
			
			switch(menuPrincipal) {
				case 1:
					System.out.println("--- 1.- AGREGAR UN NUEVO REGISTRO ---");
					System.out.println("Escriba el nombre del animal");
					scan = new Scanner(System.in);
					nombre = scan.nextLine();
					
					System.out.println("Escriba el sexo del animal");
					scan = new Scanner(System.in);
					sexo = scan.nextLine();
					
					System.out.println("Escriba la especie del animal");
					scan = new Scanner(System.in);
					especie = scan.nextLine();
					
					System.out.println("Escriba el peso del animal");
					scan = new Scanner(System.in);
					peso = scan.nextDouble();
					
					System.out.println("Escriba la altura del animal");
					scan = new Scanner(System.in);
					altura = scan.nextDouble();
					
					nombreValido = esNombreValido(listaAnimales, nombre);
					
					if(nombreValido) {
						// GUARDAR
						animal_aux = new Animal(nombre, sexo, especie, peso, altura);
						listaAnimales.add(animal_aux);
						System.out.println("Animal registrado correctamente");
					}
					
					break;
				case 2:
					System.out.println("--- 2.- MOSTRAR LA LISTA ---");
					System.out.println("La información de la lista es:\n" + listaAnimales);
					break;
				case 3:
					System.out.println("--- 3.- EDITAR ---");
					System.out.println("Ingresa el índice del animal a editar");
					scan = new Scanner(System.in);
					indice = scan.nextInt();
					
					animal_aux = listaAnimales.get(indice);
					do {
						System.out.println("1.- Editar nombre");
						System.out.println("2.- Editar sexo");
						System.out.println("3.- Editar especie");
						System.out.println("4.- Editar peso");
						System.out.println("5.- Editar altura");
						System.out.println("6.- Regresar al menú principal");
						System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
						
						scan = new Scanner(System.in);
						menuSecundario = scan.nextInt();
						
						switch(menuSecundario) {
							case 1:
								System.out.println("Escriba el nuevo nombre del animal");
								scan = new Scanner(System.in);
								nombre = scan.nextLine();
								nombreValido = esNombreValido(listaAnimales, nombre);
								
								if(nombreValido) {
									// EDITAR
									animal_aux.setNombre(nombre);
									System.out.println("Animal editado correctamente");
								}
								
								break;
							case 2:
								System.out.println("Escriba el nuevo sexo del animal");
								scan = new Scanner(System.in);
								sexo = scan.nextLine();
								animal_aux.setSexo(sexo);
								break;
							case 3:
								System.out.println("Escriba la nueva especie del animal");
								scan = new Scanner(System.in);
								especie = scan.nextLine();
								animal_aux.setEspecie(especie);
								break;
							case 4:
								System.out.println("Escriba el nuevo peso del animal");
								scan = new Scanner(System.in);
								peso = scan.nextDouble();
								animal_aux.setPeso(peso);
								break;
							case 5:
								System.out.println("Escriba la nueva altura del animal");
								scan = new Scanner(System.in);
								altura = scan.nextDouble();
								animal_aux.setAltura(altura);
								break;
							case 6:
								System.out.println("REGRESANDO...");
								break;
							default:
								System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
								break;
						}
						
						if(menuSecundario >= 2 && menuSecundario <= 5) {
							listaAnimales.set(indice, animal_aux);
							System.out.println("Animal editado correctamente");
						}
								
					} while(menuSecundario != 6);
					break;
				case 4:
					System.out.println("--- 4.- BUSCAR UN ELEMENTO EN LA LISTA POR NOMBRE ---");
					System.out.println("Escribe el nombre del animal a buscar");
					scan = new Scanner(System.in);
					nombreBusqueda = scan.nextLine();
					indice = getIndex(listaAnimales, nombreBusqueda);
					
					if(indice >= 0) {
						animal_aux = listaAnimales.get(indice);
						System.out.println("Elemento encontrado:\n" + animal_aux);
					} else {
						System.out.println("No existen el animal con el nombre " + nombreBusqueda);
					}
					break;
				case 5:
					System.out.println("--- 5.- ELIMINAR UN ELEMENTO POR NOMBRE---");
					System.out.println("Escribe el nombre del animal a eliminar");
					scan = new Scanner(System.in);
					nombreBusqueda = scan.nextLine();
					indice = getIndex(listaAnimales, nombreBusqueda);
					
					if(indice >= 0) {
						listaAnimales.remove(indice);
						System.out.println("El elemento ha sido eliminado.\nLista actualizada:\n" + listaAnimales);
					} else {
						System.out.println("No existen el animal con el nombre " + nombreBusqueda);
					}
					break;
				case 6:
					System.out.println("--- 6.- CONTAR TODOS LOS ELEMENTOS ---");
					System.out.println("Contenido total de la lista de animales: " + listaAnimales.size());
					break;
				case 7:
					System.out.println("--- 7.- ELIMINAR TODOS LOS ELEMENTOS ---");
					listaAnimales.clear();
					System.out.println("Todos los animales han sido eliminados");
					break;
				case 8:
					System.out.println("SALIENDO DEL PROGRAMA...");
					break;
				default:
					System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
					break;
			}
		} while(menuPrincipal != 8);
		
	}
	
	private static boolean esNombreValido(List<Animal> lista, String nombre) {
		// Validar la existencia del nombre
		boolean bandera = true;
		for(Animal a : lista) {
			if(a.getNombre().equalsIgnoreCase(nombre)) {
				bandera = false;
				System.out.println("El nombre ingresado ya existe dentro de la lista");
				break;
			}
		}
		
		return bandera;
	}
	
	private static int getIndex(List<Animal> lista, String nombre) {
		// Buscar índice por nombre
		Animal animal;
		int indice = -1;
		for(int i = 0; i < lista.size(); i++) {
			animal = lista.get(i);
			if(animal.getNombre().equalsIgnoreCase(nombre)) {
				indice = i;
				break;
			}
		}
		
		return indice;
	}

}
