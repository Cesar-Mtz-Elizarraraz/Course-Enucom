package com.mx.Celular;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// Instanciar
		Celular cel1 = new Celular("Motorola", "Moto g6", "Negro", 23245235, "Octa Core", 2300);
		Celular cel2 = new Celular("Infinix", "Note35", "Negro", 631330890, "Mediatek", 4050);
		Celular cel3 = new Celular("Huawei", "P40", "Gris", 52144561, "Octa Core", 2300);
		Celular cel4 = new Celular("Xiaomi", "Redmi Note 14", "Blanco", 5623124, "Snapdragon", 7500);
		Celular cel5 = new Celular("Xiaomi", "Redmi Note 11", "Gris", 557894321, "Octa Core", 7200);

		// Objeto auxiliar
		Celular celular = null;
		
		// Intancia de implementación para poder usar sus métodos declarados
		Implementacion imp = new Implementacion();
		
		// Agregar elementos a la lista
		imp.guardar(cel1);
		imp.guardar(cel2);
		imp.guardar(cel3);
		imp.guardar(cel4);
		imp.guardar(cel5);
		
		/* // MOstrar
		imp.mostrar();
		
		// Buscar
		celular = imp.buscar(0);
		System.out.println(celular);
		
		// Editar
		celular = imp.buscar(1);
		celular.setColor("Amazul");
		imp.editar(1, celular);
		imp.mostrar();
		
		// Eliminar
		imp.eliminar(0);
		imp.mostrar();
		
		// Método personalizado
		imp.contar();
		
		// Realizar la actividad de práctica: Replicación del ejercicio con una entidad diferente
		*/
		
		// Declaración de variables
		Scanner datos = new Scanner(System.in);
		int menuP = 0, menuS = 0, indice = 0;
		// Variables locales
		String marca, modelo, color, procesador;
		int imei, precio;
		
		do {
			System.out.println("\n--- M E N Ú ----");
			System.out.println("1.- ALTA");
			System.out.println("2.- BUSCAR");
			System.out.println("3.- EDITAR");
			System.out.println("4.- ELIMINAR");
			System.out.println("5.- MOSTRAR");
			System.out.println("6.- CONTAR");
			System.out.println("7.- SALIR DEL MENÚ");
			System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
			
			// try-catch es para evitar que el programa se detenga cuando el usuario introduzca un caracter no numérico
			try {
				menuP = datos.nextInt();
				// Inicio del bloque SWITCH
				switch(menuP) {
					case 1:
						System.out.println("--- 1.- ALTA ---");
						System.out.println("Llena los sigueintes datos del celular");
						
						System.out.println("MARCA:");
						marca = datos.nextLine();
						
						System.out.println("MODELO:");
						modelo = datos.nextLine();
						
						System.out.println("COLOR:");
						color = datos.nextLine();
						
						System.out.println("IMEI:");
						imei = datos.nextInt();
						datos.nextLine();
						
						System.out.println("PROCESADOR:");
						procesador = datos.nextLine();
						
						System.out.println("PRECIO:");
						precio = datos.nextInt();
						
						celular = new Celular(marca, modelo, color, imei, procesador, precio);
						imp.guardar(celular);
						System.out.println("El celular " + marca + " se guardo con éxito");
						break;
					case 2:
						System.out.println("--- 2.- BUSCAR ---");
						imprimirDatos(imp);
						if(imp.listaCelulares.size() > 0) {
							System.out.println("Indica el índice para mostrar la información");
							indice = datos.nextInt();
							datos.nextLine();
							
							if(indice >= 0 && indice < imp.listaCelulares.size()) {
								celular = imp.buscar(indice);
								System.out.println("Esta es la información completa del celular: " + celular);	
							} else {
								System.out.println("Índice fuera de rango, intenta con uno dentro de la lista");
							}
						}
						break;
					case 3:
						System.out.println("--- 3.- EDITAR ---");
						imprimirDatos(imp);
						if(imp.listaCelulares.size() > 0) {
							System.out.println("Indica el índice para editar la información");
							indice = datos.nextInt();
							datos.nextLine();
							
							if(indice >= 0 && indice < imp.listaCelulares.size()) {
								celular = imp.buscar(indice);
								do {
									System.out.println("\nMenú editar");
									System.out.println("1.- EDITAR MARCA");
									System.out.println("2.- EDITAR MODELO");
									System.out.println("3.- EDITAR COLOR");
									System.out.println("4.- EDITAR IMEI");
									System.out.println("5.- EDITAR PROCESADOR");
									System.out.println("6.- EDITAR PRECIO");
									System.out.println("7.- REGRESAR AL MENPU PRINCIPAL");
									System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
									
									menuS = datos.nextInt();
									datos.nextLine();
									
									switch(menuS) {
										case 1:
											System.out.println("NUEVA MARCA:");
											marca = datos.nextLine();
											celular.setMarca(marca);
											break;
										case 2:
											System.out.println("NUEVO MODELO:");
											modelo = datos.nextLine();
											celular.setModelo(modelo);
											break;
										case 3:
											System.out.println("NUEVO COLOR:");
											color = datos.nextLine();
											celular.setColor(color);
											break;
										case 4:
											System.out.println("NUEVO IMEI:");
											imei = datos.nextInt();
											datos.nextLine();
											celular.setImei(imei);
											break;
										case 5:
											System.out.println("NUEVO PROCESADOR:");
											procesador = datos.nextLine();
											celular.setProcesador(procesador);
											break;
										case 6:
											System.out.println("NUEVO PRECIO:");
											precio = datos.nextInt();
											datos.nextLine();
											celular.setPrecio(precio);
											break;
										case 7:
											System.out.println("SALIENDO DEL PROGRAMA...");
											break;
										default:
											System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
											break;
									}
								} while(menuS != 7);
							} else {
								System.out.println("Índice fuera de rango, intenta con uno dentro de la lista");
							}
						}
						break;
					case 4:
						System.out.println("--- 4.- ELIMINAR ---");
						imprimirDatos(imp);
						if(imp.listaCelulares.size() > 0) {
							System.out.println("Indica el índice para eliminar la información");
							indice = datos.nextInt();
							datos.nextLine();
							
							if(indice >= 0 && indice < imp.listaCelulares.size()) {
								imp.eliminar(indice);
							} else {
								System.out.println("Índice fuera de rango, intenta con uno dentro de la lista");
							}
						}
						break;
					case 5:
						System.out.println("--- 5.- MOSTRAR ---");
						if(imp.listaCelulares.size() > 0) {
							imp.mostrar();
						} else {
							System.out.println("No hay registros en la lista");
						}
						break;
					case 6:
						System.out.println("--- 6.- CONTAR ---");
						imp.contar();
						break;
					case 7:
						System.out.println("SALIENDO DEL PROGRAMA...");
						break;
					default:
						System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
						break;
				}
			} catch(InputMismatchException e) {
				System.out.println("Entrada inválida, por favor ingresa un número");
				datos.nextLine();
			}
		} while(menuP != 7);
	}
	
	// ACTIVIDAD: Hacer el menú interactivo para la actividad de práctica que se realizó
	/*
	 * OPCIONES A IMPLEMENTAAR:
	 *  - ALTA
	 *  - MOSTRAR
	 *  - EDITAR
	 *  - ELIMINAR POR ATRIBUTO
	 *  - BUSCAR POR ATRIBUTO
	 *  - CONTAR
	 *  
	 *  Complementar con las validaciones:
	 *  - Verificar que no existan elementos duplicados
	 *  - Verificar que exista el elemento para poder eliminar o editar
	 * */

	// El método estático necesita estar relacionado con la clase
	private static void imprimirDatos(Implementacion imp) {
		System.out.println("--- CELULARES REGISTRADOS ---");
		List<Celular> listaCelulares = imp.listaCelulares;
		if(listaCelulares.size() > 0) {
			for(int i = 0; i < listaCelulares.size(); i++) {
				System.out.println("El celular [" + i + "] de marca: " + listaCelulares.get(i).getMarca());
			}
		} else {
			System.out.println("No hay celulares registrados");
		}
	}
}
