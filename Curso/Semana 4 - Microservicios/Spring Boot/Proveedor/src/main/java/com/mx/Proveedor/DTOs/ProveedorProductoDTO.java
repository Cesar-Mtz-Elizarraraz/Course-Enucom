package com.mx.Proveedor.DTOs;

import java.util.List;

import com.mx.Proveedor.Entity.Proveedor;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProveedorProductoDTO {
	private Proveedor proveedor;
	private List<ProductoDTO> productos;
}
