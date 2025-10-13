package com.mx.AutorLibro.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Libro {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idLibro;
	@NotBlank(message = "El título no puede estar vacío")
	private String titulo;
	private String genero;
	private int anioPublicacion;
	private double precio;
	@ManyToOne(fetch = FetchType.EAGER) // Muchos hijos pueden estar relacionados al mismo padre
	@JoinColumn(name = "AUTOR_ID")
	private Autor autorId;
	
	public Libro() {
		
	}
	
	public Libro(int idLibro, String titulo, String genero, int anioPublicacion, double precio, Autor autorId) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.genero = genero;
		this.anioPublicacion = anioPublicacion;
		this.precio = precio;
		this.autorId = autorId;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Autor getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor autorId) {
		this.autorId = autorId;
	}
}
