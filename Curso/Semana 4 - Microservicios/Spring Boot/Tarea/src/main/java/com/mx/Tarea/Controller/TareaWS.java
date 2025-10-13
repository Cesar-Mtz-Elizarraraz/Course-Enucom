package com.mx.Tarea.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Tarea.Entity.Tarea;
import com.mx.Tarea.Enum.EnumEstadoTarea;
import com.mx.Tarea.Service.TareaServiceImp;

@RestController
@RequestMapping(path = "/api/tareas")
@CrossOrigin
public class TareaWS {
	@Autowired
	private TareaServiceImp service;
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Tarea tarea) {

		boolean estadoValido = estadoValido(tarea.getEstado()); 
		if(!estadoValido) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estado ingresado no es una opción válida");
		}
		
		if(!tituloDescripcionValidos(tarea)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre y título son obligatorios");
		}
		
		if(!fechaVencimientoValida(tarea)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha de vencimiento no puede ser menor a la fecha de creación");
		}
		
		service.guardar(tarea);
		return ResponseEntity.ok("Tarea " + tarea.getTitulo() + " registrada correctamente");
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Tarea> lista = service.listar();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No existen registros en la base de datos");
		}
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		Tarea encontrada = service.buscar(id);
		if(encontrada == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en la base de datos");
		}	
		
		return ResponseEntity.ok(encontrada);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Tarea tarea) {
		Tarea encontrada = service.buscar(id);
		if(encontrada == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en la base de datos");
		}
		
		boolean estadoValido = estadoValido(encontrada.getEstado()); 
		if(!estadoValido) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estado ingresado no es una opción válida");
		}
		
		if(!tituloDescripcionValidos(tarea)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre y título son obligatorios");
		}
		
		if(!fechaVencimientoValida(tarea)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La fecha de vencimiento no puede ser menor a la fecha de creación");
		}
		
		tarea.setId(id);
		service.editar(tarea);
		return ResponseEntity.ok("Tarea " + encontrada.getTitulo() + " actualizada correctamente");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable int id) {
		service.eliminar(id);
		return ResponseEntity.ok("Tarea eliminada correctamente");
	}
	
	@PatchMapping("/{id}/estado")
	public ResponseEntity<?> cambiarEstado(@PathVariable int id, @RequestBody String estado) {
		Tarea encontrada = service.buscar(id);
		if(encontrada == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro no existe en la base de datos");
		}
		
		boolean estadoValido = estadoValido(encontrada.getEstado()); 
		if(!estadoValido) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El estado ingresado no es una opción válida");
		}
		
		encontrada.setEstado(estado);
		service.editar(encontrada);
		return ResponseEntity.ok("El estado de la tarea " + encontrada.getTitulo() + " se actualizo correctamente");
	}
	
	// MÉTODO PERSONALIZADO PARA VALIDAR ESTADO
	private boolean estadoValido(String estado) {
		try {
		    Enum.valueOf(EnumEstadoTarea.class, estado);
		    return true;
		} catch (IllegalArgumentException e) {
		    return false;
		}
	}
	
	// MÉTODO PERSONALIZADO PARA VALIDAR TÍTULO Y DESCRIPCIÓN
	private boolean tituloDescripcionValidos(Tarea tarea) {
		return !(tarea.getTitulo().isEmpty() || tarea.getDescripcion().isEmpty());
	}
	
	// MÉTODO PERSONALIZADO PARA VALIDAR FECHA DE VENCIMIENTO
	private boolean fechaVencimientoValida(Tarea tarea) {
		LocalDate fechaActual = LocalDate.now();
		return !(fechaActual.isAfter(tarea.getFechaVencimiento()));
	}
}
