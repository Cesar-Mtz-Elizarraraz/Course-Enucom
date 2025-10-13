package com.mx.Mascotas.Controller;

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

import com.mx.Mascotas.DTOs.MascotaCliRespVetDTO;
import com.mx.Mascotas.Entity.Mascota;
import com.mx.Mascotas.Service.MascotaServiceImp;

@RestController
@RequestMapping("/mascota")
public class MascotaWS {
	@Autowired
	private MascotaServiceImp service;
	
	@GetMapping
	public ResponseEntity<List<Mascota>> listar(){
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<String> guardar(@RequestBody Mascota mascota) {
		service.guardar(mascota);
		return ResponseEntity.ok("La mascota " + mascota.getNombre() + " se registro correctamente");
	}

	@PutMapping("/{idMascota}")
	public ResponseEntity<String> editar(@PathVariable Integer idMascota, @RequestBody Mascota mascota) {
		mascota.setIdMascota(idMascota);
		service.editar(mascota);
		return ResponseEntity.ok("La mascota " + mascota.getNombre() + " se edito correctamente");
	}

	@GetMapping("/{idMascota}")
	public ResponseEntity<?> buscar(@PathVariable Integer idMascota) {
		Mascota encontrado = service.buscar(idMascota);
		if(encontrado == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La mascota no fue encontrada");
		return ResponseEntity.ok(encontrado);
	}

	@DeleteMapping("/{idMascota}")
	public ResponseEntity<Mascota> eliminar(@PathVariable Integer idMascota) {
		Mascota encontrado = service.buscar(idMascota);
		service.eliminar(idMascota);
		return ResponseEntity.ok(encontrado);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<MascotaCliRespVetDTO>> listarFull(){
		return ResponseEntity.ok(service.obtenerMascotasConCliRespVet());
	}
}
