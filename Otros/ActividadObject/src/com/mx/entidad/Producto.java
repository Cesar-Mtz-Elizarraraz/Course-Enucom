package com.mx.entidad;

public abstract class Producto {
	int codigoBarras;
	String nombreProducto;
	String marca;
	double precio;
	int stock;
	String pais;
	
	public Producto() {
	}

	public Producto(int codigoBarras, String nombreProducto, String marca, double precio, int stock, String pais) {
		this.codigoBarras = codigoBarras;
		this.nombreProducto = nombreProducto;
		this.marca = marca;
		this.precio = precio;
		this.stock = stock;
		this.pais = pais;
	}
	
	public abstract double precioTotal();

	public int getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(int codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
