package com.mx.entidad;

import java.util.List;

public class Persona {
	// Atributos
	String nombre;
	String apellido;
	int edad;
	String genero;
	String ciudad; 
	String telefono;
	List<Auto> autos;
	
	public Persona() {
	}
	
	public Persona(String nombre, String apellido, int edad, String genero, String ciudad, String telefono, List<Auto> autos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.autos = autos;
	}

	@Override
	public String toString() {
		return "Persona => [Nombre:" + nombre + ", Apellido" + apellido + ", Edad" + edad + 
				", Género" + genero + ", Ciudad" + ciudad + ", Teléfono" + telefono + "\nAutos\n" + autos +  "]\n";
	}
	
	// Cuando no detecta la función toString(), imprime el valor en memoria del objeto

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}
	
	
}
