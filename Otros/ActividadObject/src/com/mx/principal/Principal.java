package com.mx.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Comestible;
import com.mx.entidad.Ropa;
import com.mx.entidad.Tienda;
import com.mx.services.Servicios;

public class Principal {

	public static void main(String[] args) {
		
		int numero, codigoPostal, codigoBarras, stock;
		String nombre, ciudad, empresa, nombreProducto, marca, pais, tipo, material;
		double precio;
		
		Scanner entrada;
		int indice, menu, menuTienda, menuComestible, menuRopa, menuTipo, submenuComestible, submenuRopa;
		Servicios servicios = new Servicios();
		Tienda tienda = new Tienda();
		Comestible comestible = new Comestible();
		Ropa ropa = new Ropa();
		
		do {
			System.out.println("\nMenú Principal");
			System.out.println("1.- Tiendas");
			System.out.println("2.- Comestibles");
			System.out.println("3.- Ropa");
			System.out.println("4.- Salir");
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				switch(menu) {
					case 1:
						do {
							System.out.println("\nMenú Tienda");
							System.out.println("1.- Alta");
							System.out.println("2.- Editar");
							System.out.println("3.- Buscar");
							System.out.println("4.- Eliminar");
							System.out.println("5.- Mostrar todas las tiendas");
							System.out.println("6.- Listar las tiendas");
							System.out.println("7.- Gestionar comestibles");
							System.out.println("8.- Gestionar ropa");
							System.out.println("9.- Mostrar ganancias totales");
							System.out.println("10.- Mostrar tienda con más ganancias");
							System.out.println("11.- Mostrar tienda con menos variedad de ropa");
							System.out.println("12.- Regresar al menú principal");
							
							entrada = new Scanner(System.in);
							menuTienda = entrada.nextInt();
							
							switch(menuTienda) {
								case 1:
									System.out.println("Ingresa el número");
									entrada = new Scanner(System.in);
									numero = entrada.nextInt();
									
									System.out.println("Ingresa el nombre");
									entrada = new Scanner(System.in);
									nombre = entrada.nextLine();
									
									System.out.println("Ingresa la ciudad");
									entrada = new Scanner(System.in);
									ciudad = entrada.nextLine();
									
									System.out.println("Ingresa la empresa");
									entrada = new Scanner(System.in);
									empresa = entrada.nextLine();
									
									System.out.println("Ingresa el código postal");
									entrada = new Scanner(System.in);
									codigoPostal = entrada.nextInt();
									
									tienda = new Tienda(numero, nombre, ciudad, empresa, codigoPostal, new ArrayList<Comestible>(), new ArrayList<Ropa>());
									servicios.guardar(tienda, "tienda");
									break;
								case 2:
									System.out.println("Ingrese el índice de la tienda a editar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									servicios.editar(null, indice, "tienda");
									break;
								case 3:
									System.out.println("Ingrese el índice de la tienda a buscar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									tienda = (Tienda) servicios.buscar(null, indice, "tienda");
									if(tienda == null) {
										System.out.println("La tienda que tratas de buscar no existe");
									} else {
										System.out.println("La tienda ha sido encontrada:\n" + tienda);
									}
									break;
								case 4:
									System.out.println("Ingrese el índice de la tienda a eliminar");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									servicios.eliminar(null, indice, "tienda");
									break;
								case 5:
									servicios.mostrar("tienda");
									break;
								case 6:
									servicios.listar("tienda");
									break;
								case 7:
									do {
										System.out.println("\nMenú gestionar comestibles");
										System.out.println("1.- Asignar");
										System.out.println("2.- Eliminar");
										System.out.println("3.- Regresar al menú tienda");
										entrada = new Scanner(System.in);
										submenuComestible = entrada.nextInt();
										switch(submenuComestible) {
											case 1:
												System.out.println("Ingrese el índice de la tienda a gestionar");
												entrada = new Scanner(System.in);
												indice = entrada.nextInt();
												tienda = (Tienda) servicios.buscar(null, indice, "tienda");
												if(tienda == null) {
													System.out.println("La tienda que tratas de gestionar no existe");
												} else {
													asignarConsumibles(servicios, tienda, tienda.getComestibles());
												}
												break;
											case 2:
												System.out.println("Ingrese el índice de la tienda a gestionar");
												entrada = new Scanner(System.in);
												indice = entrada.nextInt();
												tienda = (Tienda) servicios.buscar(null, indice, "tienda");
												if(tienda == null) {
													System.out.println("La tienda que tratas de gestionar no existe");
												} else {
													eliminarConsumibles(servicios, tienda, tienda.getComestibles());
												}
												break;
											case 3: 
												System.out.println("Regresando al menú consumibles...");
												break;
											default:
												System.out.println("Opción inválida, intente de nuevo");
												break;
										}
									} while(submenuComestible != 3);
									break;
								case 8:
									do {
										System.out.println("\nMenú gestionar ropa");
										System.out.println("1.- Asignar");
										System.out.println("2.- Eliminar");
										System.out.println("3.- Regresar al menú tienda");
										entrada = new Scanner(System.in);
										submenuComestible = entrada.nextInt();
										switch(submenuComestible) {
											case 1:
												System.out.println("Ingrese el índice de la tienda a gestionar");
												entrada = new Scanner(System.in);
												indice = entrada.nextInt();
												tienda = (Tienda) servicios.buscar(null, indice, "tienda");
												if(tienda == null) {
													System.out.println("La tienda que tratas de gestionar no existe");
												} else {
													asignarRopa(servicios, tienda, tienda.getRopa());
												}
												break;
											case 2:
												System.out.println("Ingrese el índice de la tienda a gestionar");
												entrada = new Scanner(System.in);
												indice = entrada.nextInt();
												tienda = (Tienda) servicios.buscar(null, indice, "tienda");
												if(tienda == null) {
													System.out.println("La tienda que tratas de gestionar no existe");
												} else {
													eliminarRopa(servicios, tienda, tienda.getRopa());
												}
												break;
											case 3: 
												System.out.println("Regresando al menú consumibles...");
												break;
											default:
												System.out.println("Opción inválida, intente de nuevo");
												break;
										}
									} while(submenuComestible != 3);
									break;
								case 9:
									System.out.println("Ingrese el índice de la tienda para calcular");
									entrada = new Scanner(System.in);
									indice = entrada.nextInt();
									tienda = (Tienda) servicios.buscar(null, indice, "tienda");
									if(tienda == null) {
										System.out.println("La tienda que tratas de seleccionar no existe");
									} else {
										double gananciaTotal = tienda.getGananciaTotal();										
										System.out.println("La ganacia total es: $" + gananciaTotal);
									}
									break;
								case 10:
									Tienda tiendaMasGanancia = (Tienda) servicios.getTiendaMasGanancia();
									if(tiendaMasGanancia == null) {
										System.out.println("No hay tiendas registradas o sus ganancias no son mayores a $0");
									} else {									
										System.out.println("La tienda con más ganacias es:\n" + tiendaMasGanancia);
										System.out.println("Su ganancia total es de: $" + tiendaMasGanancia.getGananciaTotal());
									}
									break;
								case 11:
									servicios.getTiendaMenosVariedadRopa();
									break;
								case 12:
									System.out.println("Regresando al menú principal...");
									break;
								default:
									System.out.println("Opción inválida, intente de nuevo");
									break;
							}
						} while(menuTienda != 12);
						break;
					case 2:
						do {
							System.out.println("\nMenú Comestibles");
							System.out.println("1.- Alta");
							System.out.println("2.- Editar");
							System.out.println("3.- Buscar");
							System.out.println("4.- Eliminar");
							System.out.println("5.- Mostrar todos los comestibles");
							System.out.println("6.- Listar los comestibles");
							System.out.println("7.- Mostrar el precio total de un comestible");
							System.out.println("8.- Mostrar la marca con más variedad de productos");
							System.out.println("9.- Regresar al menú principal");
							
							entrada = new Scanner(System.in);
							menuComestible = entrada.nextInt();
							
							switch(menuComestible) {
								case 1:
									System.out.println("Ingresa el código de barras");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									
									System.out.println("Ingresa el nombre");
									entrada = new Scanner(System.in);
									nombreProducto = entrada.nextLine();
									
									System.out.println("Ingresa la marca");
									entrada = new Scanner(System.in);
									marca = entrada.nextLine();
									
									System.out.println("Ingresa el precio");
									entrada = new Scanner(System.in);
									precio = entrada.nextDouble();
									
									System.out.println("Ingresa la cantidad de stock");
									entrada = new Scanner(System.in);
									stock = entrada.nextInt();
									
									System.out.println("Ingresa el país de origen");
									entrada = new Scanner(System.in);
									pais = entrada.nextLine();
									
									do {
										System.out.println("\nTipos disponibles");
										System.out.println("1.- Lácteo");
										System.out.println("2.- Frutas y verduras");
										System.out.println("3.- Carnes");
										System.out.println("4.- Botanas");
										System.out.println("5.- Dulces");
										System.out.println("Ingresa el tipo");
										entrada = new Scanner(System.in);
										menuTipo = entrada.nextInt();
										switch(menuTipo) {
											case 1:
												tipo = "Lácteo";
												break;
											case 2:
												tipo = "Frutas y verduras";
												break;
											case 3:
												tipo = "Carnes";
												break;
											case 4:
												tipo = "Botanas";
												break;
											case 5:
												tipo = "Dulces";
												break;
											default:
												System.out.println("Opción no válida, intente de nuevo");
												tipo = "Lácteo";
												break;
										}
									} while (menuTipo <= 0 || menuTipo > 5);
									
									comestible = new Comestible(codigoBarras, nombreProducto, marca, precio, stock, pais, tipo);
									servicios.guardar(comestible, "comestible");
									
									break;
								case 2:
									System.out.println("Ingrese el código de barras del comestible a editar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									comestible.setCodigoBarras(codigoBarras);
									servicios.editar(comestible, 0, "comestible");
									break;
								case 3:
									System.out.println("Ingrese el código de barras del comestible a buscar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									comestible.setCodigoBarras(codigoBarras);
									comestible = (Comestible) servicios.buscar(comestible, 0, "comestible");
									if(comestible == null) {
										System.out.println("El comestible que tratas de buscar no existe");
									} else {
										System.out.println("El comestible ha sido encontrado:\n" + comestible);
									}
									break;
								case 4:
									System.out.println("Ingrese el código de barras del comestible a eliminar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									comestible.setCodigoBarras(codigoBarras);
									servicios.eliminar(comestible, 0, "comestible");
									break;
								case 5:
									servicios.mostrar("comestible");
									break;
								case 6:
									servicios.listar("comestible");
									break;
								case 7:
									System.out.println("\n[0] => Salir");
									servicios.listar("comestible");
									System.out.println("\nIngrese el código de barras del comestible a seleccionar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									if(codigoBarras > 0) {
										comestible.setCodigoBarras(codigoBarras);
										comestible = (Comestible) servicios.buscar(comestible, 0, "comestible");
										if(comestible == null) {
											System.out.println("El comestible que tratas de seleccionar no existe");
										} else {
											System.out.println("\nComestible seleccionado: \n" + comestible);
											System.out.println("El precio total es: $" + comestible.precioTotal());
										}
									} else {
										System.out.println("Saliendo...");
									}
									break;
								case 8:
									servicios.getMarcaMasVariedad();
									break;
								case 9:
									System.out.println("Regresando al menú principal...");
									break;
								default:
									System.out.println("Opción inválida, intente de nuevo");
									break;
							}
						} while (menuComestible != 9);
						break;
					case 3:
						do {
							System.out.println("\nMenú Ropa");
							System.out.println("1.- Alta");
							System.out.println("2.- Editar");
							System.out.println("3.- Buscar");
							System.out.println("4.- Eliminar");
							System.out.println("5.- Mostrar toda la ropa");
							System.out.println("6.- Listar la ropa");
							System.out.println("7.- Mostrar el precio total de una ropa");
							System.out.println("8.- Regresar al menú principal");
							
							entrada = new Scanner(System.in);
							menuRopa = entrada.nextInt();
							switch(menuRopa) {
								case 1:
									System.out.println("Ingresa el código de barras");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									
									System.out.println("Ingresa el nombre");
									entrada = new Scanner(System.in);
									nombreProducto = entrada.nextLine();
									
									System.out.println("Ingresa la marca");
									entrada = new Scanner(System.in);
									marca = entrada.nextLine();
									
									System.out.println("Ingresa el precio");
									entrada = new Scanner(System.in);
									precio = entrada.nextDouble();
									
									System.out.println("Ingresa la cantidad de stock");
									entrada = new Scanner(System.in);
									stock = entrada.nextInt();
									
									System.out.println("Ingresa el país de origen");
									entrada = new Scanner(System.in);
									pais = entrada.nextLine();
									
									System.out.println("Ingresa el material");
									entrada = new Scanner(System.in);
									material = entrada.nextLine();
									
									ropa = new Ropa(codigoBarras, nombreProducto, marca, precio, stock, pais, material);
									servicios.guardar(ropa, "ropa");
									break;
								case 2:
									System.out.println("Ingrese el código de barras de la ropa a buscar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									ropa.setCodigoBarras(codigoBarras);
									servicios.editar(ropa, 0, "ropa");
									break;
								case 3:
									System.out.println("Ingrese el código de barras de la ropa a buscar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									ropa.setCodigoBarras(codigoBarras);
									ropa = (Ropa) servicios.buscar(ropa, 0, "ropa");
									if(ropa == null) {
										System.out.println("La ropa que tratas de buscar no existe");
									} else {
										System.out.println("La ropa ha sido encontrada:\n" + ropa);
									}
									break;
								case 4:
									System.out.println("Ingrese el código de barras de la ropa a buscar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									ropa.setCodigoBarras(codigoBarras);
									servicios.eliminar(ropa, 0, "ropa");
									break;
								case 5:
									servicios.mostrar("ropa");
									break;
								case 6:
									servicios.listar("ropa");
									break;
								case 7:
									System.out.println("\n[0] => Salir");
									servicios.listar("ropa");
									System.out.println("\nIngrese el código de barras de la ropa a seleccionar");
									entrada = new Scanner(System.in);
									codigoBarras = entrada.nextInt();
									if(codigoBarras > 0) {
										ropa.setCodigoBarras(codigoBarras);
										ropa = (Ropa) servicios.buscar(ropa, 0, "ropa");
										if(ropa == null) {
											System.out.println("La ropa que tratas de seleccionar no existe");
										} else {
											System.out.println("\nRopa seleccionada: \n" + ropa);
											System.out.println("El precio total es: $" + ropa.precioTotal());
										}
									} else {
										System.out.println("Saliendo...");
									}
									break;
								case 8:
									System.out.println("Regresando al menú principal...");
									break;
								default:
									System.out.println("Opción inválida, intente de nuevo");
									break;
							}
						} while (menuRopa != 8);
						break;
					case 4:
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción inválida, intente de nuevo");
						break;
				}
			} catch(Exception e) {
				menu = 5;
				for(StackTraceElement elemento : e.getStackTrace()) {
					System.out.println("\nClase: " + elemento.getClassName());
					System.out.println("Método: " + elemento.getMethodName());
					System.out.println("Línea: " + elemento.getLineNumber());
				}
			}
		} while(menu != 4);

	}
	
	private static void asignarConsumibles(Servicios servicios, Tienda tienda, List<Comestible> listaComestibles) {
		Scanner entrada;
		int codigoBarras;
		Comestible comestible = new Comestible();
		System.out.println("\n============= Comestibles =============");
		System.out.println("[0] => Salir");
		servicios.listar("comestible");
		System.out.println("\nIngrese el código de barras del comestible a asignar");
		entrada = new Scanner(System.in);
		codigoBarras = entrada.nextInt();
		if(codigoBarras > 0) {
			comestible.setCodigoBarras(codigoBarras);
			comestible = (Comestible) servicios.buscar(comestible, 0, "comestible");
			if(comestible == null) {
				System.out.println("El comestible que tratas de asignar no existe");
			} else {
				int bandera = 0;
				for(Comestible c : listaComestibles) {
					if(c.getCodigoBarras() == comestible.getCodigoBarras()) {
						System.out.println("El comestible ya fue asignado a la tienda");
						bandera = 1;
						break;
					}
				}
				if(bandera == 0) {
					listaComestibles.add(comestible);
					tienda.setComestibles(listaComestibles);
					System.out.println("El comestible fue asignado a la tienda correctamente");
				}
			}
			asignarConsumibles(servicios, tienda, listaComestibles);
		} else {
			System.out.println("Saliendo...");
		}
	}
	
	private static void eliminarConsumibles(Servicios servicios, Tienda tienda, List<Comestible> listaComestibles) {
		if(listaComestibles.isEmpty()) {
			System.out.println("\nNo hay consumibles para eliminar\n");
		} else {
			Scanner entrada;
			int codigoBarras;
			Comestible comestible = new Comestible();
			System.out.println("\n============= Comestibles =============");
			System.out.println("[0] => Salir");
			servicios.listar("comestible");
			System.out.println("\nIngrese el código de barras del comestible a eliminar");
			entrada = new Scanner(System.in);
			codigoBarras = entrada.nextInt();
			if(codigoBarras > 0) {
				comestible.setCodigoBarras(codigoBarras);
				comestible = (Comestible) servicios.buscar(comestible, 0, "comestible");
				if(comestible == null) {
					System.out.println("El comestible que tratas de eliminar no existe");
				} else {
					for(Comestible c : listaComestibles) {
						if(c.getCodigoBarras() == comestible.getCodigoBarras()) {
							listaComestibles.remove(comestible);
							tienda.setComestibles(listaComestibles);
							System.out.println("El comestible fue eliminado correctamente");
							break;
						}
					}
				}
				eliminarConsumibles(servicios, tienda, listaComestibles);
			} else {
				System.out.println("Saliendo...");
			}
		}
	}
	
	private static void asignarRopa(Servicios servicios, Tienda tienda, List<Ropa> listaRopa) {
		Scanner entrada;
		int codigoBarras;
		Ropa ropa = new Ropa();
		System.out.println("\n============= Ropa =============");
		System.out.println("[0] => Salir");
		servicios.listar("ropa");
		System.out.println("\nIngrese el código de barras de la ropa a asignar");
		entrada = new Scanner(System.in);
		codigoBarras = entrada.nextInt();
		if(codigoBarras > 0) {
			ropa.setCodigoBarras(codigoBarras);
			ropa = (Ropa) servicios.buscar(ropa, 0, "ropa");
			if(ropa == null) {
				System.out.println("La ropa que tratas de asignar no existe");
			} else {
				int bandera = 0;
				for(Ropa r : listaRopa) {
					if(r.getCodigoBarras() == ropa.getCodigoBarras()) {
						System.out.println("La ropa ya fue asignada a la tienda");
						bandera = 1;
						break;
					}
				}
				if(bandera == 0) {
					listaRopa.add(ropa);
					tienda.setRopa(listaRopa);
					System.out.println("La ropa fue asignada a la tienda correctamente");
				}
			}
			asignarRopa(servicios, tienda, listaRopa);
		} else {
			System.out.println("Saliendo...");
		}
	}
	
	private static void eliminarRopa(Servicios servicios, Tienda tienda, List<Ropa> listaRopa) {
		if(listaRopa.isEmpty()) {
			System.out.println("\nNo hay ropa para eliminar\n");
		} else {
			Scanner entrada;
			int codigoBarras;
			Ropa ropa = new Ropa();
			System.out.println("\n============= Ropa =============");
			System.out.println("[0] => Salir");
			servicios.listar("ropa");
			System.out.println("\nIngrese el código de barras de la ropa a eliminar");
			entrada = new Scanner(System.in);
			codigoBarras = entrada.nextInt();
			if(codigoBarras > 0) {
				ropa.setCodigoBarras(codigoBarras);
				ropa = (Ropa) servicios.buscar(ropa, 0, "ropa");
				if(ropa == null) {
					System.out.println("La ropa que tratas de eliminar no existe");
				} else {
					for(Ropa r : listaRopa) {
						if(r.getCodigoBarras() == ropa.getCodigoBarras()) {
							listaRopa.remove(ropa);
							tienda.setRopa(listaRopa);
							System.out.println("La ropa fue eliminada correctamente");
							break;
						}
					}
				}
				eliminarRopa(servicios, tienda, listaRopa);
			} else {
				System.out.println("Saliendo...");
			}
		}
	}
}
