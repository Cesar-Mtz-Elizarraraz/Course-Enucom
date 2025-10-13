package com.mx.Responsables.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VeterinariaDTO {
	private int idVeterinaria;
	private String nombre;
	private String direccion;
	private Long telefono;
}
