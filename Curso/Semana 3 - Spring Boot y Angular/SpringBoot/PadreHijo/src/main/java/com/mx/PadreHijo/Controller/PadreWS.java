package com.mx.PadreHijo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.PadreServiceImp;

@RestController
@RequestMapping("/api/Padre")
@CrossOrigin
public class PadreWS {
	@Autowired
	private PadreServiceImp service;

	@GetMapping(value = "listar")
	public List<Padre> listar(){
		return service.listar();
	}
	
	@PostMapping(value = "guardar")
	/*public void guardar(@RequestBody Padre padre) {
		service.guardar(padre);
	}*/
	
	public ResponseEntity<String> guardar(@RequestBody Padre padre){
		Padre encontrado = service.buscar(padre.getIdPadre());
		if(encontrado == null){
			service.guardar(padre);
			return ResponseEntity.ok("El padre " + padre.getNombre() + " se guardo correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body("Este registro ya existe en la BD");
		}
	}
	
	@PostMapping(value = "editar")
	public void editar(@RequestBody Padre padre) {
		service.editar(padre);
	}
	
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Padre padre) {
		service.eliminar(padre.getIdPadre());
	}
	
	@PostMapping(value = "buscar")
	public Padre buscar(@RequestBody Padre padre) {
		return service.buscar(padre.getIdPadre());
	}
	
}
