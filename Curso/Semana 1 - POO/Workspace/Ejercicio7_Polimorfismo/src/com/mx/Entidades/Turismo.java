package com.mx.Entidades;

public class Turismo extends Automovil{
	private int numAsientos;
	
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Automóvil\n" + "Marca" + this.marca + "\nSubMarca: " + this.subMarca + 
				"\nModelo: " + this.modelo +
				"\nNúmero de asientos: " + this.numAsientos;
				
	}
	
	public Turismo() {
		
	}

	public Turismo(String marca, String subMarca, String modelo, int numAsientos) {
		super(marca, subMarca, modelo);
		this.numAsientos = numAsientos;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	@Override
	public String toString() {
		return "Turismo [marca=" + marca + ", subMarca=" + subMarca + ", modelo=" + modelo + ", numAsientos="
				+ numAsientos + "]";
	}

	
	
	
}
