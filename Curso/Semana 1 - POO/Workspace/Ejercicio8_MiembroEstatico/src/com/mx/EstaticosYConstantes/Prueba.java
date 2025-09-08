package com.mx.EstaticosYConstantes;

public class Prueba {
	public static void main(String[] args) {
		// INSTANCIAR
		Principal obj1 = new Principal();
		
		// ACCEDER A LOS MIEMBROS
		System.out.println("obj1: " + obj1.frase2); // MIEMBRO DE INSTANCIA
		
		System.out.println("obj2: " + Principal.frase1); // MIEMBRO ATRA VEZ DE UNA CLASE
	}
}
