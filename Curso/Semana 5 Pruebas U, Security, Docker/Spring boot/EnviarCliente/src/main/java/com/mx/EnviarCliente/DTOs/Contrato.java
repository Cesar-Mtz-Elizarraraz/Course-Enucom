package com.mx.EnviarCliente.DTOs;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Contrato {
	private Long idContrato;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaExpiracion;
}
