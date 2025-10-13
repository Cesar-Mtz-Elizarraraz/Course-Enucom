package com.mx.UsuarioRol.Dominio;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CURSO_USUARIOS")
public class Usuario {
	@Id
	private int idUsuario;
	private String nombre;
	private String app;
	private String apm;
	private String sexo;
	private String correo;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Mexico_City") // FORMATEAR FECHA
	private LocalDate fechaNacimiento;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
	private LocalDate fechaCreacion;
	@ManyToOne(fetch = FetchType.EAGER) // Muchos hijos pueden estar relacionados al mismo padre
	@JoinColumn(name = "ROL_ID")
	private Rol rolId;
	
	public Usuario() {
		
	}
	
	public Usuario(int idUsuario, String nombre, String app, String apm, String sexo, String correo,
			LocalDate fechaNacimiento, LocalDate fechaCreacion, Rol rolId) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.sexo = sexo;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaCreacion = fechaCreacion;
		this.rolId = rolId;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Rol getRolId() {
		return rolId;
	}

	public void setRolId(Rol rolId) {
		this.rolId = rolId;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", sexo="
				+ sexo + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", fechaCreacion="
				+ fechaCreacion + ", rolId=" + rolId + "]";
	}
	
	
}
