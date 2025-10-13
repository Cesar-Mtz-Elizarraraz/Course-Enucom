package com.mx.Clientes.Controller;

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

import com.mx.Clientes.Entity.Cliente;
import com.mx.Clientes.Service.ClienteServiceImp;

@RestController
@RequestMapping("/cliente")
public class ClienteWS {
	@Autowired
	private ClienteServiceImp service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listar(){
		return ResponseEntity.ok(service.listar());
	}

	@PostMapping
	public ResponseEntity<String> guardar(@RequestBody Cliente cliente) {
		if(service.contactoExistente(cliente.getContacto())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de contacto '" + cliente.getContacto() + "' ya se encuentra registrado");
		}
		service.guardar(cliente);
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cliente no fue encontrado");
		return ResponseEntity.ok("El cliente " + cliente.getNombre() + " se registro correctamente");
	}

	@PutMapping("/{idCliente}")
	public ResponseEntity<String> editar(@PathVariable Integer idCliente, @RequestBody Cliente cliente) {
		if(service.contactoExistenteEditar(cliente.getContacto(), idCliente)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El número de contacto '" + cliente.getContacto() + "' ya se encuentra registrado");
		}
		cliente.setIdCliente(idCliente);
		service.editar(cliente);
		return ResponseEntity.ok("El cliente " + cliente.getNombre() + " se edito correctamente");
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<?> buscar(@PathVariable Integer idCliente) {
		Cliente encontrado = service.buscar(idCliente);
		if(encontrado == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no fue encontrado");
		return ResponseEntity.ok(encontrado);
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Cliente> eliminar(@PathVariable Integer idCliente) {
		Cliente encontrado = service.buscar(idCliente);
		service.eliminar(idCliente);
		return ResponseEntity.ok(encontrado);
	}
}
