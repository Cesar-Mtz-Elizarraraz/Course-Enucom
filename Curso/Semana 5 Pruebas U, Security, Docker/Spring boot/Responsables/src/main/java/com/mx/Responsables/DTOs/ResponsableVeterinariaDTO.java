package com.mx.Responsables.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponsableVeterinariaDTO {
	private int idResponsable;
	private String nombre;
	private Long contacto;
	private VeterinariaDTO veterinaria;
}
