package com.mx.Libro;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Libro lib1 = new Libro(1001, "El principito", "Antoine de Saint-Exupéry", 2500, "Fantasía", 1000);
		Libro lib2 = new Libro(1002, "Cien años de soledad", "Gabriel García Márquez", 3200, "Realismo mágico", 500);
		Libro lib3 = new Libro(1003, "1984", "George Orwell", 2800, "Distopía", 750);
		Libro lib4 = new Libro(1004, "Orgullo y prejuicio", "Jane Austen", 2600, "Romance", 600);
		Libro lib5 = new Libro(1005, "La odisea", "Homero", 3000, "Épico", 400);
		
		Libro libro = null;
		
		Implementacion implementacion = new Implementacion();
		
		// AGREGAR ELEMENTOS
		implementacion.guardar(lib1);
		implementacion.guardar(lib2);
		implementacion.guardar(lib3);
		implementacion.guardar(lib4);
		implementacion.guardar(lib5);
		
		/* // MOSTRAR
		System.out.println("\n--- MOSTRAR ---");
		implementacion.mostrar();
		
		// BUSCAR
		System.out.println("\n--- BUSCAR ---");
		libro = implementacion.buscar(1);
		System.out.println(libro);
		
		// EDITAR
		System.out.println("\n--- EDITAR ---");
		libro = implementacion.buscar(4);
		libro.setNumeroCopias(555);
		libro.setGenero("Novela");
		implementacion.editar(4, libro);
		implementacion.mostrar(); // VALIDAR LA ACTUALIZACIÓN
		
		// ELIMINAR
		System.out.println("\n--- ELIMINAR ---");
		implementacion.eliminar(3);
		implementacion.mostrar(); // VALIDAR LA ELIMINACIÓN
		
		// MÉTODO PERSONALIZADO
		System.out.println("\n--- MÉTODO PERSONALIZADO ---");
		implementacion.contar();
		*/
		
		List<Libro> listaLibros = null;
		Scanner datos = new Scanner(System.in);
		int menuP = 0, menuS = 0, indice = 0, isbnBusqueda;
		boolean isbnValido = false;
		
		String nombre, autor, genero;
		int isbn, numeroCopias;
		double precio;
		
		do {
			System.out.println("\n--- M E N Ú  P R I N C I P A L ----");
			System.out.println("1.- ALTA");
			System.out.println("2.- MOSTRAR");
			System.out.println("3.- EDITAR");
			System.out.println("4.- ELIMINAR POR ISBN");
			System.out.println("5.- BUSCAR POR ISBN");
			System.out.println("6.- CONTAR");
			System.out.println("7.- SALIR DEL MENÚ");
			System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
			
			try {
				menuP = datos.nextInt();
				datos.nextLine();
				switch(menuP) {
					case 1:
						System.out.println("--- 1.- ALTA ---");
						System.out.println("Llena los siguientes datos del libro");
						
						System.out.println("ISBN:");
						isbn = datos.nextInt();
						datos.nextLine();
						
						System.out.println("NOMBRE:");
						nombre = datos.nextLine();
						
						System.out.println("AUTOR:");
						autor = datos.nextLine();
						
						System.out.println("PRECIO:");
						precio = datos.nextDouble();
						datos.nextLine();
						
						System.out.println("GÉNERO:");
						genero = datos.nextLine();
						
						System.out.println("NÚMERO DE COPIAS:");
						numeroCopias = datos.nextInt();
						
						listaLibros = implementacion.listaLibros;
						isbnValido = esISBNValido(listaLibros, isbn);
						
						if(isbnValido) {
							// GUARDAR
							libro = new Libro(isbn, nombre, autor, precio, genero, numeroCopias);
							implementacion.guardar(libro);
							System.out.println("El libro '" + nombre + "' se guardo correctamente");
						}
						
						break;
					case 2:
						System.out.println("--- 2.- MOSTRAR ---");
						listaLibros = implementacion.listaLibros;
						if(listaLibros.size() > 0) {
							implementacion.mostrar();
						} else {
							System.out.println("X No hay registros en la lista");
						}
						break;
					case 3:
						System.out.println("--- 3.- EDITAR ---");
						imprimirDatos(implementacion);
						listaLibros = implementacion.listaLibros;
						if(listaLibros.size() > 0) {
							System.out.print("\nIndica el índice para editar la información: ");
							indice = datos.nextInt();
							datos.nextLine();
							
							if(indice >= 0 && indice < listaLibros.size()) {
								do {
									libro = implementacion.buscar(indice);
									
									System.out.println("\nLibro seleccionado:\n" + libro);
									
									System.out.println("Menú editar");
									System.out.println("1.- EDITAR ISBN");
									System.out.println("2.- EDITAR NOMBRE");
									System.out.println("3.- EDITAR AUTOR");
									System.out.println("4.- EDITAR PRECIO");
									System.out.println("5.- EDITAR GÉNERO");
									System.out.println("6.- EDITAR NÚMERO DE COPIAS");
									System.out.println("7.- REGRESAR AL MENÚ PRINCIPAL");
									System.out.println("**** ELIGE UNA OPCIÓN DENTRO DEL MENÚ ****");
									
									menuS = datos.nextInt();
									datos.nextLine();
									
									switch(menuS) {
										case 1:
											System.out.println("NUEVO ISBN:");
											isbn = datos.nextInt();
											datos.nextLine();
											
											listaLibros = implementacion.listaLibros;
											isbnValido = esISBNValido(listaLibros, isbn);
											
											if(isbnValido) {
												// EDITAR
												libro.setIsbn(isbn);
												implementacion.editar(indice, libro);
												System.out.println("El libro fue editado correctamente");
											}
											
											break;
										case 2:
											System.out.println("NUEVO NOMBRE:");
											nombre = datos.nextLine();
											libro.setNombre(nombre);
											break;
										case 3:
											System.out.println("NUEVO AUTOR:");
											autor = datos.nextLine();
											libro.setAutor(autor);
											break;
										case 4:
											System.out.println("NUEVO PRECIO:");
											precio = datos.nextDouble();
											datos.nextLine();
											libro.setPrecio(precio);
											break;
										case 5:
											System.out.println("NUEVO GÉNERO:");
											genero = datos.nextLine();
											libro.setGenero(genero);
											break;
										case 6:
											System.out.println("NUEVO NÚMERO DE COPIAS:");
											numeroCopias = datos.nextInt();
											datos.nextLine();
											libro.setNumeroCopias(numeroCopias);
											break;
										case 7:
											System.out.println("REGRESANDO...");
											break;
										default:
											System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
											break;
									}
									if(menuS >= 2 && menuS <= 6) {
										implementacion.editar(indice, libro);
										System.out.println("El libro fue editado correctamente");
									}
								} while(menuS != 7);
							} else {
								System.out.println("X El índice se encuentra fuera de rango");
							}
						}
						break;
					case 4:
						System.out.println("--- 4.- ELIMINAR POR ISBN ---");
						listarPorISBN(implementacion);
						listaLibros = implementacion.listaLibros;
						if(listaLibros.size() > 0) {
							System.out.print("\nIndica el ISBN para eliminar el libro: ");
							isbnBusqueda = datos.nextInt();
							datos.nextLine();
							
							indice = getIndex(listaLibros, isbnBusqueda);
							
							if(indice >= 0) {
								implementacion.eliminar(indice);
								System.out.println("El libro ha sido eliminado correctamente.\nLista actualizada:\n" + implementacion.listaLibros);
							} else {
								System.out.println("X No existe el libro con el ISBN " + isbnBusqueda);
							}
						}
						break;
					case 5:
						System.out.println("--- 5.- BUSCAR POR ISBN ---");
						listarPorISBN(implementacion);
						listaLibros = implementacion.listaLibros;
						if(listaLibros.size() > 0) {
							System.out.print("\nIndica el ISBN para buscar el libro: ");
							isbnBusqueda = datos.nextInt();
							datos.nextLine();
							
							indice = getIndex(listaLibros, isbnBusqueda);
							
							if(indice >= 0) {
								libro = implementacion.buscar(indice);
								System.out.println("\nInformación completa del libro:\n" + libro);	
							} else {
								System.out.println("X No existe el libro con el ISBN " + isbnBusqueda);
							}
						}
						break;
					case 6:
						System.out.println("--- 6.- CONTAR ---");
						implementacion.contar();
						break;
					case 7:
						System.out.println("SALIENDO DEL PROGRAMA...");
						break;
					default:
						System.out.println("OPCIÓN NO VÁLIDA, INTENTE DE NUEVO CON UN ÍNDICE DENTRO DEL MENÚ");
						break;
				}
			} catch(InputMismatchException e) {
				System.out.println("X Dato inválido, asegurate de ingresar un número");
				datos.nextLine();
			}
		} while(menuP != 7);
	}

	private static void imprimirDatos(Implementacion implementacion) {
		System.out.println("--- LIBROS REGISTRADOS ---");
		List<Libro> listaLibros = implementacion.listaLibros;
		if(listaLibros.size() > 0) {
			for(int i = 0; i < listaLibros.size(); i++) {
				System.out.println("Libro #" + i + " con el título '" + listaLibros.get(i).getNombre() + "'");
			}
		} else {
			System.out.println("X No hay libros registrados");
		}
	}
	
	private static boolean esISBNValido(List<Libro> lista, int isbn) {
		// Validar la existencia del nombre
		boolean bandera = true;
		for(Libro l : lista) {
			if(l.getIsbn() == isbn) {
				bandera = false;
				System.out.println("El ISBN ingresado ya existe dentro de la lista");
				break;
			}
		}
		
		return bandera;
	}
	
	private static void listarPorISBN(Implementacion implementacion) {
		System.out.println("--- LIBROS REGISTRADOS ---");
		List<Libro> listaLibros = implementacion.listaLibros;
		Libro libro;
		if(listaLibros.size() > 0) {
			for(int i = 0; i < listaLibros.size(); i++) {
				libro = listaLibros.get(i);
				System.out.println("Libro de ISBN " + libro.getIsbn() + " con el título '" + libro.getNombre() + "'");
			}
		} else {
			System.out.println("X No hay libros registrados");
		}
	}
	
	private static int getIndex(List<Libro> lista, int isbn) {
		// Buscar índice por isbn
		Libro libro;
		int indice = -1;
		for(int i = 0; i < lista.size(); i++) {
			libro = lista.get(i);
			if(libro.getIsbn() == isbn) {
				indice = i;
				break;
			}
		}
		
		return indice;
	}
}
