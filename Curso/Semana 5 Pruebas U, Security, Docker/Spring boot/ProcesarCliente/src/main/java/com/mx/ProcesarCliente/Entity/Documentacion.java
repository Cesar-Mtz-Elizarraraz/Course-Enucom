package com.mx.ProcesarCliente.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@RequiredArgsConstructor
public class Documentacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDocumentacion;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
}
