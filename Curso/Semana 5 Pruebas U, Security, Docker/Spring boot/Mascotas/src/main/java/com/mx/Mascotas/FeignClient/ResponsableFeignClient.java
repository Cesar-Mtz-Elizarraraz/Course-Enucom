package com.mx.Mascotas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Mascotas.DTOs.ResponsableDTO;

@FeignClient(name = "Responsables", url = "http://localhost:8010/responsable") // Cliente Feign
public interface ResponsableFeignClient {
	@GetMapping
	public List<ResponsableDTO> listar();
}
