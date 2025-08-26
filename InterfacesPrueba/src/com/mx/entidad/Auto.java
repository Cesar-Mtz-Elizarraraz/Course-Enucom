package com.mx.entidad;

public class Auto {
	String modelo;
	String marca;
	String color;
	long kilometraje;
	int cilindros;
	int anio;
	
	public Auto() {
	}
	
	public Auto(String modelo, String marca, String color, long kilometraje, int cilindros, int anio) {
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.kilometraje = kilometraje;
		this.cilindros = cilindros;
		this.anio = anio;
	}
	
	@Override
	public String toString() {
		return "Auto => [Modelo:" + modelo + ", Marca" + marca + ", Color" + color + 
				", Kilometraje" + kilometraje + ", Cilindros" + cilindros + ", Año" + anio + "]\n";
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getKilometraje() {
		return kilometraje;
	}

	public void setKilometraje(long kilometraje) {
		this.kilometraje = kilometraje;
	}

	public int getCilindros() {
		return cilindros;
	}

	public void setCilindros(int cilindros) {
		this.cilindros = cilindros;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
}
