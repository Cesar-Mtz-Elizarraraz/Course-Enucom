package com.mx.Categoria.DTOs;

import java.util.List;

import com.mx.Categoria.Entity.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaProductoDTO {
	private Categoria categoria;
	private List<ProductoDTO> productos;
}
