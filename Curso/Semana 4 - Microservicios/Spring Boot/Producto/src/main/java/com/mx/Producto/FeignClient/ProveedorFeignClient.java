package com.mx.Producto.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Producto.DTOs.ProveedorDTO;


@FeignClient(name = "Proveedor", url = "http://localhost:8012/Prov") // Crear un cliente Feign
public interface ProveedorFeignClient {
	@GetMapping
	public List<ProveedorDTO> listar();
}
