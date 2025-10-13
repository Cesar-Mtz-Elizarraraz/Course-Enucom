package com.mx.Operacion.Entity;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operacion {
	
	@NotBlank(message = "La operación es obligatoria")
    @Pattern(regexp = "^[a-zA-ZáéóiúÁÉÍÓÚñÑ]{5,50}$", message = "La operación debe tener entre 5 y 50 caracteres que sean solamente letras")
	private String operacion;
	private BigDecimal importe; // Se ocupa BigDecimal para un mayor control de los decimales
	@NotBlank(message = "El cliente es obligatorio")
    @Pattern(regexp = "^[a-zA-ZáéóiúÁÉÍÓÚñÑ]{5,50}$", message = "El cliente debe tener entre 3 y 50 caracteres que sean solamente letras")
	private String cliente;
	private String sha;
}
