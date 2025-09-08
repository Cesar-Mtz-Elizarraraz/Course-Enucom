package com.mx.Entidades;

public class Guitarra extends Instrumento{
	private int numeroCuerdas;
    private boolean electrica;
    
    public Guitarra() {
    	
    }

	public Guitarra(String nombre, String tipo, double precio, int numeroCuerdas, boolean electrica) {
		super(nombre, tipo, precio);
		this.numeroCuerdas = numeroCuerdas;
		this.electrica = electrica;
	}
    
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Instrumento\n" + "Nombre" + this.nombre + "\nTipo: " + this.tipo + "\nPrecio: " + this.precio +
				"\nNúmero de cuerdas: " + this.numeroCuerdas + "\nEléctrica: " + (this.electrica ? "Si" : "No");
				
	}

	public int getNumeroCuerdas() {
		return numeroCuerdas;
	}

	public void setNumeroCuerdas(int numeroCuerdas) {
		this.numeroCuerdas = numeroCuerdas;
	}

	public boolean isElectrica() {
		return electrica;
	}

	public void setElectrica(boolean electrica) {
		this.electrica = electrica;
	}

	@Override
	public String toString() {
		return "Guitarra [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", numeroCuerdas="
				+ numeroCuerdas + ", electrica=" + (electrica ? "Si" : "No") + "]";
	}
	
	
}
