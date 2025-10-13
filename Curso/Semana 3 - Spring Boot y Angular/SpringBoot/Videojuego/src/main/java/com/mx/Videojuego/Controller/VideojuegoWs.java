package com.mx.Videojuego.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Videojuego.Dominio.Videojuego;
import com.mx.Videojuego.Service.VideojuegoServiceImp;

@RestController 
@RequestMapping(path = "api/VJuego")
@CrossOrigin 
public class VideojuegoWs {
	@Autowired
	private VideojuegoServiceImp service;
	
	// URL = http://localhost:8081/api/VJuego
	
	@GetMapping(value = "listar")
	public List<Videojuego> listar() {
		return service.listar();
	}
	
	// URL + /guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Videojuego videojuego) {
		service.guardar(videojuego);
	}
	
	// URL + /editar
	@PostMapping(value = "editar")
	public void editar(@RequestBody Videojuego videojuego) {
		service.editar(videojuego);
	}
	
	// URL + /eliminar
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Videojuego videojuego) {
		service.eliminar(videojuego);
	}
	
	// URL + /buscar
	@PostMapping(value = "buscar")
	public Videojuego buscar(@RequestBody Videojuego videojuego) {
		return service.buscar(videojuego);
	}
}
