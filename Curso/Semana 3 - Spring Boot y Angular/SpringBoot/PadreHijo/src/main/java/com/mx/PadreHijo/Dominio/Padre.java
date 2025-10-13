package com.mx.PadreHijo.Dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PADRE")
public class Padre {
	// NOP se especifican los column, porque las columnas de la tabla conciden con el nombre de los atributos definidos aquí
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int idPadre;
	private String nombre;
	private String apellido;
	private int edad;
	private String trabajo;
	@OneToMany(mappedBy = "padreId", cascade = CascadeType.ALL)
	List<Hijo> listaHijos = new ArrayList<>();
	
	public Padre() {
		
	}

	public Padre(int idPadre, String nombre, String apellido, int edad, String trabajo) {
		this.idPadre = idPadre;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.trabajo = trabajo;
	}

	public int getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
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

	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
}
