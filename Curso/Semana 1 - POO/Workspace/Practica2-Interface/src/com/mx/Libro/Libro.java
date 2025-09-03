package com.mx.Libro;

public class Libro {
	private int isbn;
	private String nombre;
	private String autor;
	private double precio;
	private String genero;
	private int numeroCopias;
	
	public Libro() {
	}

	public Libro(int isbn, String nombre, String autor, double precio, String genero, int numeroCopias) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.autor = autor;
		this.precio = precio;
		this.genero = genero;
		this.numeroCopias = numeroCopias;
	}
	
	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getNumeroCopias() {
		return numeroCopias;
	}

	public void setNumeroCopias(int numeroCopias) {
		this.numeroCopias = numeroCopias;
	}
	
	@Override
	public String toString() {
		return "Libro => ["
				+ "ISBN=" + isbn + ", "
				+ "Nombre=" + nombre + ", "
				+ "Autor=" + autor + ", "
				+ "Precio=" + precio + ", "
				+ "Género=" + genero + ", "
				+ "Número de copias=" + numeroCopias
				+ "]\n";
	}
	
}
