package com.mx.EnviarCliente.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Domicilio {
	private int idDomicilio;
	private String entidadFederativa;
	private String municipio;
	private String colonia;
	private String calle;
	private String numeroInterior;
	private String numeroExterior;
	private int codigoPostal;
	private String pais;
}
