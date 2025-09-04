package com.mx.Entidades;

public class Medico extends Profesionista {

	private String especialidad;
	private String consultorio;
	private double costoConsulta;
	
	@Override
	public void trabajar() {
		System.out.println("Trabajo en turnos nocturnos");
		
	}

	public Medico() {

	}

	public Medico(String nombre, String apellido, int edad, int cedula, String universidad, int experiencia,
			String especialidad, String consultorio, double costoConsulta) {
		super(nombre, apellido, edad, cedula, universidad, experiencia);
		this.especialidad = especialidad;
		this.consultorio = consultorio;
		this.costoConsulta = costoConsulta;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(String consultorio) {
		this.consultorio = consultorio;
	}

	public double getCostoConsulta() {
		return costoConsulta;
	}

	public void setCostoConsulta(double costoConsulta) {
		this.costoConsulta = costoConsulta;
	}

	@Override
	public String toString() {
		return "Medico [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", cedula=" + cedula
				+ ", universidad=" + universidad + ", experiencia=" + experiencia + ", especialidad=" + especialidad
				+ ", consultorio=" + consultorio + ", costoConsulta=" + costoConsulta + "]";
	}
	
	
	
	
	
}
