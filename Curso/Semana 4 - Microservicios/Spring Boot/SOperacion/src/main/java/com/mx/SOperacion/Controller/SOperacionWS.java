package com.mx.SOperacion.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.SOperacion.Entity.SOperacion;
import com.mx.SOperacion.Service.SOperacionServiceImp;

@RestController
@RequestMapping(path = "/api/SOperacion")
@CrossOrigin
public class SOperacionWS {
	
	@Autowired
	private SOperacionServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<SOperacion> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody SOperacion sOperacion) {
		sOperacion.setReferencia(generarReferencia());
		sOperacion.setEstatus("Aprobada");
		service.guardar(sOperacion);
		
		return ResponseEntity.ok(sOperacion);
	}
	
	private int generarReferencia() {
        Random random = new Random();
        return 100000 + random.nextInt(900000); // entre 100000 y 999999
    }
}
