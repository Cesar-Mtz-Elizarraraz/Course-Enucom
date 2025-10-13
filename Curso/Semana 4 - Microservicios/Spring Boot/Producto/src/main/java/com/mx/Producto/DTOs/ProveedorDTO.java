package com.mx.Producto.DTOs;

import lombok.Data;

@Data
public class ProveedorDTO {
	private int idProveedor;
	private String nombre;
	private long telefono;
	private String email;
}
