package com.mx.entidad;

import java.util.List;

public class Empresa {
	String rfc;
	String nombre;
	String pais;
	double capital;
	String rubro;
	List<Empleado> empleados;

	public Empresa() {
	}

	public Empresa(String rfc, String nombre, String pais, double capital, String rubro, List<Empleado> empleados) {
		this.rfc = rfc;
		this.nombre = nombre;
		this.pais = pais;
		this.capital = capital;
		this.rubro = rubro;
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Empresa =>[Rfc:" + rfc + ", Nombre:" + nombre + ", Pais:" + pais + ", Capital:" + capital + ", Rubro:"
				+ rubro + ", " + "\nEmpleados:\n" + empleados + "]\n";
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
