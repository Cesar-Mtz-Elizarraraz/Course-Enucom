package com.mx.Cliente.Controller;

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

import com.mx.Cliente.Entity.Cliente;
import com.mx.Cliente.Service.ClienteServiceImp;

@RestController
@RequestMapping(path = "/Cli")
// @CrossOrigin
public class ClienteWS {
	@Autowired
	private ClienteServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Cliente> lista = service.listar();
		/*if(lista.isEmpty()) {
			return ResponseEntity.ofNullable("No existen registros en la base de datos");
		} else {
			return ResponseEntity.ok(lista);
		}*/
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Cliente cliente){
		service.guardar(cliente);
		return ResponseEntity.ok("El cliente " + cliente.getNombre() + " se guardo correctamente");
	}

	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Cliente cliente){
		service.editar(cliente);
		return ResponseEntity.ok("El cliente " + cliente.getNombre() + " se actualizo correctamente");
	}

	@GetMapping("/{idCliente}")
	public ResponseEntity<?> buscar(@PathVariable int idCliente){
		Cliente encontrado = service.buscar(idCliente);
		if(encontrado == null){
			return ResponseEntity.status(HttpStatus.FOUND).body("El cliente no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}

	@DeleteMapping("/{idCliente}")
	public ResponseEntity<?> eliminar(@PathVariable int idCliente){
		Cliente encontrado = service.buscar(idCliente);
		if(encontrado == null){
			return ResponseEntity.notFound().build();
		} else {
			service.eliminar(idCliente);
			return ResponseEntity.ok(encontrado);
		}
	}
}
