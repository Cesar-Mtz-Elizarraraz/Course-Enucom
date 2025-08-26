package com.mx.entidad;

public class Empleado {
	String curp;
	String nombre;
	String apellido;
	int edad;
	String ciudad;
	String genero;
	String puesto;
	double sueldo;

	public Empleado() {
	}

	public Empleado(String curp) {
		this.curp = curp;
	}

	public Empleado(String curp, String nombre, String apellido, int edad, String ciudad, String genero, String puesto,
			double sueldo) {
		this.curp = curp;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.ciudad = ciudad;
		this.genero = genero;
		this.puesto = puesto;
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado =>[Curp:" + curp + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad
				+ ", Ciudad:" + ciudad + ", " + "Genero:" + genero + ", Puesto:" + puesto + ", Sueldo:" + sueldo
				+ "]\n";
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

}
