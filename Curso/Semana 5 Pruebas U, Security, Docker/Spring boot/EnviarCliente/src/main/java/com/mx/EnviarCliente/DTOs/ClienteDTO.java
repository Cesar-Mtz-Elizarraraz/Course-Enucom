package com.mx.EnviarCliente.DTOs;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteDTO {
	private Long idClienteDigital;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String genero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;
	private String curp;
	private Contacto contacto;
	private Domicilio domicilio;
	private Documentacion documentacion;
	private Beneficiario beneficiario;
	private Contrato contrato;
	private Producto productoId;
}
