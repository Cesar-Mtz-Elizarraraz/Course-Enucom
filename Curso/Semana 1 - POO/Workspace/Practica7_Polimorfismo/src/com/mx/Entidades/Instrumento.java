package com.mx.Entidades;

public class Instrumento {
	protected String nombre;
	protected String tipo;
	protected double precio;
	
	public Instrumento() {
		
	}

	public Instrumento(String nombre, String tipo, double precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
	}
	
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Instrumento\n" + "Nombre" + this.nombre + "\nTipo: " + this.tipo + "\nPrecio: " + this.precio;
				
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Instrumento [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + "]";
	}
}
