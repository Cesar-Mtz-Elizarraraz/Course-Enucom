package com.mx.EnviarCliente.DTOs;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Beneficiario {
	private int idBeneficiario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;
	private Domicilio domicilio;
}
