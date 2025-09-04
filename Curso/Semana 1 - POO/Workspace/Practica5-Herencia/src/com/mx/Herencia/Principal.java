package com.mx.Herencia;

public class Principal {

	public static void main(String[] args) {
		// INSTANCIA
		Refresco refresco1 = new Refresco(54654456L, "Coca-Cola 600ml.", 18.50, "Coca-Cola", 50, true, "Lata", 0.6, "Cola");
		System.out.println(refresco1);
		
		// MODIFICACIÓN
		refresco1.setPrecio(20);
		refresco1.setStock(25);
		refresco1.setDisponible(false);
		
		System.out.println("Refresco actualizado:\n" + refresco1);
		
		// VENDER
		refresco1.vender();
		

	}

}
