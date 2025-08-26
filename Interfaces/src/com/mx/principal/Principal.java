package com.mx.principal;

import java.util.Scanner;
import com.mx.entidad.Auto;
import com.mx.entidad.Persona;
import com.mx.service.AutoServicio;
import com.mx.service.PersonaService;

public class Principal {
    public static void main(String[] args) {
		String modelo, marca,color,nombre,apellido,genero,ciudad,telefono;
		int edad,cilindros,anio;
		long kilometraje;
		
		Auto auto = new Auto();
		Persona persona = new Persona();
		AutoServicio autoServicio = new AutoServicio();
		PersonaService personaService = new PersonaService();
		int indice,menu,menuAuto,menuPersona,submenu;
		Scanner entrada;
		
		do {
			System.out.println("\nMenu principal");
			System.out.println("1.-Autos");
			System.out.println("2.-Personas");
			System.out.println("3.-Salir del programa");
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				switch (menu) {
				case 1:
					do {
						System.out.println("\nMenu Autos");
						System.out.println("1.-Alta");
						System.out.println("2.-Editar");
						System.out.println("3.-Buscar");
						System.out.println("4.-Eliminar");
						System.out.println("5.-Mostrar todos los autos");
						System.out.println("6.-Listar autos por indice");
						System.out.println("7.-Regresar al menu principal");
						entrada = new Scanner(System.in);
						menuAuto = entrada.nextInt();
						switch (menuAuto) {
						case 1:
							System.out.println("Ingresa el modelo");
							entrada = new Scanner(System.in);
							modelo = entrada.nextLine();
							
							System.out.println("Ingresa la marca del auto");
							entrada = new Scanner(System.in);
							marca = entrada.nextLine();
							
							System.out.println("Ingresa el color");
							entrada = new Scanner(System.in);
							color = entrada.nextLine();
							
							System.out.println("Ingresa el kilometraje");
							entrada = new Scanner(System.in);
							kilometraje = entrada.nextLong();
							
							System.out.println("Ingresa los cilindros");
							entrada = new Scanner(System.in);
							cilindros = entrada.nextInt();
							
							System.out.println("Ingresa el a�o del auto");
							entrada = new Scanner(System.in);
							anio = entrada.nextInt();
							auto = new Auto(modelo, marca, color, kilometraje, cilindros, anio);
							autoServicio.guardar(auto);
							break;
						case 2:
							System.out.println("Ingresa el indice del auto a editar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							auto = autoServicio.buscar(indice);
							if(auto == null) {
							    System.out.println("El auto que tratas de editar no existe");
							}else {
							    do {
								    System.out.println("\nMenu editar");
								    System.out.println("1.-Modelo");
								    System.out.println("2.-Marca");
								    System.out.println("3.-Color");
								    System.out.println("4.-Kilometraje");
								    System.out.println("5.-Cilindros");
								    System.out.println("6.-Año");
								    System.out.println("7.-Salir del menu editar");
								    entrada = new Scanner(System.in);
								    submenu = entrada.nextInt();
								    switch (submenu) {
									case 1:
										System.out.println("Ingrese el modelo nuevo");
										entrada = new Scanner(System.in);
										modelo = entrada.nextLine();
										auto.setModelo(modelo);
										break;
									case 2:
										System.out.println("Ingresa la marca nueva");
										entrada = new Scanner(System.in);
										marca = entrada.nextLine();
										auto.setMarca(marca);
										break;
									case 3:
										System.out.println("Ingresa el color nuevo");
										entrada = new Scanner(System.in);
										color = entrada.nextLine();
										auto.setColor(color);
										break;
									case 4:
										System.out.println("Ingresa el kilometraje nuevo");
										entrada = new Scanner(System.in);
										kilometraje = entrada.nextLong();
										auto.setKilometraje(kilometraje);
										break;
									case 5:
										System.out.println("Ingresa los cilindros nuevos");
										entrada = new Scanner(System.in);
										cilindros = entrada.nextInt();
										auto.setCilindros(cilindros);
										break;
									case 6:
										System.out.println("Ingresa el a�o nuevo");
										entrada = new Scanner(System.in);
										anio = entrada.nextInt();
										auto.setAnio(anio);
										break;
									case 7:
										System.out.println("Saliendo del menu editar");
										break;
									default:
										System.out.println("Opcion invalida intenta de nuevo");
										break;
									}
								    autoServicio.editar(auto, indice);
								} while (submenu != 7);
							}
							break;
						case 3:
							System.out.println("Ingresa el indice del auto a buscar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							auto = autoServicio.buscar(indice);
							if(auto == null) {
							    System.out.println("El auto que tratas de buscar no existe");	
							}else {
							    System.out.println("El auto ha sido encontrado\n"+auto);
							}
							break;
						case 4:
							System.out.println("Ingresa el auto a eliminar");
							entrada = new Scanner(System.in);
							indice = entrada.nextInt();
							autoServicio.eliminar(indice);
							break;
						case 5:
							autoServicio.mostrar();
							break;
						case 6:
							autoServicio.listar();
							break;
						case 7:
							System.out.println("Regresando al menu principal");
							break;
						default:
							System.out.println("Opcion invalida intenta de nuevo");
							break;
						}
					} while (menuAuto !=7);
					break;
				case 2:
					break;
				case 3:
					System.out.println("Saliendo del programa");
					break;
				default:
					System.out.println("Opcion invalida intenta de nuevo");
					break;
				}
			} catch (Exception e) {
				menu = 4;
				System.out.println("Error durante la ejecuccion\n");
				for(StackTraceElement element : e.getStackTrace()) {
				    System.out.println("\nClase: "+element.getClassName());
				    System.out.println("Metodo: "+element.getMethodName());
				    System.out.println("Archivo: "+element.getFileName());
				    System.out.println("Linea: "+element.getLineNumber());
				}
			}/*finally {
			    System.out.println("Siempre me ejecuto");	
			}*/
		} while (menu != 3);
	}
}
