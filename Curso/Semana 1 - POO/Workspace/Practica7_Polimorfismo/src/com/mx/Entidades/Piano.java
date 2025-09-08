package com.mx.Entidades;

public class Piano extends Instrumento{
	private int numeroTeclas;
    private boolean digital;
    
    public Piano() {
    	
    }

	public Piano(String nombre, String tipo, double precio, int numeroTeclas, boolean digital) {
		super(nombre, tipo, precio);
		this.numeroTeclas = numeroTeclas;
		this.digital = digital;
	}
	
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Instrumento\n" + "Nombre" + this.nombre + "\nTipo: " + this.tipo + "\nPrecio: " + this.precio +
				"\nNúmero de teclas: " + this.numeroTeclas + "\nDigital: " + (this.digital ? "Si" : "No");
				
	}

	public int getNumeroTeclas() {
		return numeroTeclas;
	}

	public void setNumeroTeclas(int numeroTeclas) {
		this.numeroTeclas = numeroTeclas;
	}

	public boolean isDigital() {
		return digital;
	}

	public void setDigital(boolean digital) {
		this.digital = digital;
	}

	@Override
	public String toString() {
		return "Piano [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", numeroTeclas=" + numeroTeclas
				+ ", digital=" + (digital ? "Si" : "No") + "]";
	}
	
	
    
}
