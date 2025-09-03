package com.mx.entidad;

import java.util.List;

public class Cliente {
	// Atributos
	String curp;
	String nombre;
	String apellido;
	int edad;
	String genero;
	String ciudad;
	String estadoCivil;
	List<Cuenta> cuentas;
	
	public Cliente() {
		
	}
	
	public Cliente(String curp, String nombre, String apellido, int edad, String genero, String ciudad, String estadoCivil, List<Cuenta> cuentas) {
		this.curp = curp;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.estadoCivil = estadoCivil;
		this.cuentas = cuentas;
	}
	
	@Override
	public String toString() {
		return "\nCliente => [Curp: "+ curp + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad +
				", Género:" + genero + ", Ciudad:" + ciudad + ", Estado Civil:" + estadoCivil + 
				"\nCuentas:\n" + (cuentas.isEmpty() ? "Sin cuentas disponibles" : cuentas) + "]";
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	
}
