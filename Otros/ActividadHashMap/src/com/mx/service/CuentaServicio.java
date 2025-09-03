package com.mx.service;

import java.util.HashMap;
import java.util.Scanner;

import com.mx.entidad.Cuenta;
import com.mx.metodos.MetodosCuenta;

public class CuentaServicio implements MetodosCuenta {
	HashMap<String, Cuenta> hashCuentas = new HashMap<String, Cuenta>();

	@Override
	public void guardar(Cuenta cuenta) {
		if(hashCuentas.containsKey(cuenta.getNumeroToString())) {
			System.out.println("Cuenta no registrada. El número ya se encuentra registrado");
		} else {
			hashCuentas.put(cuenta.getNumeroToString(), cuenta);
			System.out.println("La cuenta ha sido registrada correctamente");
		}
	}

	@Override
	public void editar(Cuenta cuenta) {
		Scanner entrada;
		int menu, menuTipo, menuEstatus;
		do {
			System.out.println("\nMenú editar cuenta");
			System.out.println("1.- Saldo");
			System.out.println("2.- Adeudo");
			System.out.println("3.- Tipo");
			System.out.println("4.- Banco");
			System.out.println("5.- Estatus");
			System.out.println("6.- Salir del menú editar");
			entrada = new Scanner(System.in);
			menu = entrada.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Ingresa el nuevo saldo");
				entrada = new Scanner(System.in);
				double saldo = entrada.nextDouble();
				cuenta.setSaldo(saldo);
				break;
			case 2:
				System.out.println("Ingresa el nuevo adeudo");
				entrada = new Scanner(System.in);
				double adeudo = entrada.nextDouble();
				cuenta.setAdeudo(adeudo);
				break;
			case 3:
				String tipo = "Nómina";
				do {
					System.out.println("\nTipos disponibles");
					System.out.println("1.- Nómina");
					System.out.println("2.- Ahorro");
					System.out.println("3.- Corriente");
					System.out.println("Ingresa el tipo");
					entrada = new Scanner(System.in);
					menuTipo = entrada.nextInt();
					switch(menuTipo) {
						case 1:
							tipo = "Nómina";
							break;
						case 2:
							tipo = "Ahorro";
							break;
						case 3:
							tipo = "Corriente";
							break;
						default:
							System.out.println("Opción no válida, intente de nuevo");
							break;
					}
				} while (menuTipo > 3);
				cuenta.setTipo(tipo);
				break;
			case 4:
				System.out.println("Ingresa el nuevo banco");
				entrada = new Scanner(System.in);
				String banco = entrada.nextLine();
				cuenta.setTipo(banco);
				break;
			case 5:
				String estatus = "Bloqueada";
				do {
					System.out.println("\nEstatus disponibles");
					System.out.println("1.- Bloqueada");
					System.out.println("2.- Inactiva");
					System.out.println("3.- Activa");
					System.out.println("Ingresa el estatus");
					entrada = new Scanner(System.in);
					menuEstatus = entrada.nextInt();
					switch(menuEstatus) {
						case 1:
							estatus = "Bloqueada";
							break;
						case 2:
							estatus = "Inactiva";
							break;
						case 3:
							estatus = "Activa";
							break;
						default:
							System.out.println("Opción no válida, intente de nuevo");
							break;
					}
				} while (menuEstatus > 3);
				cuenta.setEstatus(estatus);
				break;
			case 6:
				System.out.println("Saliendo del menú editar...");
				break;
			default:
				System.out.println("Opción inválida, intenta de nuevo");
				break;
			}
			hashCuentas.put(cuenta.getNumeroToString(), cuenta);
		} while (menu != 6);
		
	}

	@Override
	public void eliminar(Cuenta cuenta) {
		String numero = cuenta.getNumeroToString();
		if(hashCuentas.containsKey(numero)){
	        // cuenta = hashCuentas.get(numero);	
	        hashCuentas.remove(numero);
	        System.out.println("La siguiente cuenta fue eliminada:\n" + cuenta);
	    } else {
	        System.out.println("La cuenta a eliminar no existe");
	    }
		
	}

	@Override
	public Cuenta buscar(Cuenta cuenta) {
		String numero = cuenta.getNumeroToString();
		if(hashCuentas.containsKey(numero)){
	        cuenta = hashCuentas.get(numero);
	        return cuenta;
		}
		return null;
	}

	@Override
	public void mostrar() {
		if(hashCuentas.isEmpty()) {
		    System.out.println("No hay cuentas para mostrar");	
		} else {
		    System.out.println(hashCuentas);
		}
	}	
	
	public HashMap<String, Cuenta> obtenerLista() {
	    if(!hashCuentas.isEmpty()) {
	        return hashCuentas;
	    } 
	    return null;
	}
	
	public void listar() {
	    if(hashCuentas.size() == 0) {
	        System.out.println("No hay cuentas para listar");	
	    } else {
	       Cuenta cuenta;
	       for(String key: hashCuentas.keySet()) {
	           cuenta = hashCuentas.get(key);
	           System.out.println("["+key+"]=>" + cuenta.getNumero() + " " + cuenta.getBanco());
	       }
	    }
	}
	
	public void mostrarCuentaMenorSaldo() {
	    if(hashCuentas.size() == 0) {
	        System.out.println("No hay cuentas registradas");	
	    } else {
	       Cuenta cuenta, cuentaMenorSaldo = null;
	       for(String key: hashCuentas.keySet()) {
	           cuenta = hashCuentas.get(key);
	           if(cuentaMenorSaldo == null) {
	        	   cuentaMenorSaldo = cuenta;
	           } else if(cuenta.getSaldo() < cuentaMenorSaldo.getSaldo()) {
	        	   cuentaMenorSaldo = cuenta; 
	           }
	       }
	       
	       System.out.println("La cuenta con menor saldo es:\n" + cuentaMenorSaldo);
	    }
	}

}
