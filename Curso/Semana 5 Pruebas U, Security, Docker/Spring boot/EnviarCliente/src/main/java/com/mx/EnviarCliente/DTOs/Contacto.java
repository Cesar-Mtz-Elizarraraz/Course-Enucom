package com.mx.EnviarCliente.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Contacto {
	private int idContacto;
	private Long telefono;
	private String email;
}
