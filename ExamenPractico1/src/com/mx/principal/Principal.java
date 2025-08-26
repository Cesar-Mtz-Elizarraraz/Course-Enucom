package com.mx.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mx.entidad.Serie;
import com.mx.entidad.Videojuego;

public class Principal {
	public static void main(String[] args) {
		List<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();
		List<Serie> listaSeries = new ArrayList<Serie>();
		
		Videojuego videojuego0 = new Videojuego("Crash Bandicoot", "Plataforma", 100, "Naughty Dog");
		Videojuego videojuego1 = new Videojuego("HALO", 128);
		Videojuego videojuego2 = new Videojuego("Forza Horizon", "Carreras", 80, "Playground Games");
		Videojuego videojuego3 = new Videojuego("FOREST", 99);
		Videojuego videojuego4 = new Videojuego("God Of War", "Plataforma", 120, "SAnta Monica");
		
		Serie serie0 = new Serie("Stranger Things", "Ciencia ficción", 5, "Ross Duffer");
		Serie serie1 = new Serie("Un show más", "J.G. Quintel");
		Serie serie2 = new Serie();
		Serie serie3 = new Serie("Hora de Aventura", "Pendleton Ward.");
		Serie serie4 = new Serie("The boys", "Drama", 4, "Eric Kripke");
		
		listaVideojuegos.add(videojuego0);
		listaVideojuegos.add(videojuego1);
		listaVideojuegos.add(videojuego2);
		listaVideojuegos.add(videojuego3);
		listaVideojuegos.add(videojuego4);
		
		listaSeries.add(serie0);
		listaSeries.add(serie1);
		listaSeries.add(serie2);
		listaSeries.add(serie3);
		listaSeries.add(serie4);
		
		int menu;
		Scanner entrada;
		
		do {
			System.out.println("\nMenú principal");
			System.out.println("1.- Videojuegos");
			System.out.println("2.- Series");
			System.out.println("3.- Salir");
			
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				
				switch(menu){
					case 1:
						menuVideojuegos(listaVideojuegos);
						break;
					case 2:
						menuSeries(listaSeries);
						break;
					case 3:
						System.out.println("\nSaliendo...");
						break;
					default:
						System.out.println("\nOpción inválida, intente de nuevo");
						break;
				}
			} catch(Exception e) {
				menu = 6;
				for(StackTraceElement elemento : e.getStackTrace()) {
					System.out.println("\nClase: " + elemento.getClassName());
					System.out.println("Método: " + elemento.getMethodName());
					System.out.println("Línea: " + elemento.getLineNumber());
				}
			}
		} while (menu != 3);
	}
	
	private static void menuVideojuegos(List<Videojuego> listaVideojuegos) {
		int menu, indice;
		Scanner entrada;
		Videojuego videojuego;
		do {
			System.out.println("\nMenú videojuegos");
			System.out.println("1.- Entregar");
			System.out.println("2.- Devolver");
			System.out.println("3.- Mostrar entregados");
			System.out.println("4.- Mostrar videojuego con más horas estimadas");
			System.out.println("5.- Regresar al menú principal");
			
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				switch(menu){
					case 1:
						System.out.println("\nIngresa el índice del videojuego a entregar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						
						if(indice < listaVideojuegos.size()) {
							videojuego = listaVideojuegos.get(indice);
							if(videojuego.isEntregado()) {
								System.out.println("El videojuego ya ha sido entregado anteriormente");
							} else {
								videojuego.entregar();
								System.out.println("El videojuego ha sido entregado correctamente");
							}
						} else {
							System.out.println("El índice ingresado no existe");
						}
						break;
					case 2:
						System.out.println("\nIngresa el índice del videojuego a devolver");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						
						if(indice < listaVideojuegos.size()) {
							videojuego = listaVideojuegos.get(indice);
							if(!videojuego.isEntregado()) {
								System.out.println("El videojuego ya ha sido devuelto anteriormente");
							} else {
								videojuego.devolver();
								System.out.println("El videojuego ha sido devuelto correctamente");
							}
						} else {
							System.out.println("El índice ingresado no existe");
						}
						break;
					case 3:
						int contador = 0;
						for(Videojuego v : listaVideojuegos) {
							if(v.isEntregado()) {
								System.out.print(v);
								contador++;
							}
						}
						
						if(contador > 0) {
							System.out.println("\nCantidad de videojuegos entregados: " + contador);
						} else {
							System.out.println("\nNo se encontraron videojuegos entregados");
						}
						break;
					case 4:
						Videojuego videojuegoCompare = new Videojuego();
						videojuegoCompare.compareTo(listaVideojuegos);
						break;
					case 5:
						System.out.println("\nRegresando...");
						break;
					default:
						System.out.println("\nOpción inválida, intente de nuevo");
						break;
				}
			} catch(Exception e) {
				menu = 6;
				for(StackTraceElement elemento : e.getStackTrace()) {
					System.out.println("\nClase: " + elemento.getClassName());
					System.out.println("Método: " + elemento.getMethodName());
					System.out.println("Línea: " + elemento.getLineNumber());
				}
			}
		} while (menu != 5);
	}
	
	private static void menuSeries(List<Serie> listaSeries) {
		int menu, indice;
		Scanner entrada;
		Serie serie;
		do {
			System.out.println("\nMenú series");
			System.out.println("1.- Entregar");
			System.out.println("2.- Devolver");
			System.out.println("3.- Mostrar entregados");
			System.out.println("4.- Mostrar serie con más temporadas");
			System.out.println("5.- Regresar al menú principal");
			
			try {
				entrada = new Scanner(System.in);
				menu = entrada.nextInt();
				
				switch(menu){
					case 1:
						System.out.println("\nIngresa el índice de la serie a entregar");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						
						if(indice < listaSeries.size()) {
							serie = listaSeries.get(indice);
							if(serie.isEntregado()) {
								System.out.println("La serie ya ha sido entregada anteriormente");
							} else {
								serie.entregar();
								System.out.println("La serie ha sido entregado correctamente");
							}
						} else {
							System.out.println("El índice ingresado no existe");
						}
						break;
					case 2:
						System.out.println("\nIngresa el índice de la serie a devolver");
						entrada = new Scanner(System.in);
						indice = entrada.nextInt();
						
						if(indice < listaSeries.size()) {
							serie = listaSeries.get(indice);
							if(!serie.isEntregado()) {
								System.out.println("La serie ya ha sido devuelta anteriormente");
							} else {
								serie.devolver();
								System.out.println("La serie ha sido devuelta correctamente");
							}
						} else {
							System.out.println("El índice ingresado no existe");
						}
						break;
					case 3:
						int contador = 0;
						for(Serie s : listaSeries) {
							if(s.isEntregado()) {
								System.out.print(s);
								contador++;
							}
						}
						
						if(contador > 0) {
							System.out.println("\nCantidad de series entregadas: " + contador);
						} else {
							System.out.println("\nNo se encontraron series entregadas");
						}
						break;
					case 4:
						Serie serieCompare = new Serie();
						serieCompare.compareTo(listaSeries);
						break;
					case 5:
						System.out.println("\nRegresando...");
						break;
					default:
						System.out.println("\nOpción inválida, intente de nuevo");
						break;
				}
			} catch(Exception e) {
				menu = 6;
				for(StackTraceElement elemento : e.getStackTrace()) {
					System.out.println("\nClase: " + elemento.getClassName());
					System.out.println("Método: " + elemento.getMethodName());
					System.out.println("Línea: " + elemento.getLineNumber());
				}
			}
		} while (menu != 5);
	}
}
