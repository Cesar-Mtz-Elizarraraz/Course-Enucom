package com.mx.SpringSecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class PruebaController {
	// Ruta publica
	@GetMapping("/public")
	public String publica() {
		return "Hola mundo sin seguridad";
	}
	
	// Ruta con rol
	@GetMapping("/rol")
	public String role() {
		return "Hola mundo con seguridad y un rol";
	}
	
	// Ruta con permisos
	@GetMapping("/permiso")
	public String permiso() {
		return "Hola mundo con seguridad y permisos";
	}
	
	// Ruta por defecto
	@GetMapping("/default")
	public String defecto() {
		return "Hola mundo con seguridad";
	}
}
