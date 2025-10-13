package com.mx.Ventas.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductoDTO {
	private long codigoBarras; 
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
}
