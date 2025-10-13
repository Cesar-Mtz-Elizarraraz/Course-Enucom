package com.mx.ProcesarCliente.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Beneficiario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBeneficiario;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaNacimiento;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "domicilioId", referencedColumnName = "idDomicilio")
	private Domicilio domicilio;
}
