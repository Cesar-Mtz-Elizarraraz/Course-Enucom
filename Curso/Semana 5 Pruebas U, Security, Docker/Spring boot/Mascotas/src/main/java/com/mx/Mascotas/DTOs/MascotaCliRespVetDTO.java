package com.mx.Mascotas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MascotaCliRespVetDTO {
	private int idMascota;
	private String nombre;
	private String raza;
	private int edad;
	private String razonCita;
	private ClienteDTO cliente;
	private ResponsableDTO responsable;
	private VeterinariaDTO veterinaria;
	
	public MascotaCliRespVetDTO(int idMascota, String nombre, String raza, int edad, String razonCita,
			ClienteDTO cliente, ResponsableDTO responsable, VeterinariaDTO veterinaria) {
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.razonCita = razonCita;
		this.cliente = cliente;
		this.responsable = responsable;
		this.veterinaria = veterinaria;
	}
}
