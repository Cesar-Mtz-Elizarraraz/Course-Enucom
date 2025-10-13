package com.mx.EnviarCliente.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Documentacion {
	private int idDocumentacion;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
}
