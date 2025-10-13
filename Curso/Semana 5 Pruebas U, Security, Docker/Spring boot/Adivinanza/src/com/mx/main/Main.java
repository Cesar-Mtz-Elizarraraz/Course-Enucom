package com.mx.main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Main {
	static int intentos = 0;
	public static void main(String[] args) {

        int menu = 0;
		Scanner entrada = new Scanner(System.in);
        
        do {
			try {
				System.out.println("\n=================== A D I V I N A N Z A ===================");
				System.out.println("1. Iniciar Juego");
				System.out.println("2. Salir");
				System.out.print("\nIngresa que quieres hacer: ");
				menu = entrada.nextInt();
				entrada.nextLine();
				switch(menu) {
					case 1:
						Random random = new Random();
				        int numeroAleatorio = random.nextInt(100) + 1; // Genera número entre 1 y 100
				        intentos = 0;
						juegoAdivinanza(numeroAleatorio);
						break;
					case 2:
						System.out.println("\nSALIENDO DEL JUEGO...");
						break;
					default:
						System.out.println("\nOPCIÓN INVÁLIDA, INTENTE OTRA VEZ");
						break;
				}
			} catch (Exception e) {
				System.out.println("\nPOR FAVOR INGRESA UN NÚMERO VALIDO\n" + e);
				entrada.nextLine();
			}
		} while (menu != 2);

	}
	
	private static void juegoAdivinanza(int numeroAleatorio) {
		if(intentos == 10) {
			System.out.println("Lo siento, se acabaron los intentos. El número era: " + numeroAleatorio);
			return;
		}
		
		Scanner entrada = new Scanner(System.in);
		int numero;
		try {
			System.out.print("\nIngresa el número: ");
			numero = entrada.nextInt();
			entrada.nextLine();
			
			if(numero > numeroAleatorio || numero < numeroAleatorio) {
				System.out.println("El número es " + (numero > numeroAleatorio ? "mayor" : "menor"));
				intentos++;
				juegoAdivinanza(numeroAleatorio);
			} else {
				System.out.println("¡Felicidades, lo adivinaste en "+ intentos +" intentos!");
			}
			
			
		} catch (Exception e) {
			System.out.println("\nPOR FAVOR INGRESA UN NÚMERO VALIDO\n" + e);
			entrada.nextLine();
		}
	}

}
