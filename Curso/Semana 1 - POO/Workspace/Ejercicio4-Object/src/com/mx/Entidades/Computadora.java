package com.mx.Entidades;

public class Computadora {
	private int sku;
	private String marca;
	private String procesador;
	private int ram;
	private String capacidad;
	private String color;
	
	public Computadora() {
	}

	public Computadora(int sku, String marca, String procesador, int ram, String capacidad, String color) {
		this.sku = sku;
		this.marca = marca;
		this.procesador = procesador;
		this.ram = ram;
		this.capacidad = capacidad;
		this.color = color;
	}

	public int getSku() {
		return sku;
	}

	public void setSku(int sku) {
		this.sku = sku;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProcesador() {
		return procesador;
	}

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Computadora [" +
				"SKU=" + sku +
				", Marca=" + marca +
				", Procesador=" + procesador +
				", Ram=" + ram +
				", Capacidad=" + capacidad +
				", Color=" + color + 
				"]\n";
	}
	
	
	
	
}
