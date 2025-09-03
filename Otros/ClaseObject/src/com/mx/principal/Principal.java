package com.mx.principal;

import java.util.ArrayList;
import java.util.Scanner;

import com.mx.entidad.Gerente;
import com.mx.entidad.Obrero;
import com.mx.services.Servicios;

public class Principal {

	public static void main(String[] args) {
		String nombre, apellido, genero, ciudad, curp, area;
		int edad;
		double sueldo;
		
		Scanner entrada;
		int indice, menu, menuGerente, menuObrero;
		Servicios servicios = new Servicios();
		Gerente gerente = new Gerente();
		Obrero obrero = new Obrero();
		
		do {
			System.out.println("\nMenú Principal");
			System.out.println("1.- Gerentes");
			System.out.println("2.- Obreros");
			System.out.println("3.- Salir");
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				switch(menu) {
					case 1:
						do {
							System.out.println("\nMenú Gerentes");
							System.out.println("1.- Alta");
							System.out.println("2.- Editar");
							System.out.println("3.- Buscar");
							System.out.println("4.- Eliminar");
							System.out.println("5.- Mostrar todos los gerentes");
							System.out.println("6.- Listar a los gerentes");
							System.out.println("7.- Calcular sueldo neto");
							System.out.println("8.- Regresar al menú principal");
							
							entrada = new Scanner(System.in);
							menuGerente = entrada.nextInt();
							
							switch(menuGerente) {
								case 1:
									System.out.println("Ingresa el nombre");
									entrada = new Scanner(System.in);
									nombre = entrada.nextLine();
									
									System.out.println("Ingresa el apellido");
									entrada = new Scanner(System.in);
									apellido = entrada.nextLine();
									
									System.out.println("Ingresa la edad");
									entrada = new Scanner(System.in);
									edad = entrada.nextInt();
									
									System.out.println("Ingresa el género");
									entrada = new Scanner(System.in);
									genero = entrada.nextLine();
									
									System.out.println("Ingresa la ciudad");
									entrada = new Scanner(System.in);
									ciudad = entrada.nextLine();
									
									System.out.println("Ingresa el sueldo");
									entrada = new Scanner(System.in);
									sueldo = entrada.nextDouble();
									
									System.out.println("Ingresa el área");
									entrada = new Scanner(System.in);
									area = entrada.nextLine();
									
									gerente = new Gerente(nombre, apellido, edad, genero, ciudad, sueldo, area, new ArrayList<Obrero>());
									servicios.guardar(gerente, "gerente");
									
									break;
								case 2:
									System.out.println("Ingrese el índice del gerente a editar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									servicios.editar(null, indice, "gerente");
									break;
								case 3:
									System.out.println("Ingrese el índice del gerente a buscar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									gerente = (Gerente) servicios.buscar(null, indice, "gerente");
									if(gerente == null) {
										System.out.println("El gerente que tratas de buscar no existe");
									} else {
										System.out.println("El gerente ha sido encontrado:\n" + gerente);
									}
									break;
								case 4:
									System.out.println("Ingrese el índice del gerente a eliminar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									servicios.eliminar(null, indice, "gerente");
									break;
								case 5:
									servicios.mostrar("gerente");
									break;
								case 6:
									servicios.listar("gerente");
									break;
								case 7:
									System.out.println("Ingrese el índice del gerente");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									gerente = (Gerente) servicios.buscar(null, indice, "gerente");
									if(gerente == null) {
										System.out.println("El gerente que se ingreso no existe");
									} else {
										double sueldoNeto = gerente.salarioNeto();
										System.out.println("El salario neto del gerente es: $" + sueldoNeto);
									}
									break;
								case 8:
									System.out.println("Regresando al menú principal...");
									break;
								default:
									System.out.println("Opción inválida, intente de nuevo");
									break;
							}
						} while (menuGerente != 8);
						break;
					case 2:
						do {
							System.out.println("\nMenú Obreros");
							System.out.println("1.- Alta");
							System.out.println("2.- Editar");
							System.out.println("3.- Buscar");
							System.out.println("4.- Eliminar");
							System.out.println("5.- Mostrar todos los obreros");
							System.out.println("6.- Listar a los obreros por curp");
							System.out.println("7.- Regresar al menú principal");
							
							entrada = new Scanner(System.in);
							menuObrero = entrada.nextInt();
							switch(menuObrero) {
								case 1:
									System.out.println("Ingresa el curp");
									entrada = new Scanner(System.in);
									curp = entrada.nextLine();
									
									System.out.println("Ingresa el nombre");
									entrada = new Scanner(System.in);
									nombre = entrada.nextLine();
									
									System.out.println("Ingresa el apellido");
									entrada = new Scanner(System.in);
									apellido = entrada.nextLine();
									
									System.out.println("Ingresa la edad");
									entrada = new Scanner(System.in);
									edad = entrada.nextInt();
									
									System.out.println("Ingresa el género");
									entrada = new Scanner(System.in);
									genero = entrada.nextLine();
									
									System.out.println("Ingresa la ciudad");
									entrada = new Scanner(System.in);
									ciudad = entrada.nextLine();
									
									System.out.println("Ingresa el sueldo");
									entrada = new Scanner(System.in);
									sueldo = entrada.nextDouble();
									
									obrero = new Obrero(nombre, apellido, edad, genero, ciudad, sueldo, curp);
									servicios.guardar(obrero, "obrero");
									break;
								case 2:
									System.out.println("Ingrese el curp del obrero a buscar");
									entrada = new Scanner(System.in);
									curp = entrada.nextLine();
									obrero = new Obrero(curp);
									servicios.editar(obrero, 0, "obrero");
									break;
								case 3:
									System.out.println("Ingrese el curp del obrero a buscar");
									entrada = new Scanner(System.in);
									curp = entrada.nextLine();
									obrero = new Obrero(curp);
									obrero = (Obrero) servicios.buscar(obrero, 0, "obrero");
									if(obrero == null) {
										System.out.println("El obrero que tratas de buscar no existe");
									} else {
										System.out.println("El obrero ha sido encontrado:\n" + obrero);
									}
									break;
								case 4:
									System.out.println("Ingrese el curp del obrero a buscar");
									entrada = new Scanner(System.in);
									curp = entrada.nextLine();
									obrero.setCurp(curp);
									servicios.eliminar(obrero, 0, "obrero");
									break;
								case 5:
									servicios.mostrar("obrero");
									break;
								case 6:
									servicios.listar("obrero");
									break;
								case 7:
									System.out.println("Regresando al menú principal...");
									break;
								default:
									System.out.println("Opción inválida, intente de nuevo");
									break;
							}
						} while (menuObrero != 7);
						break;
					case 3:
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción inválida, intente de nuevo");
						break;
				}
			} catch(Exception e) {
				menu = 4;
				for(StackTraceElement elemento : e.getStackTrace()) {
					System.out.println("\nClase: " + elemento.getClassName());
					System.out.println("Método: " + elemento.getMethodName());
					System.out.println("Línea: " + elemento.getLineNumber());
				}
			}
		} while(menu != 3);

	}

}
