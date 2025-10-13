package com.mx.ProcesarCliente.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	@Digits(integer = 10, fraction = 0, message = "El teléfono debe contener exactamente 10 dígitos")
	private Long telefono; // solo numeros
	@NotBlank(message = "El email no puede estar vacío")
	@Email(message = "El email no es válido")
	private String email; // sin repetir email y telefono
}
