package com.mx.AutorLibro.Dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idAutor;
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	private String nacionalidad;
	private Date fechaNacimiento;
	@OneToMany(mappedBy = "autorId", cascade = CascadeType.ALL)
	List<Libro> listaLibros = new ArrayList<>();
	
	public Autor() {
		
	}
	public Autor(int idAutor, String nombre, String nacionalidad, Date fechaNacimiento) {
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
}
