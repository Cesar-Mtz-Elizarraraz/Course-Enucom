package com.mx.Empleado.Controller;

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

import com.mx.Empleado.Entity.Empleado;
import com.mx.Empleado.Service.EmpleadoServiceImp;

@RestController
@RequestMapping(path = "/E")
// @CrossOrigin
public class EmpleadoWS {
	@Autowired
	private EmpleadoServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Empleado> lista = service.listar();
		/*if(lista.isEmpty()) {
			return ResponseEntity.badRequest().body("No hay registros existentes");
		}*/
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{idEmpleado}")
	public ResponseEntity<?> buscar(@PathVariable int idEmpleado) {
		Empleado encontrado = service.buscar(idEmpleado);
		if(encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en la base de datos");
		}
		return ResponseEntity.ok(encontrado);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Empleado empleado) {
		if(service.existeTelefono(empleado.getTelefono())) {
			return ResponseEntity.badRequest().body("Este número de telefono ya se encuentra registrado");
		}
		
		if(service.existeEmpleado(empleado.getNombre(), empleado.getApellido())) {
			return ResponseEntity.status(HttpStatus.FOUND).body("El emplado " + empleado.getNombre() + " " + empleado.getApellido() + " ya esta registrado en la base de datos");
		}
		service.guardar(empleado);
		return ResponseEntity.ok("El empleado " + empleado.getNombre() + " se registro correctamente");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Empleado empleado) {
		service.editar(empleado);
		return ResponseEntity.ok("El empleado " + empleado.getNombre() + " se actualizo correctamente");
	}
	
	@DeleteMapping("/{idEmpleado}")
	public ResponseEntity<?> eliminar(@PathVariable int idEmpleado) {
		Empleado encontrado = service.buscar(idEmpleado);
		if(encontrado == null){
			return ResponseEntity.notFound().build();
		} else {
			service.eliminar(idEmpleado);
			return ResponseEntity.ok(encontrado);
		}
	}
}
