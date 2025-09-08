package com.mx.Entidades;

public class Tambor extends Instrumento{
	private String tamano;
    private boolean baquetas;
    
    public Tambor() {
    	
    }

	public Tambor(String nombre, String tipo, double precio, String tamano, boolean baquetas) {
		super(nombre, tipo, precio);
		this.tamano = tamano;
		this.baquetas = baquetas;
	}
    
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Instrumento\n" + "Nombre" + this.nombre + "\nTipo: " + this.tipo + "\nPrecio: " + this.precio +
				"\nTamaño: " + this.tamano + "\nBaquetas: " + (this.baquetas ? "Si" : "No");
				
	}

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public boolean isBaquetas() {
		return baquetas;
	}

	public void setBaquetas(boolean baquetas) {
		this.baquetas = baquetas;
	}

	@Override
	public String toString() {
		return "Tambor [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", tamano=" + tamano
				+ ", baquetas=" + (baquetas ? "Si" : "No") + "]";
	}
	
	
}
