package com.mx.Ventas.DTOs;

import java.time.LocalDate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VentaCliProdEmpDTO {
	private int idVenta;
	private String folio;
	private LocalDate fecha;
	private int cantidad;
	private double total;
	private String metodoPago;
	private ClienteDTO cliente;
	private EmpleadoDTO empleado;
	private ProductoDTO producto;
	
	public VentaCliProdEmpDTO(int idVenta, String folio, LocalDate fecha, int cantidad, double total, String metodoPago, ClienteDTO cliente,
			EmpleadoDTO empleado, ProductoDTO producto) {
		this.idVenta = idVenta;
		this.folio = folio;
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.total = total;
		this.metodoPago = metodoPago;
		this.cliente = cliente;
		this.empleado = empleado;
		this.producto = producto;
	}
}
