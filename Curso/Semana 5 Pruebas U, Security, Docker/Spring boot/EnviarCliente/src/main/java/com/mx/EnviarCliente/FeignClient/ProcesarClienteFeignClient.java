package com.mx.EnviarCliente.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.EnviarCliente.DTOs.ClienteDTO;

@FeignClient(name = "ProcesarCliente", url = "http://localhost:8013/procesar-cliente") // Crear un cliente Feign
public interface ProcesarClienteFeignClient {
	@PostMapping
	public ResponseEntity<String> procesarCli(@RequestBody ClienteDTO clienteDTO);
}
