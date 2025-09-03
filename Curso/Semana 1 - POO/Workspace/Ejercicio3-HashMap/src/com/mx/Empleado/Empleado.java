package com.mx.Empleado;

public class Empleado {
	private String nombre;
	private String apellido;
	private int edad;
	private long contacto;
	private String puesto;
	private String area;
	private double sueldo;
	
	public Empleado() {
	}
	
	public Empleado(String nombre) {
		this.nombre = nombre;
	}

	public Empleado(String nombre, String apellido, int edad, long contacto, String puesto, String area,
			double sueldo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.contacto = contacto;
		this.puesto = puesto;
		this.area = area;
		this.sueldo = sueldo;
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

	public long getContacto() {
		return contacto;
	}

	public void setContacto(long contacto) {
		this.contacto = contacto;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	@Override
	public String toString() {
		return " Empleado => ["
				+ "Nombre=" + nombre + ", "
				+ "Apellido=" + apellido + ", "
				+ "Edad=" + edad + ", "
				+ "Contacto=" + contacto + ", "
				+ "Puesto=" + puesto + ", "
				+ "Área=" + area + ", "
				+ "Sueldo=" + sueldo
				+ "]\n";
	}
	
	
}
