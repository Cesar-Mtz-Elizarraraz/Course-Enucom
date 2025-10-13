package com.mx.Producto.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Producto.DTOs.CategoriaDTO;


@FeignClient(name = "Categoria", url = "http://localhost:8011/C") // Crear un cliente Feign
public interface CategoriaFeignClient {
	@GetMapping
	public List<CategoriaDTO> listar();
}
