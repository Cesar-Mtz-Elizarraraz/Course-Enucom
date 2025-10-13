package com.mx.Ventas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Ventas.DTOs.ProductoDTO;

@FeignClient(name = "Producto", url = "http://localhost:8010/P") // Sirve para crear un cliente Feign, solicita:
/* - Nombre del microservicio a consumir
 * - URL del mricroservicio
 * */
public interface ProductoFeignClient {
	@GetMapping("/{codigoBarras}")
	public ProductoDTO buscar(@PathVariable Long codigoBarras);
	
	@GetMapping
	public List<ProductoDTO> listar();
}
