package com.mx.Celular;

public class Celular {
	private String marca;
	private String modelo;
	private String color;
	private int imei;
	private String procesador;
	private int precio;
	
	public Celular() {	
	}

	public Celular(String marca, String modelo, String color, int imei, String procesador, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.imei = imei;
		this.procesador = procesador;
		this.precio = precio;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getImei() {
		return imei;
	}

	public void setImei(int imei) {
		this.imei = imei;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Celular => ["
				+ "Marca=" + marca + ", "
				+ "Modelo=" + modelo + ", "
				+ "Color=" + color + ", "
				+ "Imei=" + imei + ", "
				+ "Procesador=" + procesador + ", "
				+ "Precio=" + precio
				+ "]\n";
	}
	
}
