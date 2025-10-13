package com.mx.Mascotas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Mascotas.DTOs.ClienteDTO;

@FeignClient(name = "Clientes", url = "http://localhost:8012/cliente") // Cliente Feign
public interface ClienteFeignClient {
	@GetMapping
	public List<ClienteDTO> listar();
}

