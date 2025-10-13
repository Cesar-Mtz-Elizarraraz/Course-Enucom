package com.mx.Veterinarias.Controller;

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

import com.mx.Veterinarias.Entity.Veterinaria;
import com.mx.Veterinarias.Service.VeterinariaServiceImp;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaWS {
	@Autowired
	private VeterinariaServiceImp service;
	
	@GetMapping
	public ResponseEntity<List<Veterinaria>> listar(){
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<String> guardar(@RequestBody Veterinaria veterinaria) {
		if(service.telefonoExistente(veterinaria.getTelefono())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de teléfono '" + veterinaria.getTelefono() + "' ya se encuentra registrado");
		}
		service.guardar(veterinaria);
		return ResponseEntity.ok("La veterinaria " + veterinaria.getNombre() + " se registro correctamente");
	}

	@PutMapping("/{idVeterinaria}")
	public ResponseEntity<String> editar(@PathVariable Integer idVeterinaria, @RequestBody Veterinaria veterinaria) {
		if(service.telefonoExistenteEditar(veterinaria.getTelefono(), idVeterinaria)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de teléfono '" + veterinaria.getTelefono() + "' ya se encuentra registrado");
		}
		veterinaria.setIdVeterinaria(idVeterinaria);
		service.editar(veterinaria);
		return ResponseEntity.ok("La veterinaria " + veterinaria.getNombre() + " se edito correctamente");
	}

	@GetMapping("/{idVeterinaria}")
	public ResponseEntity<?> buscar(@PathVariable Integer idVeterinaria) {
		Veterinaria encontrado = service.buscar(idVeterinaria);
		if(encontrado == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La veterinaria no fue encontrado");
		return ResponseEntity.ok(encontrado);
	}

	@DeleteMapping("/{idVeterinaria}")
	public ResponseEntity<Veterinaria> eliminar(@PathVariable Integer idVeterinaria) {
		Veterinaria encontrado = service.buscar(idVeterinaria);
		service.eliminar(idVeterinaria);
		return ResponseEntity.ok(encontrado);
	}
}
