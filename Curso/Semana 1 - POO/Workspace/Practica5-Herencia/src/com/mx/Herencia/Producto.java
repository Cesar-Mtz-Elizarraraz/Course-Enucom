package com.mx.Herencia;

public class Producto {
	protected Long codigoBarras;
	protected String nombre;
	protected double precio;
	protected String marca;
	protected int stock;
	protected boolean disponible;
	
	public Producto() {
		
	}

	public Producto(Long codigoBarras, String nombre, double precio, String marca, int stock, boolean disponible) {
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
		this.marca = marca;
		this.stock = stock;
		this.disponible = disponible;
	}
	
	public void vender() {
		System.out.println("Producto vendido");
	}

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
	
	
}
