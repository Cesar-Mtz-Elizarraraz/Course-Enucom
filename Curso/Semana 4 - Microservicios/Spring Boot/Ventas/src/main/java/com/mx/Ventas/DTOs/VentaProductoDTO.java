package com.mx.Ventas.DTOs;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VentaProductoDTO {
	private int idVenta;
	private String folio;
	private LocalDate fecha;
	private int cantidad;
	private double total;
	private String metodoPago;
	private int clienteId;
	private int empleadoId;
	private ProductoDTO producto;
}
