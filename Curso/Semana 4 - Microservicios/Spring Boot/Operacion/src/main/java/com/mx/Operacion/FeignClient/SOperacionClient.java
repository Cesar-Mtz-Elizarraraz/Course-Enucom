package com.mx.Operacion.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.Operacion.DTOs.SOperacionDTO;

@FeignClient(name = "SOperacion", url = "http://localhost:8082/api/SOperacion") // Crear un cliente Feign
public interface SOperacionClient {
	@PostMapping
	public ResponseEntity<SOperacionDTO> guardar(@RequestBody SOperacionDTO sOperacionDTO);
}
