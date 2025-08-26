package com.mx.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Gerente;
import com.mx.entidad.Obrero;
import com.mx.metodos.Metodos;

public class Servicios implements Metodos {
	List<Gerente> listaGerentes = new ArrayList<Gerente>();
	HashMap<String, Obrero> hashObreros = new HashMap<String, Obrero>(); 

	@Override
	public void guardar(Object obj, String clase) {
		if("obrero".equals(clase)) {
			Obrero obrero = (Obrero)obj;
			if(hashObreros.containsKey(obrero.getCurp())) {
				System.out.println("El obrero no se agrego porque ya existe el curp");
			} else {
				Obrero obrero_aux;
				boolean bandera = false;
				for(String key : hashObreros.keySet()) {
					obrero_aux = hashObreros.get(key);
					if(obrero_aux.getApellido().equalsIgnoreCase(obrero.getApellido()) && obrero_aux.getNombre().equalsIgnoreCase(obrero.getNombre())) {
						System.out.println("El obrero no se agrego porque ya existe el nombre y apellido");
						bandera = true;
						break;
					}
				}
				
				if(!bandera) {
					hashObreros.put(obrero.getCurp(), obrero);
					System.out.println("El obrero ha sido registrado correctamente");
				}
			}
		} else {
			Gerente gerente = (Gerente)obj;
			int bandera = 0;
			for(Gerente g : listaGerentes) {
				if(gerente.getNombre().equalsIgnoreCase(g.getNombre()) && gerente.getApellido().equalsIgnoreCase(g.getApellido())) {
					System.out.println("El gerente no se agrego porque ya existe el nombre y apellido");
					bandera = 1;
					break;
				}
			}
			
			if(bandera == 0) {
				listaGerentes.add(gerente);
				System.out.println("El gerente ha sido registrado correctamente");
			}
		}
		
	}

	@Override
	public void editar(Object obj, int indice, String clase) {
		Scanner entrada;
		int menu;
		if(clase.equals("gerente")) {
			if(listaGerentes.size() <= indice) {
				System.out.println("El gerente que tratas de editar no existe");
			} else {
				Gerente gerente = listaGerentes.get(indice);
				do {
					System.out.println("\nMenú editar gerente");
					System.out.println("1.- Nombre");
					System.out.println("2.- Apellido");
					System.out.println("3.- Edad");
					System.out.println("4.- Género");
					System.out.println("5.- Ciudad");
					System.out.println("6.- Sueldo");
					System.out.println("7.- Salir del menú editar");
					
					entrada = new Scanner(System.in);
					menu = entrada.nextInt();
					switch(menu) {
						case 1:
							System.out.println("Ingresa el nuevo nombre del gerente");
							entrada = new Scanner(System.in);
							String nombre = entrada.nextLine();
							gerente.setNombre(nombre);
							break;
						case 2:
							System.out.println("Ingresa el nuevo apellido del gerente");
							entrada = new Scanner(System.in);
							String apellido = entrada.nextLine();
							gerente.setApellido(apellido);
							break;
						case 3:
							System.out.println("Ingresa la nueva edad del gerente");
							entrada = new Scanner(System.in);
							int edad = entrada.nextInt();
							gerente.setEdad(edad);
							break;
						case 4:
							System.out.println("Ingresa el nuevo género del gerente");
							entrada = new Scanner(System.in);
							String genero = entrada.nextLine();
							gerente.setGenero(genero);
							break;
						case 5:
							System.out.println("Ingresa la nueva ciudad de residencia del gerente");
							entrada = new Scanner(System.in);
							String ciudad = entrada.nextLine();
							gerente.setCiudad(ciudad);
							break;
						case 6:
							System.out.println("Ingresa el nuevo saldo del gerente");
							entrada = new Scanner(System.in);
							double sueldo = entrada.nextDouble();
							gerente.setSueldo(sueldo);
							break;
						case 7:
							System.out.println("Saliendo del menú editar...");
							break;
						default:
							System.out.println("Opción inválida, intente de nuevo");
							break;
					}
				} while(menu != 7);
			}
		} else {
			Obrero obrero = (Obrero) obj;
			if(hashObreros.containsKey(obrero.getCurp())){
				obrero = hashObreros.get(obrero.getCurp());
				if(obrero != null) {
					do {
						System.out.println("\nMenú editar gerente");
						System.out.println("1.- Nombre");
						System.out.println("2.- Apellido");
						System.out.println("3.- Edad");
						System.out.println("4.- Género");
						System.out.println("5.- Ciudad");
						System.out.println("6.- Sueldo");
						System.out.println("7.- Salir del menú editar");
						
						entrada = new Scanner(System.in);
						menu = entrada.nextInt();
						
						switch(menu) {
							case 1:
								System.out.println("Ingresa el nuevo nombre del obrero");
								entrada = new Scanner(System.in);
								String nombre = entrada.nextLine();
								obrero.setNombre(nombre);
								break;
							case 2:
								System.out.println("Ingresa el nuevo apellido del obrero");
								entrada = new Scanner(System.in);
								String apellido = entrada.nextLine();
								obrero.setApellido(apellido);
								break;
							case 3:
								System.out.println("Ingresa la nueva edad del obrero");
								entrada = new Scanner(System.in);
								int edad = entrada.nextInt();
								obrero.setEdad(edad);
								break;
							case 4:
								System.out.println("Ingresa el nuevo género del obrero");
								entrada = new Scanner(System.in);
								String genero = entrada.nextLine();
								obrero.setGenero(genero);
								break;
							case 5:
								System.out.println("Ingresa la nueva ciudad de residencia del obrero");
								entrada = new Scanner(System.in);
								String ciudad = entrada.nextLine();
								obrero.setCiudad(ciudad);
								break;
							case 6:
								System.out.println("Ingresa el nuevo saldo del obrero");
								entrada = new Scanner(System.in);
								double sueldo = entrada.nextDouble();
								obrero.setSueldo(sueldo);
								break;
							case 7:
								System.out.println("Saliendo del menú editar...");
								break;
							default:
								System.out.println("Opción inválida, intente de nuevo");
								break;
						}
						hashObreros.put(obrero.getCurp(), obrero);
					} while(menu != 7);
				} else {
					System.out.println("El obrero que tratas de editar no existe");
				}
				
			}
		}
		
	}

	@Override
	public void eliminar(Object obj, int indice, String clase) {
		if(clase.equals("gerente")) {
			if(listaGerentes.size() <= indice) {
				System.out.println("El gerente que tratas de eliminar no existe");
			} else {
				Gerente gerente = listaGerentes.get(indice);
				listaGerentes.remove(indice);
				
				System.out.println("El siguiente gerente fue eliminado:\n" + gerente);
			}
		} else {
			Obrero obrero = (Obrero)obj;
			if(hashObreros.containsKey(obrero.getCurp())) {
				hashObreros.remove(obrero.getCurp());
				System.out.println("El siguiente obrero fue eliminado:\n" + obrero);
			} else {
				System.out.println("El obrero que tratas de eliminar no existe");
			}
		}
	}

	@Override
	public Object buscar(Object obj, int indice, String clase) {
		if(clase.equals("gerente")) {
			if(indice < listaGerentes.size()) {
				Gerente gerente = listaGerentes.get(indice);
				return gerente;
			}
		} else {
			Obrero obrero = (Obrero)obj;
			if(hashObreros.containsKey(obrero.getCurp())) {
				obrero = hashObreros.get(obrero.getCurp());
				return obrero;
			}
		}
		return null;
	}

	@Override
	public void mostrar(String clase) {
		if(clase.equals("obrero")) {
			if(hashObreros.isEmpty()) {
				System.out.println("No hay obreros que mostrar");
			} else {
				System.out.println("Obreros:\n" + hashObreros);
			}
		} else {
			if(listaGerentes.isEmpty()) {
				System.out.println("No hay gerentes que mostrar");
			} else {
				System.out.println("Gerentes:\n" + listaGerentes);
			}
		}
	}
	
	public void listar(String clase) {
		if(clase.equals("obrero")) {
			if(hashObreros.isEmpty()) {
				System.out.println("No hay obreros que listar");
			} else {
				Obrero obrero;
				for(String key: hashObreros.keySet()) {
					obrero = hashObreros.get(key);
					System.out.println("[" + key + "] => " + obrero.getNombre() + " " + obrero.getApellido());
				}
			}
		} else {
			if(listaGerentes.isEmpty()) {
				System.out.println("No hay gerentes que listar");
			} else {
				for(Gerente g : listaGerentes) {
					System.out.println("[" + listaGerentes.indexOf(g) + g.getNombre() + " " + g.getApellido());
				}
			}
		}
	}
	
}
