package com.mx.Proveedor.DTOs;

import lombok.Data;
// DTO: Data Transfer Object (Objeto de Transferencia de Datos)
// Clase que solo contiene datos, sin una lógica de negocios
@Data
public class ProductoDTO {
	private long codigoBarras; 
	private String nombre;
	private double precio;
	private int stock;
	private int descuento;
	private int categoriaId;
	private int proveedorId;
}
