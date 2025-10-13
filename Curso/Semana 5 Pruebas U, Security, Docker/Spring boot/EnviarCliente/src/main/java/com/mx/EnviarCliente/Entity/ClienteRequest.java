package com.mx.EnviarCliente.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mx.EnviarCliente.DTOs.Beneficiario;
import com.mx.EnviarCliente.DTOs.Contacto;
import com.mx.EnviarCliente.DTOs.Contrato;
import com.mx.EnviarCliente.DTOs.Documentacion;
import com.mx.EnviarCliente.DTOs.Domicilio;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ClienteRequest {
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
	private String idProducto;
}
