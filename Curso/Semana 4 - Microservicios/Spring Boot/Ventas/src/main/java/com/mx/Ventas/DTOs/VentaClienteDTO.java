package com.mx.Ventas.DTOs;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VentaClienteDTO {
	private int idVenta;
	private String folio;
	private LocalDate fecha;
	private int cantidad;
	private double total;
	private String metodoPago;
	private ClienteDTO cliente;
	private int empleadoId;
	private Long codigoBarras;
	
}
