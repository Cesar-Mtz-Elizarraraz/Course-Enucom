package com.mx.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Cliente;
import com.mx.entidad.Cuenta;
import com.mx.metodos.MetodosCliente;

public class ClienteServicio implements MetodosCliente {
	List<Cliente> listaClientes = new ArrayList<Cliente>();

	@Override
	public void guardar(Cliente cliente) {
		boolean bandera = false;
		for(Cliente c : listaClientes) {
			if(c.getCurp().equalsIgnoreCase(cliente.getCurp())) {
				System.out.println("El cliente ya se encuentra registrado");
				bandera = true;
				break;
			}
		}
		
		if(!bandera) {
			System.out.println("El cliente ha sido registrado correctamente");
			listaClientes.add(cliente);
		}
	}

	@Override
	public void editar(Cliente cliente, CuentaServicio cuentaServicio, int indice) {
		Scanner entrada;
	    int menu, submenu;
	    do {
		    System.out.println("\nMenú editar cliente");
		    System.out.println("1.- Nombre");
		    System.out.println("2.- Apellido");
		    System.out.println("3.- Edad");
		    System.out.println("4.- Género");
		    System.out.println("5.- Ciudad");
		    System.out.println("6.- Estado Civil");
		    System.out.println("7.- Cuentas");
		    System.out.println("8.- Salir del menú editar");
		    entrada = new Scanner(System.in);
		    menu = entrada.nextInt();
		    switch (menu) {
			case 1:
				System.out.println("Ingresa el nuevo nombre");
				entrada = new Scanner(System.in);
				String nombre = entrada.nextLine();
				cliente.setNombre(nombre);
				break;
			case 2:
				System.out.println("Ingresa el nuevo apellido");
				entrada = new Scanner(System.in);
				String apellido = entrada.nextLine();
				cliente.setApellido(apellido);
				break;
			case 3:
				System.out.println("Ingresa la nueva edad");
				entrada = new Scanner(System.in);
				int edad = entrada.nextInt();
				cliente.setEdad(edad);
				break;
			case 4:
				System.out.println("Ingresa el nuevo género");
				entrada = new Scanner(System.in);
				String genero = entrada.nextLine();
				cliente.setGenero(genero);
				break;
			case 5:
				System.out.println("Ingresa la nueva ciudad");
				entrada = new Scanner(System.in);
				String ciudad = entrada.nextLine();
				cliente.setCiudad(ciudad);
				break;
			case 6:
				System.out.println("Ingresa el nuevo estado civil");
				entrada = new Scanner(System.in);
				String estadoCivil = entrada.nextLine();
				cliente.setEstadoCivil(estadoCivil);
				break;
			case 7:
				HashMap<String, Cuenta> hashCuentas = cuentaServicio.obtenerLista();
				if(hashCuentas.isEmpty()) {
				    System.out.println("No hay cuentas registradas");    	
				} else {
					int menuCuentas;
					do {
						List<Cuenta> cuentas = cliente.getCuentas();
						System.out.println("1.- Asignar cuenta");
						System.out.println("2.- Eliminar cuenta");
						System.out.println("3.- Regresar al menú");
						entrada = new Scanner(System.in);
						menuCuentas = entrada.nextInt();
						switch (menuCuentas) {
							case 1:
								do {
									Cuenta cuenta;
									System.out.println("\n[0] => Salir");
									for(String key: hashCuentas.keySet()) {
								        cuenta = hashCuentas.get(key);
								        System.out.println("["+key+"] => " + cuenta.getNumero() + " " + cuenta.getBanco());
								    }
								    System.out.println("\nIngresa el número de la cuenta a asignar");
									entrada = new Scanner(System.in);
									submenu = entrada.nextInt();
									if(submenu == 0) {
										System.out.println("Terminando la asignación");
									} else {
										String numero = Integer.toString(submenu);
										if(hashCuentas.containsKey(numero)){
									        cuenta = hashCuentas.get(numero);
										    int bandera = 0;
											for(Cuenta c: cuentas) {
											    if(c.getNumero() == cuenta.getNumero()) {
											        System.out.println("La cuenta ya fue asignada al cliente");
											        bandera = 1;
											        break;
											    }
											}
											if(bandera == 0) {
											    cuentas.add(cuenta);
											    System.out.println("La cuenta ha sido asignada al cliente correctamente");
											}
										} else {
										    System.out.println("El índice proporcionado no existe");
										}
									}
								} while(submenu != 0);
								cliente.setCuentas(cuentas);
								break;
							case 2:
								do {
									if(cuentas.isEmpty()) {
										System.out.println("No se tienen cuentas asignadas");
										submenu = 0;
									} else {
										System.out.println("\n[0] => Salir");
										int i = 0;
										for(Cuenta c: cuentas) {
									        System.out.println("["+(i + 1)+"] => " + c.getNumero() + " " + c.getBanco());
									        i++;
									    }
									    System.out.println("\nIngresa el índice de la cuenta a eliminar");
										entrada = new Scanner(System.in);
										submenu = entrada.nextInt();
										if(submenu == 0) {
											System.out.println("Terminando la eliminación");
										} else {
											int index = submenu - 1;
											if(cuentas.size() > index){
										        cuentas.remove(index);
											} else {
											    System.out.println("El índice proporcionado no existe");
											}
										}
									}
								} while(submenu != 0);
								
								cliente.setCuentas(cuentas);
								break;
							case 3:
								System.out.println("Regresando...");
								break;
							default:
								System.out.println("Opción inválida, intenta de nuevo");
								break;
						}
					} while(menuCuentas != 3);
					
					
					
				}
				
				break;
			case 8:
				System.out.println("Saliendo del menú editar...");
				break;
			default:
				System.out.println("Opción inválida, intenta de nuevo");
				break;
			}
		    listaClientes.set(indice, cliente);
		} while (menu != 8);
	}

	@Override
	public void eliminar(int indice) {
		if(listaClientes.size() > indice) {
			Cliente cliente = listaClientes.get(indice);
			listaClientes.remove(indice);
			System.out.println("El siguiente cliente fue eliminado:\n" + cliente);
		} else {
			System.out.println("El índice ingresado no existe");
		}
	}

	@Override
	public Cliente buscar(int indice) {
		if(listaClientes.size() > indice) {
			Cliente cliente = listaClientes.get(indice);
			return cliente;
		}
		return null;
	}

	@Override
	public void mostrar() {
		if(listaClientes.isEmpty()) {
		    System.out.println("No hay clientes para mostrar");
		} else {
		    System.out.println(listaClientes);
		}	
		
	}
	
	public void listar() {
		if(listaClientes.isEmpty()) {
		    System.out.println("No hay clientes para listar");
		} else {
			int index = 0;
			for(Cliente cliente : listaClientes) {
				System.out.println("[" + index + "] => " + cliente.getNombre() + " " + cliente.getApellido());
				index++;
			}
		}	
	}
	
	public void listarPorCiudad(String ciudad) {
	    if(listaClientes.isEmpty()) {
	        System.out.println("No hay clientes registrados");	
	    } else {
	       boolean bandera = false;
	       for(Cliente cliente : listaClientes) {
	    	   if(cliente.getCiudad().equalsIgnoreCase(ciudad)) {
	    		   if(!bandera) System.out.println("Los clientes viviendo en la ciudad " + ciudad);
	    		   System.out.println(cliente);
	    		   bandera = true;
	    	   }
			}
	       if(!bandera) System.out.println("No se encontraron cliente viviendo en la ciudad " + ciudad);
	    }
	}
	
	public void cambiarCuenta(int indice) {
		if(listaClientes.size() > indice) {
			int menu, submenu;
			Scanner entrada;
			Cliente cliente = listaClientes.get(indice);
			Cuenta cuenta;
			List<Cuenta> cuentas = cliente.getCuentas();
			List<Cuenta> cuentaReasignada = new ArrayList<Cuenta>();
			if(cuentas.isEmpty()) {
				System.out.println("Sin cuentas disponibles");
			} else {
				if(cuentas.isEmpty()) {
					System.out.println("No se tienen cuentas asignadas");
					menu = 0;
				} else {
					System.out.println("\n[0] => Salir");
					int i = 0;
					for(Cuenta c: cuentas) {
				        System.out.println("["+(i + 1)+"] => " + c.getNumero() + " " + c.getBanco());
				        i++;
				    }
				    System.out.println("\nIngresa el índice de la cuenta a cambiar");
					entrada = new Scanner(System.in);
					menu = entrada.nextInt();
					if(menu == 0) {
						System.out.println("Saliendo...");
					} else {
						int index = menu - 1;
						if(cuentas.size() > index){
							cuenta = cuentas.get(index);
					        cuentas.remove(index);
					        cuentaReasignada.add(cuenta);
					        
					        for(Cliente c : listaClientes) {
								System.out.println("[" + index + "] => " + c.getNombre() + " " + c.getApellido());
								index++;
							}
					        
					        do {
					        	entrada = new Scanner(System.in);
					        	submenu = entrada.nextInt();
					        	
					        	if(submenu < listaClientes.size()) {
					        		Cliente nuevoCliente = listaClientes.get(submenu);
					        		nuevoCliente.setCuentas(cuentaReasignada);
					        		System.out.println("Cuenta reasignada correctamente");
					        	} else {
					        		System.out.println("El índice ingresado no existe");
					        	}
					        } while(submenu > listaClientes.size());
					        
						} else {
						    System.out.println("El índice proporcionado no existe");
						}
					}
				}
			}
			
		} else {
			System.out.println("El índice ingresado no existe");
		}
	}
	
}
