package com.mx.entidad;

public class Obrero extends Persona {
	String curp;
	
	public Obrero() {
	}
	
	public Obrero(String curp) {
		super();
		this.curp = curp;
	}
	
	

	public Obrero(String nombre, String apellido, int edad, String genero, String ciudad, double sueldo, String curp) {
		super(nombre, apellido, edad, genero, ciudad, sueldo);
		this.curp = curp;
	}
	
	@Override
	public String toString() {
		return "Obrero => [Curp: "+ curp + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad +
		", Género:" + genero + ", Ciudad:" + ciudad + ", Sueldo:" + sueldo + "]";
	}

	@Override
	public double salarioNeto() {
		double sueldoTotal = sueldo - (sueldo * 0.10);
		return sueldoTotal;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}
	
	
	
}
