package com.mx.Entidades;

public class Fritura extends Producto {

	private String sabor;
	private boolean picante;
	private double pesoNeto;
	
	public Fritura() {
		
	}

	public Fritura(Long codigoBarras, String nombre, double precio, String marca, int stock, boolean disponible,
			String sabor, boolean picante, double pesoNeto) {
		super(codigoBarras, nombre, precio, marca, stock, disponible);
		this.sabor = sabor;
		this.picante = picante;
		this.pesoNeto = pesoNeto;
	}

	@Override
	public void comprar() {
		System.out.println("Frituras compradas para la venta en escuelas");
		
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public boolean isPicante() {
		return picante;
	}

	public void setPicante(boolean picante) {
		this.picante = picante;
	}

	public double getPesoNeto() {
		return pesoNeto;
	}

	public void setPesoNeto(double pesoNeto) {
		this.pesoNeto = pesoNeto;
	}
	
	@Override
	public String toString() {
		return "Refresco => [" +
				"Código de barras=" + codigoBarras +
				", Nombre=" + nombre +
				", Precio=" + precio +
				", Marca=" + marca +
				", Stock=" + stock +
				", Disponible=" + (disponible ? "Si" : "No") + 
				", Sabor=" + sabor + 
				", Picante=" + (picante ? "Si" : "No") + 
				", Peso Neto=" + pesoNeto + 
				"]\n";
	}
	
}
