package com.mx.Mascotas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteDTO {
	private int idCliente;
	private String nombre;
	private String direccion;
	private Long contacto;
}
