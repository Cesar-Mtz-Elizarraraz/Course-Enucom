package com.mx.Operacion.DTOs;

import java.math.BigDecimal;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SOperacionDTO {
	private int id;
	private String operacion;
	private BigDecimal importe;
	private String cliente;
	private int referencia;
	private String estatus;
	
	public SOperacionDTO(int id, String estatus, int referencia, String operacion) {
		this.id = id;
		this.estatus = estatus;
		this.referencia = referencia;
		this.operacion = operacion;
	}
}
