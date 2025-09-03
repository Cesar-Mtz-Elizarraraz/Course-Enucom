package com.mx.Animal;

public class Animal {
	private String nombre;
	private String sexo;
	private String especie;
	private double peso;
	private double altura;
	
	public Animal() {
	}

	public Animal(String nombre, String sexo, String especie, double peso, double altura) {
		this.nombre = nombre;
		this.sexo = sexo;
		this.especie = especie;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public String toString() {
		return "Animal => [nombre=" + nombre + ", sexo=" + sexo + ", especie=" + especie + 
				", peso=" + peso + ", altura=" + altura + "]\n";
	}
}
