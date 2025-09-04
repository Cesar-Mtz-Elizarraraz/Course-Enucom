package com.mx.Principal;

import com.mx.Entidades.Abogado;
import com.mx.Entidades.Medico;

public class Principal {

	public static void main(String[] args) {
		Medico medico = new Medico("Mariano", "Ventura", 32, 7841252, "UNAM", 5, "Médico General", "Farmacias Ahorro", 5000);
		System.out.println(medico);
		medico.trabajar();
		medico.cobrar(medico.getEspecialidad(), medico.getCostoConsulta());
		
		System.out.println("\n--------- ABOGADO ---------");
		Abogado abogado = new Abogado("Liliana", "Gutierrez", 29, 1234567, "BUAP", 4, "Abogada Familiar", "DIF", 1900);
		System.out.println(abogado);
		abogado.trabajar();
		abogado.cobrar(abogado.getTipo(), abogado.getHonorarios());
		
		// Replicar el ejercicio con entidades diferentes 
	}

}
