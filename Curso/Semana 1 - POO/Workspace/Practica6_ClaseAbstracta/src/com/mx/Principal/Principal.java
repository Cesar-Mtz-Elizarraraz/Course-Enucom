package com.mx.Principal;

import com.mx.Entidades.Fritura;
import com.mx.Entidades.Refresco;

public class Principal {

	public static void main(String[] args) {
		System.out.println("============ REFRESCO ============");
		Refresco refresco = new Refresco(54654456L, "Coca-Cola 600ml", 18.50, "Coca-Cola", 50, true, "Lata", 0.6, "Cola");
		System.out.println(refresco);
		refresco.comprar();
		refresco.vender(refresco.getNombre(), refresco.getLitros(), refresco.getPrecio());
		
		System.out.println("\n============ FRITURA ============");
		Fritura fritura = new Fritura(98532988L, "Sabritas Adobadas", 20, "Sabritas", 30, true, "Adobada", true, 150.0);
		System.out.println(fritura);
		fritura.comprar();
		fritura.vender(fritura.getNombre(), fritura.getPesoNeto(), fritura.getPrecio());
		
	}

}
