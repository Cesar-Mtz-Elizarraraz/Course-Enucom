package com.mx.entidad;

import java.util.List;

public class Tienda {
	int numero;
	String nombre;
	String ciudad;
	String empresa;
	int codigoPostal;
	List<Comestible> comestibles;
	List<Ropa> ropa;
	
	public Tienda() {
	}

	public Tienda(int numero, String nombre, String ciudad, String empresa, int codigoPostal,
			List<Comestible> comestibles, List<Ropa> ropa) {
		this.numero = numero;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.empresa = empresa;
		this.codigoPostal = codigoPostal;
		this.comestibles = comestibles;
		this.ropa = ropa;
	}
	
	@Override
	public String toString() {
		return "TIENDA => [Número: " + numero + ", Nombre: " + nombre + ", Ciudad: " + ciudad + ", Empresa: " + empresa + ", CP: " + codigoPostal +
				"\nComestibles: " + (comestibles.isEmpty() ? "Sin comestibles" : "\n" + comestibles) + 
				"\nRopa: " + (ropa.isEmpty() ? "Sin ropa" : "\n" + ropa) + "]\n";
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public List<Comestible> getComestibles() {
		return comestibles;
	}

	public void setComestibles(List<Comestible> comestibles) {
		this.comestibles = comestibles;
	}

	public List<Ropa> getRopa() {
		return ropa;
	}

	public void setRopa(List<Ropa> ropa) {
		this.ropa = ropa;
	}
	
	public double getGananciaTotal() {
		double gananciaTotal = 0;
		for(Comestible c : comestibles) {
			gananciaTotal += c.precioTotal() * c.getStock();
		}
		for(Ropa r : ropa) {
			gananciaTotal += r.precioTotal() * r.getStock();
		}
		return gananciaTotal;
	}
	
}
