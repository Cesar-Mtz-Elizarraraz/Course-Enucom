package com.mx.Entidades;

public class Deportivo extends Automovil {
	private int noCilindros;
	
	// MÉTODO PERSONALIZADO
	public String mostrarDatos() {
		return "Automóvil\n" + "Marca" + this.marca + "\nSubMarca: " + this.subMarca + 
				"\nModelo: " + this.modelo +
				"\nNúmero de cilindors: " + this.noCilindros;
				
	}
	
	public Deportivo() {
		
	}

	public Deportivo(String marca, String subMarca, String modelo, int noCilindros) {
		super(marca, subMarca, modelo);
		this.noCilindros = noCilindros;
	}
	
	public int getNoCilindros() {
		return noCilindros;
	}
	
	public void setNoCilindros(int noCilindros) {
		this.noCilindros = noCilindros;
	}

	@Override
	public String toString() {
		return "Deportivo [marca=" + marca + ", subMarca=" + subMarca + ", modelo=" + modelo + ", noCilindros="
				+ noCilindros + "]";
	}
	
	
}
