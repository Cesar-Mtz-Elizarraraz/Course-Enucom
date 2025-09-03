package com.mx.entidad;

import java.util.List;

public class Gerente extends Persona {
	String area;
	List<Obrero> obreros;
	
	public Gerente() {
		super();
	}

	public Gerente(String nombre, String apellido, int edad, String genero, String ciudad, double sueldo, String area, List<Obrero> obreros) {
		super(nombre, apellido, edad, genero, ciudad, sueldo);
		this.area = area;
		this.obreros = obreros;
	}
	
	@Override
	public String toString() {
		return "Obrero => [Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad +
		", Género:" + genero + ", Ciudad:" + ciudad + ", Sueldo:" + sueldo + ", Área:" + area + 
		"\nObreros:\n" + (obreros.isEmpty() ? "Sin obreros" : obreros) + "]";
	}
	
	@Override
	public double salarioNeto() {
		double sueldoTotal = sueldo - (sueldo * 0.20);
		return sueldoTotal;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Obrero> getObreros() {
		return obreros;
	}

	public void setObreros(List<Obrero> obreros) {
		this.obreros = obreros;
	}
	
	
}
