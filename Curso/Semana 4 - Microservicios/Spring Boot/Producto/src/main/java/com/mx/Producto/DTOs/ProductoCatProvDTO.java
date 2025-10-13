package com.mx.Producto.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductoCatProvDTO {
	
	private long codigoBarras; 
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private CategoriaDTO categoria;
	private ProveedorDTO proveedor;
	
	public ProductoCatProvDTO(long codigoBarras, String nombre, double precio, int stock, int descuento,
			CategoriaDTO categoria, ProveedorDTO proveedor) {
		this.codigoBarras = codigoBarras;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.descuento = descuento;
		this.categoria = categoria;
		this.proveedor = proveedor;
	}
	
	
}
