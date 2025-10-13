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
public class Domicilio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
