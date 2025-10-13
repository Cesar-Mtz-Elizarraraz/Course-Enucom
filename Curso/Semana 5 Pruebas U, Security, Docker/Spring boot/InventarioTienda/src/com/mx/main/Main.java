package com.mx.main;

import java.util.List;
import java.util.Scanner;

import com.mx.entity.Producto;
import com.mx.service.TiendaServiceImp;

public class Main {

	public static void main(String[] args) {
		int menu = 0, cantidad;
		Scanner entrada = new Scanner(System.in);
		String nombre;
		double precio;
		
		TiendaServiceImp service = new TiendaServiceImp();
		
		do {
			try {
				Producto producto = new Producto();
				System.out.println("\n=================== M E N Ú ===================");
				System.out.println("1. Agregar producto");
				System.out.println("2. Vender Producto");
				System.out.println("3. Mostrar bajo stock");
				System.out.println("4. Calcular valor total");
				System.out.println("5. Salir");
				System.out.print("\nIngresa que quieres hacer: ");
				menu = entrada.nextInt();
				entrada.nextLine();
				switch(menu) {
					case 1:
						System.out.println("\n************* Agregar producto *************");
						System.out.print("\nIngresa el nombre: ");
						nombre = entrada.nextLine();
						System.out.print("Ingresa el precio: ");
						precio = entrada.nextDouble();
						entrada.nextLine();
						System.out.print("Ingresa la cantidad: ");
						cantidad = entrada.nextInt();
						entrada.nextLine();
						
						producto.setNombre(nombre);
						producto.setPrecio(precio);
						producto.setCantidad(cantidad);
						service.agregarProducto(producto);
						break;
					case 2:
						System.out.println("\n************* Vender producto *************");
						System.out.print("\nIngresa el nombre: ");
						nombre = entrada.nextLine();
						System.out.print("Ingresa la cantidad: ");
						cantidad = entrada.nextInt();
						entrada.nextLine();
						service.venderProducto(nombre, cantidad);
						break;
					case 3:
						System.out.println("\n************* Mostrar bajo stock *************");
						List<Producto> productosBajoStock = service.mostrarBajoStock();
						System.out.println(productosBajoStock.isEmpty() ? "Sin productos con bajo stock" : productosBajoStock);
						break;
					case 4:
						System.out.println("\n************* Calcular valor total *************");
						System.out.print("\nEl valor total es de $" + service.calcularValorTotal());
						break;
					case 5:
						System.out.println("\nSALIENDO DEL PROGRAMA...");
						break;
					default:
						System.out.println("\nOPCIÓN INVÁLIDA, INTENTE OTRA VEZ");
						break;
				}
			} catch (Exception e) {
				System.out.println("\nPOR FAVOR INGRESA UN NÚMERO VALIDO\n" + e);
				entrada.nextLine();
			}
		} while (menu != 5);

	}

}
