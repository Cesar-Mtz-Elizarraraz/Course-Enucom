package com.mx.Herencia;

public class Refresco extends Producto {
	private String tipo_envase;
	private double litros;
	private String sabor;
	
	public Refresco() {
		
	}

	public Refresco(Long codigoBarras, String nombre, double precio, String marca, int stock, boolean disponible, String tipo_envase, double litros, String sabor) {
		super(codigoBarras, nombre, precio, marca, stock, disponible);
		this.tipo_envase = tipo_envase;
		this.litros = litros;
		this.sabor = sabor;
	}

	public String getTipo_envase() {
		return tipo_envase;
	}

	public void setTipo_envase(String tipo_envase) {
		this.tipo_envase = tipo_envase;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
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
				", Tipo de envase=" + tipo_envase + 
				", Litros=" + litros + 
				", Sabor=" + sabor + 
				"]\n";
	}
	
}
