package com.mx.ProcesarCliente.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Contrato {
	@NotNull(message = "El ID del contrato no puede ser nulo")
	@Positive(message = "El ID del contrato debe ser un número positivo")
	@Id
	private Long idContrato;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaExpiracion;
}
