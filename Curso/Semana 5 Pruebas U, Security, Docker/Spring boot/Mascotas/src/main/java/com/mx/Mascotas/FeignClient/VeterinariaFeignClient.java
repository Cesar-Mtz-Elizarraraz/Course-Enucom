package com.mx.Mascotas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Mascotas.DTOs.VeterinariaDTO;

@FeignClient(name = "Veterinarias", url = "http://localhost:8013/veterinaria") // Cliente Feign
public interface VeterinariaFeignClient {
	@GetMapping
	public List<VeterinariaDTO> listar();
}
