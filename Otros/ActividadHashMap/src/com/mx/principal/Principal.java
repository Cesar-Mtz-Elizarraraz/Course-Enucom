package com.mx.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Cliente;
import com.mx.entidad.Cuenta;
import com.mx.service.ClienteServicio;
import com.mx.service.CuentaServicio;

public class Principal {
	public static void main(String[] args) {
		
		int menu;
		Scanner entrada;
		Cuenta cuenta = new Cuenta();
		Cliente cliente = new Cliente();
		ClienteServicio clienteServicio = new ClienteServicio();
		CuentaServicio cuentaServicio = new CuentaServicio();
		
		do {
			System.out.println("\nMenú principal");
			System.out.println("1.- Clientes");
			System.out.println("2.- Cuentas");
			System.out.println("3.- Salir");
			
			try{
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				switch(menu){
					case 1: 
						menuClientes(cliente, cuentaServicio, clienteServicio);
						break;
					case 2: 
						menuCuentas(cuenta, cuentaServicio);
						break;
					case 3:
						System.out.println("Saliendo del programa...");
						break;
					default:
						System.out.println("Opción inválida, intenta de nuevo");
						break;
				}
			} catch (Exception e) {
				menu = 4;
				System.out.println("Error durante la ejecución\n");
				for(StackTraceElement element : e.getStackTrace()) {
				    System.out.println("\nClase: " + element.getClassName());
				    System.out.println("Metodo: " + element.getMethodName());
				    System.out.println("Archivo: " + element.getFileName());
				    System.out.println("Linea: " + element.getLineNumber());
				}
			}
			
		} while(menu != 3);
	}
	
	public static void menuClientes(Cliente cliente, CuentaServicio cuentaServicio, ClienteServicio clienteServicio) {
		Scanner entrada;
		int menuCliente, edad, indice;
		String curp, nombre, apellido, genero, ciudad, estadoCivil;
		
		do {
			System.out.println("\nMenú clientes");
			System.out.println("1.- Alta");
			System.out.println("2.- Editar");
			System.out.println("3.- Buscar");
			System.out.println("4.- Eliminar");
			System.out.println("5.- Mostrar todos los clientes");
			System.out.println("6.- Listar clientes por índice");
			System.out.println("7.- Buscar clientes por ciudad");
			System.out.println("8.- Cambiar cuenta");
			System.out.println("9.- Regresar al menú principal");
			entrada = new Scanner(System.in);
			menuCliente = entrada.nextInt();
			switch (menuCliente) {
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
				
				System.out.println("Ingresa el estado civil");
				entrada = new Scanner(System.in);
				estadoCivil = entrada.nextLine();
				
				cliente = new Cliente(curp, nombre, apellido, edad, genero, ciudad, estadoCivil, new ArrayList<Cuenta>());
				clienteServicio.guardar(cliente);
				break;
			case 2:
				System.out.println("Ingrese el índice del cliente a editar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				cliente = clienteServicio.buscar(indice);
				if(cliente == null) {
					System.out.println("El cliente a editar no existe");
				} else {
				    clienteServicio.editar(cliente, cuentaServicio, indice);
				}
				break;
			case 3:
				System.out.println("Ingrese el índice del cliente a buscar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				cliente = clienteServicio.buscar(indice);
				if(cliente == null) {
					System.out.println("El cliente no fue encontrado");
				} else {
					System.out.println("EL cliente ha sido encontrado:\n" + cliente);
				}
				break;
			case 4:
				System.out.println("Ingresa el índice del cliente a eliminar");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				clienteServicio.eliminar(indice);
				break;
			case 5:
				clienteServicio.mostrar();
				break;
			case 6:
				clienteServicio.listar();
				break;
			case 7:
				System.out.println("Ingresa la ciudad");
				entrada = new Scanner(System.in);
				ciudad = entrada.nextLine();
				clienteServicio.listarPorCiudad(ciudad);
				break;
			case 8:
				System.out.println("Ingresa el índice del cliente para mover la cuenta");
				entrada = new Scanner(System.in);
				indice = entrada.nextInt();
				clienteServicio.cambiarCuenta(indice);
				break;
			case 9:
				System.out.println("Regresando al menú principal...");
				break;
			default:
				System.out.println("Opción inválida, intenta de nuevo");
				break;
			}
		} while (menuCliente != 9);
	}
	
	public static void menuCuentas(Cuenta cuenta, CuentaServicio cuentaServicio) {
		Scanner entrada;
		int menuCuenta, menuTipo, menuEstatus, numero;
		double saldo, adeudo;
		String tipo, banco, estatus;
		
		do {
			System.out.println("\nMenú cuentas");
			System.out.println("1.- Alta");
			System.out.println("2.- Editar");
			System.out.println("3.- Buscar");
			System.out.println("4.- Eliminar");
			System.out.println("5.- Mostrar todas las cuentas");
			System.out.println("6.- Listar cuentas por número");
			System.out.println("7.- Mostrar cuenta con menor saldo");
			System.out.println("8.- Regresar al menú principal");
			entrada = new Scanner(System.in);
			menuCuenta = entrada.nextInt();
			switch (menuCuenta) {
			case 1:
				System.out.println("Ingresa el número");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				
				System.out.println("Ingresa el saldo");
				entrada = new Scanner(System.in);
				saldo = entrada.nextDouble();
				
				System.out.println("Ingresa el adeudo");
				entrada = new Scanner(System.in);
				adeudo = entrada.nextDouble();
				
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
							tipo = "Nómina";
							break;
					}
				} while (menuTipo > 3);
				
				System.out.println("Ingresa el banco");
				entrada = new Scanner(System.in);
				banco = entrada.nextLine();
				
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
							estatus = "Bloqueada";
							break;
					}
				} while (menuEstatus > 3);
				
				cuenta = new Cuenta(numero, saldo, adeudo, tipo, banco, estatus);
				cuentaServicio.guardar(cuenta);
				break;
			case 2:
				System.out.println("Ingrese el número de la cuenta a editar");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				cuenta = new Cuenta(numero);
				cuenta = cuentaServicio.buscar(cuenta);
				if(cuenta == null) {
					System.out.println("La cuenta a editar no existe");
				} else {
					cuentaServicio.editar(cuenta);
				}
				break;
			case 3:
				System.out.println("Ingrese el número de la cuenta a buscar");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				cuenta = new Cuenta(numero);
				cuenta = cuentaServicio.buscar(cuenta);
				if(cuenta == null) {
					System.out.println("La cuenta no ha sido encontrada");
				} else {
					 System.out.println("La cuenta ha sido encontrada:\n" + cuenta);
				}
				break;
			case 4:
				System.out.println("Ingresa el número de la cuenta a eliminar");
				entrada = new Scanner(System.in);
				numero = entrada.nextInt();
				cuenta.setNumero(numero);
				cuentaServicio.eliminar(cuenta);
				break;
			case 5:
				cuentaServicio.mostrar();
				break;
			case 6:
				cuentaServicio.listar();
				break;
			case 7:
				cuentaServicio.mostrarCuentaMenorSaldo();
				break;
			case 8:
				System.out.println("Regresando al menú principal...");
				break;
			default:
				System.out.println("Opción inválida, intenta de nuevo");
				break;
			}
		} while (menuCuenta != 8);
	}
}
