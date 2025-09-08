package com.mx.Principal;

import com.mx.Entidades.*;

public class Principal {

	public static void main(String[] args) {
		// CREAR UN ARRAY DE 4 POSICIONES
		
		String[] array = {"HOla", "Bebe", "nas", "asd"};
		Automovil[] autos = new Automovil[4];
		
		autos[0] = new Automovil("Honda", "Civic", "2002");
		autos[1] = new Deportivo("Ford", "GT", "2003", 8);
		autos[2] = new Turismo("Mercedes-Benz", "Spinter", "2023", 15);
		autos[3] = new PickUp("RAM", "1500", "2025", 30);
		
		for(Automovil auto : autos) {
			System.out.println(auto.mostrarDatos());
			System.out.println(auto + "\n");
		}
		

	}

}
