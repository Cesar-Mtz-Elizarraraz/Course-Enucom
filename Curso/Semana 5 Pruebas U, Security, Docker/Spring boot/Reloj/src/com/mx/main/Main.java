package com.mx.main;

import java.util.Scanner;

import com.mx.service.RelojService;

public class Main {

	public static void main(String[] args) {
		int menu = 0;
		Scanner entrada = new Scanner(System.in);
		RelojService service = new RelojService();
        
        do {
			try {
				System.out.println("\n=================== M E N Ú ===================");
				System.out.println("1. Avanzar segundo");
				System.out.println("2. Mostrar hora");
				System.out.println("3. Salir");
				System.out.print("\nIngresa que quieres hacer: ");
				menu = entrada.nextInt();
				entrada.nextLine();
				switch(menu) {
					case 1:
						service.avanzarSegundo();
						break;
					case 2:
						System.out.println("\nHORA: " + service.mostrarHora());
						break;
					case 3:
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
		} while (menu != 3);

	}

}
