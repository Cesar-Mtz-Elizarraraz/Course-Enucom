package com.mx.Ventas.FeignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.mx.Ventas.DTOs.EmpleadoDTO;

@FeignClient(name = "Empleado", url = "http://localhost:8015/E")
public interface EmpleadoFeignClient {
	@GetMapping
	public List<EmpleadoDTO> listar();
}
