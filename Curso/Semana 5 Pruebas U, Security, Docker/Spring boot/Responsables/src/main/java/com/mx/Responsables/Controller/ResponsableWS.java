package com.mx.Responsables.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Responsables.DTOs.ResponsableVeterinariaDTO;
import com.mx.Responsables.Entity.Responsable;
import com.mx.Responsables.Service.ResponsableServiceImp;

@RestController
@RequestMapping("/responsable")
public class ResponsableWS {
	@Autowired
	private ResponsableServiceImp service;
	
	@GetMapping
	public ResponseEntity<List<Responsable>> listar(){
		return ResponseEntity.ok(service.listar());
	}
	
	@PostMapping
	public ResponseEntity<String> guardar(@RequestBody Responsable responsable) {
		if(service.contactoExistente(responsable.getContacto())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de contacto '" + responsable.getContacto() + "' ya se encuentra registrado");
		}
		service.guardar(responsable);
		return ResponseEntity.ok("El responsable " + responsable.getNombre() + " se registro correctamente");
	}
	
	@PutMapping("/{idResponsable}")
	public ResponseEntity<String> editar(@PathVariable Integer idResponsable, @RequestBody Responsable responsable) {
		if(service.contactoExistenteEditar(responsable.getContacto(), idResponsable)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de contacto '" + responsable.getContacto() + "' ya se encuentra registrado");
		}
		responsable.setIdResponsable(idResponsable);
		service.editar(responsable);
		return ResponseEntity.ok("El responsable " + responsable.getNombre() + " se edito correctamente");
	}
	
	@GetMapping("/{idResponsable}")
	public ResponseEntity<?> buscar(@PathVariable Integer idResponsable) {
		Responsable encontrado = service.buscar(idResponsable);
		if(encontrado == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El responsable no fue encontrado");
		return ResponseEntity.ok(encontrado);
	}
	
	@DeleteMapping("/{idResponsable}")
	public ResponseEntity<Responsable> eliminar(@PathVariable Integer idResponsable) {
		Responsable encontrado = service.buscar(idResponsable);
		service.eliminar(idResponsable);
		return ResponseEntity.ok(encontrado);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<ResponsableVeterinariaDTO>> listarFull(){
		return ResponseEntity.ok(service.obtenerResponsablesConVeterinaria());
	}
	
}
