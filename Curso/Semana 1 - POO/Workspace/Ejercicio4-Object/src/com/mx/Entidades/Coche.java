package com.mx.Entidades;

public class Coche {

	private Long identificador;
	private String marca;
	private String modelo;
	private int precio;
	private String color;
	private int noPuertas;
	
	public Coche() {
	}

	public Coche(Long identificador, String marca, String modelo, int precio, String color, int noPuertas) {
		this.identificador = identificador;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.color = color;
		this.noPuertas = noPuertas;
	}

	public Long getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNoPuertas() {
		return noPuertas;
	}

	public void setNoPuertas(int noPuertas) {
		this.noPuertas = noPuertas;
	}
	
	@Override
	public String toString() {
		return "Coche [" +
				"Identificador=" + identificador +
				", Marca=" + marca +
				", Modelo=" + modelo +
				", Precio=" + precio +
				", Color=" + color + 
				", Número de puertas=" + noPuertas + 
				"]\n";
	}
	
}
