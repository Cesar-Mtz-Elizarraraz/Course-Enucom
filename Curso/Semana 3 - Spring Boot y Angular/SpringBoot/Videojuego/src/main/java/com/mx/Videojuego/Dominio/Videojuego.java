package com.mx.Videojuego.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VIDEOJUEGO")
public class Videojuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVideojuego;
	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(100)")
	private String nombre;
	@Column(name = "GENERO", columnDefinition = "NVARCHAR2(50)")
	private String genero;
	@Column(name = "DESARROLLADOR", columnDefinition = "NVARCHAR2(100)")
	private String desarrollador;
	@Column(name = "PLATAFORMA", columnDefinition = "NVARCHAR2(50)")
	private String plataforma;
	@Column(name = "PRECIO", columnDefinition = "NUMBER")
	private double precio;
	@Column(name = "CLASIFICACION", columnDefinition = "NVARCHAR2(10)")
	private String clasificacion;
	@Column(name = "COPIAS_VENDIDAS", columnDefinition = "NUMBER")
	private int copiasVendidas;
	
	public Videojuego() {
		
	}

	public Videojuego(int idVideojuego, String nombre, String genero, String desarrollador, String plataforma,
			double precio, String clasificacion, int copiasVendidas) {
		this.idVideojuego = idVideojuego;
		this.nombre = nombre;
		this.genero = genero;
		this.desarrollador = desarrollador;
		this.plataforma = plataforma;
		this.precio = precio;
		this.clasificacion = clasificacion;
		this.copiasVendidas = copiasVendidas;
	}

	public int getIdVideojuego() {
		return idVideojuego;
	}

	public void setIdVideojuego(int idVideojuego) {
		this.idVideojuego = idVideojuego;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public int getCopiasVendidas() {
		return copiasVendidas;
	}

	public void setCopiasVendidas(int copiasVendidas) {
		this.copiasVendidas = copiasVendidas;
	}
}
