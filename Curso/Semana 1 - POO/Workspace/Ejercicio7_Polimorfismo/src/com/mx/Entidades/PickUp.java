package com.mx.Entidades;

public class PickUp extends Automovil {
	private int capacidadCarga;
	
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Automóvil\n" + "Marca" + this.marca + "\nSubMarca: " + this.subMarca + 
				"\nModelo: " + this.modelo +
				"\nCapacidad de carga: " + this.capacidadCarga;
				
	}
	
	public PickUp() {
		
	}

	public PickUp(String marca, String subMarca, String modelo, int capacidadCarga) {
		super(marca, subMarca, modelo);
		this.capacidadCarga = capacidadCarga;
	}
	
	public int getCapacidadCarga() {
		return capacidadCarga;
	}
	
	public void setCapacidadCarga(int capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}

	@Override
	public String toString() {
		return "PickUp [marca=" + marca + ", subMarca=" + subMarca + ", modelo=" + modelo + ", capacidadCarga="
				+ capacidadCarga + "]";
	}
	
	
}
