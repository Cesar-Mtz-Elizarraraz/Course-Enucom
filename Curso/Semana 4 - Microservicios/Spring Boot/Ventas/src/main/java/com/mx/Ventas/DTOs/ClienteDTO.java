package com.mx.Ventas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteDTO {
	private int idCliente;
	private String nombre;
	private String app;
	private String apm;
	private Long telefono;
}
