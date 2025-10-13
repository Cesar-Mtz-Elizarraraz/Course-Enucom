package com.mx.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Actividades {
	public static void main(String[] args) {
		int menu = 0;
		
		Scanner entrada = new Scanner(System.in);
		
		do {
			try {
				System.out.println("\n=================== M E N Ú ===================");
				System.out.println("1. Números pares e impares");
				System.out.println("2. Palíndromo");
				System.out.println("3. Tabla de multiplicar");
				System.out.println("4. Números primos");
				System.out.println("5. Serie Fibonacci");
				System.out.println("6. Ordenar Números");
				System.out.println("7. Salir");
				System.out.print("\nIngresa que quieres hacer: ");
				menu = entrada.nextInt();
				entrada.nextLine();
				switch(menu) {
					case 1:
						System.out.println("\n************* Números pares e impares *************");
						System.out.print("\nIngresa un número entero: ");
						int numeroPI = entrada.nextInt();
						entrada.nextLine();
						int contadorP = 0;
						int contadorI = 0;
						for(int i = 1; i <= numeroPI; i++) {
							System.out.print(i + " " + (i % 10 == 0 ? "\n" : ""));
							if(i % 2 == 0) {
								contadorP++;
							} else {
								contadorI++;
							}
						}
						
						System.out.println("\nNúmeros pares: " + contadorP + "\nNúmeros impares: " + contadorI);
						
						break;
					case 2:
						System.out.println("\n************* Palíndromo *************");
						System.out.print("\nIngresa una palabra: ");
						String palabra = entrada.nextLine();
						String palabraReversa = "";
						for(int i = palabra.length(); i > 0; i--) {
							palabraReversa += palabra.charAt(i - 1);
						}
						
						System.out.println(palabraReversa.equalsIgnoreCase(palabra) ? "Es palíndromo" : "No es palíndromo");
						
						break;
					case 3:
						System.out.println("\n************* Tabla de multiplicar *************");
						System.out.print("\nIngresa el número de la tabla: ");
						double tablaMultiplicar = entrada.nextDouble();
						entrada.nextLine();
						for(int i = 1; i <= 10; i++) {
							System.out.println(i + " x " + tablaMultiplicar + " = " + (i * tablaMultiplicar));
						}
						break;
					case 4:
						System.out.println("\n************* Números primos *************");
						System.out.print("\nIngresa un número entero: ");
						int numeroPrimo = entrada.nextInt();
						entrada.nextLine();
						System.out.println(esPrimo(numeroPrimo) ? "Es primo" : "No es primo");
						break;
					case 5:
						System.out.println("\n************* Serie Fibonacci *************");
						System.out.print("Ingresa la cantidad de números fibonacci: ");
				        int cantidadFibonnaci = entrada.nextInt();
				        entrada.nextLine();

				        int a = 0, b = 1;

				        System.out.print("\nSerie Fibonacci: \n");
				        for (int i = 1; i <= cantidadFibonnaci; i++) {
				            System.out.print(a + " " + (i % 10 == 0 ? "\n" : ""));
				            int siguiente = a + b;
				            a = b;
				            b = siguiente;
				        }
						break;
					case 6:
						System.out.println("\n************* Ordenar números *************\n");
						List<Integer> listaNumeros = new ArrayList<Integer>();
						for(int i = 1; i <= 5; i++) {
							System.out.print("Ingresa el dígito entero #" + i + ": ");
							int numero = entrada.nextInt();
							listaNumeros.add(numero);
						}
						entrada.nextLine();
						// Comparator, compara las cantidades y las ordena de menor a mayor dentro de la misma lista
						listaNumeros.sort(Comparator.naturalOrder());
						System.out.println("\nNúmeros ordenados: " + listaNumeros);
						break;
					case 7:
						System.out.println("\nSALIENDO DEL PROGRAMA...");
						break;
					default:
						System.out.println("\nOPCIÓN INVÁLIDA, INTENTE OTRA VEZ");
						break;
				}
			} catch (Exception e) {
				System.out.println("\nPOR FAVOR INGRESA UN NÚMERO VALIDO");
				entrada.nextLine();
			}
		} while (menu != 7);

	}
		
		
	
	public static boolean esPrimo(int n) {
        if (n <= 1) return false;  // Números <= 1 no son primos
        if (n == 2) return true;   // 2 es el único número par primo
        if (n % 2 == 0) return false;  // Pares > 2 no son primos

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
