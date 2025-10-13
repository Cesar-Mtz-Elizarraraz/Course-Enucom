package com.mx.Mascotas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponsableDTO {
	private int idResponsable;
	private String nombre;
	private Long contacto;
	private int veterinariaId;
}
