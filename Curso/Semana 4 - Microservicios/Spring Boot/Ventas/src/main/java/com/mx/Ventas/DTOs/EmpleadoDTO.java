package com.mx.Ventas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmpleadoDTO {
	private int idEmpleado;
	private String nombre;
	private String apellido;
	private Long telefono;
	private String puesto;
}
