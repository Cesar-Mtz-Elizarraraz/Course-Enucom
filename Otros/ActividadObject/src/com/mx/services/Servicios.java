package com.mx.services;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.mx.entidad.Comestible;
import com.mx.entidad.Ropa;
import com.mx.entidad.Tienda;
import com.mx.metodos.Metodos;

public class Servicios implements Metodos {
	HashMap<Integer, Comestible> hashComestibles = new HashMap<Integer, Comestible>(); 
	HashMap<Integer, Ropa> hashRopa = new HashMap<Integer, Ropa>(); 
	List<Tienda> listaTiendas = new ArrayList<Tienda>();

	@Override
	public void guardar(Object obj, String clase) {
		if("comestible".equals(clase)) {
			Comestible comestible = (Comestible)obj;
			if(hashComestibles.containsKey(comestible.getCodigoBarras())) {
				System.out.println("El comestible no se agrego porque ya existe el código de barras");
			} else {
				hashComestibles.put(comestible.getCodigoBarras(), comestible);
				System.out.println("El comestible ha sido registrado correctamente");
			}
		} else if("ropa".equals(clase)) {
			Ropa ropa = (Ropa)obj;
			if(hashRopa.containsKey(ropa.getCodigoBarras())) {
				System.out.println("La ropa no se agrego porque ya existe el código de barras");
			} else {
				hashRopa.put(ropa.getCodigoBarras(), ropa);
				System.out.println("La ropa ha sido registrado correctamente");
			}
		} else {
			Tienda tienda = (Tienda)obj;
			int bandera = 0;
			for(Tienda t : listaTiendas) {
				if(tienda.getNumero() == t.getNumero()) {
					System.out.println("La tienda no se agrego porque ya existe el número");
					bandera = 1;
					break;
				}
			}
			
			if(bandera == 0) {
				listaTiendas.add(tienda);
				System.out.println("La tienda ha sido registrada correctamente");
			}
		}
		
	}

	@Override
	public void editar(Object obj, int indice, String clase) {
		Scanner entrada;
		int menu, menuTipo;
		if("comestible".equals(clase)) {
			Comestible comestible = (Comestible)obj;
			if(hashComestibles.containsKey(comestible.getCodigoBarras())){
				comestible = hashComestibles.get(comestible.getCodigoBarras());
				if(comestible != null) {
					do {
						System.out.println("\nMenú editar comestible");
						System.out.println("1.- Nombre");
						System.out.println("2.- Marca");
						System.out.println("3.- Precio");
						System.out.println("4.- Stock");
						System.out.println("5.- País de origen");
						System.out.println("6.- Tipo");
						System.out.println("7.- Salir del menú editar");
						
						entrada = new Scanner(System.in);
						menu = entrada.nextInt();
						
						switch(menu) {
							case 1:
								System.out.println("Ingresa el nuevo nombre");
								entrada = new Scanner(System.in);
								String nombre = entrada.nextLine();
								comestible.setNombreProducto(nombre);
								break;
							case 2:
								System.out.println("Ingresa la nueva marca");
								entrada = new Scanner(System.in);
								String marca = entrada.nextLine();
								comestible.setMarca(marca);
								break;
							case 3:
								System.out.println("Ingresa el nuevo precio");
								entrada = new Scanner(System.in);
								double precio = entrada.nextDouble();
								comestible.setPrecio(precio);
								break;
							case 4:
								System.out.println("Ingresa la nueva cantidad de stock");
								entrada = new Scanner(System.in);
								int stock = entrada.nextInt();
								comestible.setStock(stock);
								break;
							case 5:
								System.out.println("Ingresa el nuevo país de origen");
								entrada = new Scanner(System.in);
								String pais = entrada.nextLine();
								comestible.setPais(pais);
								break;
							case 6:
								String tipo = "Lácteo";
								do {
									System.out.println("\nTipos disponibles");
									System.out.println("1.- Lácteo");
									System.out.println("2.- Frutas y verduras");
									System.out.println("3.- Carnes");
									System.out.println("4.- Botanas");
									System.out.println("5.- Dulces");
									System.out.println("Ingresa el nuevo tipo");
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
											break;
									}
								} while (menuTipo <= 0 || menuTipo > 5);
								comestible.setTipo(tipo);
								break;
							case 7:
								System.out.println("Saliendo del menú editar...");
								break;
							default:
								System.out.println("Opción inválida, intente de nuevo");
								break;
						}
						hashComestibles.put(comestible.getCodigoBarras(), comestible);
					} while(menu != 7);
				} else {
					System.out.println("El comestible que tratas de editar no existe");
				}
			}
		} else if("ropa".equals(clase)) {
			Ropa ropa = (Ropa)obj;
			if(hashRopa.containsKey(ropa.getCodigoBarras())){
				ropa = hashRopa.get(ropa.getCodigoBarras());
				if(ropa != null) {
					do {
						System.out.println("\nMenú editar ropa");
						System.out.println("1.- Nombre");
						System.out.println("2.- Marca");
						System.out.println("3.- Precio");
						System.out.println("4.- Stock");
						System.out.println("5.- País de origen");
						System.out.println("6.- Tipo");
						System.out.println("7.- Salir del menú editar");
						
						entrada = new Scanner(System.in);
						menu = entrada.nextInt();
						
						switch(menu) {
							case 1:
								System.out.println("Ingresa el nuevo nombre");
								entrada = new Scanner(System.in);
								String nombre = entrada.nextLine();
								ropa.setNombreProducto(nombre);
								break;
							case 2:
								System.out.println("Ingresa la nueva marca");
								entrada = new Scanner(System.in);
								String marca = entrada.nextLine();
								ropa.setMarca(marca);
								break;
							case 3:
								System.out.println("Ingresa el nuevo precio");
								entrada = new Scanner(System.in);
								double precio = entrada.nextDouble();
								ropa.setPrecio(precio);
								break;
							case 4:
								System.out.println("Ingresa la nueva cantidad de stock");
								entrada = new Scanner(System.in);
								int stock = entrada.nextInt();
								ropa.setStock(stock);
								break;
							case 5:
								System.out.println("Ingresa el nuevo país de origen");
								entrada = new Scanner(System.in);
								String pais = entrada.nextLine();
								ropa.setPais(pais);
								break;
							case 6:
								System.out.println("Ingresa el nuevo tipo");
								entrada = new Scanner(System.in);
								String material = entrada.nextLine();
								ropa.setMaterial(material);
								break;
							case 7:
								System.out.println("Saliendo del menú editar...");
								break;
							default:
								System.out.println("Opción inválida, intente de nuevo");
								break;
						}
						hashRopa.put(ropa.getCodigoBarras(), ropa);
					} while(menu != 7);
				} else {
					System.out.println("La ropa que tratas de editar no existe");
				}
			}
		} else {
			if(listaTiendas.size() <= indice) {
				System.out.println("La tienda que tratas de editar no existe");
			} else {
				Tienda tienda = listaTiendas.get(indice);
				do {
					System.out.println("\nMenú editar gerente");
					System.out.println("1.- Nombre");
					System.out.println("2.- Ciudad");
					System.out.println("3.- Empresa");
					System.out.println("4.- Código Postal");
					System.out.println("5.- Salir del menú editar");
					
					entrada = new Scanner(System.in);
					menu = entrada.nextInt();
					switch(menu) {
						case 1:
							System.out.println("Ingresa el nuevo nombre");
							entrada = new Scanner(System.in);
							String nombre = entrada.nextLine();
							tienda.setNombre(nombre);
							break;
						case 2:
							System.out.println("Ingresa la nueva ciudad");
							entrada = new Scanner(System.in);
							String ciudad = entrada.nextLine();
							tienda.setCiudad(ciudad);
							break;
						case 3:
							System.out.println("Ingresa la nueva empresa");
							entrada = new Scanner(System.in);
							String empresa = entrada.nextLine();
							tienda.setEmpresa(empresa);
							break;
						case 4:
							System.out.println("Ingresa el nuevo código postal");
							entrada = new Scanner(System.in);
							int codigoPostal = entrada.nextInt();
							tienda.setCodigoPostal(codigoPostal);
							break;
						case 5:
							System.out.println("Saliendo del menú editar...");
							break;
						default:
							System.out.println("Opción inválida, intente de nuevo");
							break;
					}
				} while(menu != 5);
			}
		}
		
	}

	@Override
	public void eliminar(Object obj, int indice, String clase) {
		if("comestible".equals(clase)) {
			Comestible comestible = (Comestible)obj;
			if(hashComestibles.containsKey(comestible.getCodigoBarras())) {
				hashComestibles.remove(comestible.getCodigoBarras());
				System.out.println("El siguiente comestible fue eliminado:\n" + comestible);
			} else {
				System.out.println("El comestible que tratas de eliminar no existe");
			}
		} else if("ropa".equals(clase)) {
			Ropa ropa = (Ropa)obj;
			if(hashRopa.containsKey(ropa.getCodigoBarras())) {
				hashRopa.remove(ropa.getCodigoBarras());
				System.out.println("La siguiente ropa fue eliminada:\n" + ropa);
			} else {
				System.out.println("La ropa que tratas de eliminar no existe");
			}
		} else {
			if(listaTiendas.size() <= indice) {
				System.out.println("La tienda que tratas de eliminar no existe");
			} else {
				Tienda tienda = listaTiendas.get(indice);
				listaTiendas.remove(indice);
				
				System.out.println("La siguiente tienda fue eliminada:\n" + tienda);
			}
		}
	}

	@Override
	public Object buscar(Object obj, int indice, String clase) {
		if("comestible".equals(clase)) {
			Comestible comestible = (Comestible)obj;
			if(hashComestibles.containsKey(comestible.getCodigoBarras())) {
				comestible = hashComestibles.get(comestible.getCodigoBarras());
				return comestible;
			}
		} else if("ropa".equals(clase)) {
			Ropa ropa = (Ropa)obj;
			if(hashRopa.containsKey(ropa.getCodigoBarras())) {
				ropa = hashRopa.get(ropa.getCodigoBarras());
				return ropa;
			}
		} else {
			if(indice < listaTiendas.size()) {
				Tienda tienda = listaTiendas.get(indice);
				return tienda;
			}
		}
		return null;
	}

	@Override
	public void mostrar(String clase) {
		if("comestible".equals(clase)) {
			if(hashComestibles.isEmpty()) {
				System.out.println("No hay comestibles que mostrar");
			} else {
				System.out.println("Comestibles:\n" + hashComestibles);
			}
		} else if("ropa".equals(clase)) {
			if(hashRopa.isEmpty()) {
				System.out.println("No hay ropa que mostrar");
			} else {
				System.out.println("Ropa:\n" + hashRopa);
			}
		} else {
			if(listaTiendas.isEmpty()) {
				System.out.println("No hay tiendas que mostrar");
			} else {
				System.out.println("Tiendas:\n" + listaTiendas);
			}
		}
	}
	
	public void listar(String clase) {
		if("comestible".equals(clase)) {
			if(hashComestibles.isEmpty()) {
				System.out.println("No hay comestibles que listar");
			} else {
				Comestible comestible;
				for(Integer key: hashComestibles.keySet()) {
					comestible = hashComestibles.get(key);
					System.out.println("[" + key + "] => " + comestible.getNombreProducto() + " " + comestible.getMarca());
				}
			}
		} else if("ropa".equals(clase)) {
			if(hashRopa.isEmpty()) {
				System.out.println("No hay ropa que listar");
			} else {
				Ropa ropa;
				for(Integer key: hashRopa.keySet()) {
					ropa = hashRopa.get(key);
					System.out.println("[" + key + "] => " + ropa.getNombreProducto() + " " + ropa.getMarca());
				}
			}
		} else {
			if(listaTiendas.isEmpty()) {
				System.out.println("No hay tiendas que listar");
			} else {
				for(Tienda t : listaTiendas) {
					System.out.println("[" + listaTiendas.indexOf(t) + "]" + t.getNumero() + " - " + t.getNombre());
				}
			}
		}
	}
	
	public Object getTiendaMasGanancia() {
		Tienda tiendaMasGanancia = null;
		for(Tienda t : listaTiendas) {
			if(tiendaMasGanancia == null) {
				tiendaMasGanancia = t;
			} else if(t.getGananciaTotal() > tiendaMasGanancia.getGananciaTotal()) {
				tiendaMasGanancia = t;
			}
		}
		if(tiendaMasGanancia == null) return null;
		
		return tiendaMasGanancia.getGananciaTotal() == 0 ? null : tiendaMasGanancia;
	}
	
	public void getMarcaMasVariedad() {
		if(!hashComestibles.isEmpty()) {
			Comestible comestible;
			HashMap<String, Integer> comestibleMarcas = new HashMap<String, Integer>(); 
			for(Integer key : hashComestibles.keySet()) {
				comestible = hashComestibles.get(key);
				String marca = comestible.getMarca();
				if(comestibleMarcas.containsKey(marca)) {
					int variedad = comestibleMarcas.get(marca) + 1;
					comestibleMarcas.replace(marca, variedad);
				} else {
					comestibleMarcas.put(marca, 1);
				}
			}
			
			String marcaMasVariedad = "";
			int cantidadVariedad = 0;
			for(String key : comestibleMarcas.keySet()) {
				int variedad = comestibleMarcas.get(key);
				if(marcaMasVariedad.isEmpty()) {
					marcaMasVariedad = key;
					cantidadVariedad = variedad;
				} else if(variedad > cantidadVariedad) {
					marcaMasVariedad = key;
					cantidadVariedad = variedad;
				}
			}
			
			System.out.println("Marca con más variedad: " + marcaMasVariedad);
			System.out.println("Cantidad de variedades: " + cantidadVariedad);
		} else {
			System.out.println("No hay comestibles registrados");
		}	
	}
	
	public void getTiendaMenosVariedadRopa() {
		if(!listaTiendas.isEmpty()) {
			Tienda tiendaMenosRopa = null;
			for(Tienda t : listaTiendas) {
				if(tiendaMenosRopa == null) {
					tiendaMenosRopa = t;
				} else {
					int cantidadVariedad = t.getRopa().size();
					if(cantidadVariedad < tiendaMenosRopa.getRopa().size()) {
						tiendaMenosRopa = t;
					}
				}
			}
			
			System.out.println("Tienda con menos variedad de ropa: " + tiendaMenosRopa);
			System.out.println("Cantidad de variedades: " + tiendaMenosRopa.getRopa().size());
		} else {
			System.out.println("No hay tiendas registradas");
		}	
	}
}
