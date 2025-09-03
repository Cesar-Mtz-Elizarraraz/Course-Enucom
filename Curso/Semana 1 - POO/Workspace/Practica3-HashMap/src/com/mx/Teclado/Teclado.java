package com.mx.Teclado;

public class Teclado {
	private long codigoBarras;
	private String marca;
	private String modelo;
	private double precio;
	private String tipo;
	private String color;
	
	public Teclado() {
	}
	
	public Teclado(long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Teclado(long codigoBarras, String marca, String modelo, double precio, String tipo, String color) {
		this.codigoBarras = codigoBarras;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
		this.tipo = tipo;
		this.color = color;
	}

	public long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return " Teclado => ["
				+ "Código de barras=" + codigoBarras + ", "
				+ "Marca=" + marca + ", "
				+ "Modelo=" + modelo + ", "
				+ "Precio=" + precio + ", "
				+ "Tipo=" + tipo + ", "
				+ "Color=" + color
				+ "]\n";
	}
}
