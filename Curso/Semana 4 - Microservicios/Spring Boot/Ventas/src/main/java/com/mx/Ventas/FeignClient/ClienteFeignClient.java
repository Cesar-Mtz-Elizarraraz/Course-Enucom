package com.mx.Ventas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.Ventas.DTOs.ClienteDTO;

@FeignClient(name = "Cliente", url = "http://localhost:8014/Cli") // Crear un cliente Feign
public interface ClienteFeignClient {
	@GetMapping("/{idCliente}")
	public ClienteDTO buscar(@PathVariable int idCliente);
	
	@GetMapping
	public List<ClienteDTO> listar();
}
