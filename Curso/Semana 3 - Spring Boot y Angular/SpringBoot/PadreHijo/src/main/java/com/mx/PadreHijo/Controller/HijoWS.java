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

import com.mx.PadreHijo.Dominio.Hijo;
import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.HijoServiceImp;

@RestController
@RequestMapping("/api/Hijo")
@CrossOrigin
public class HijoWS {
	@Autowired
	private HijoServiceImp service;
	
	@GetMapping(value = "listar")
	public List<Hijo> listar(){
		return service.listar();
	}
	
	@PostMapping(value = "guardar")
	/*public void guardar(@RequestBody Hijo hijo) {
		service.guardar(hijo);
	}*/
	public ResponseEntity<String> guardar(@RequestBody Hijo hijo){
		Hijo encontrado = service.buscar(hijo.getIdHijo());
		if(encontrado == null){
			service.guardar(hijo);
			return ResponseEntity.ok("El hijo " + hijo.getNombre() + " se guardo correctamente");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body("Este registro ya existe en la BD");
		}
	}
	
	@PostMapping(value = "editar")
	public void editar(@RequestBody Hijo hijo) {
		service.editar(hijo);
	}
	
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Hijo hijo) {
		service.eliminar(hijo.getIdHijo());
	}
	
	@PostMapping(value = "buscar")
	public Hijo buscar(@RequestBody Hijo hijo) {
		return service.buscar(hijo.getIdHijo());
	}
}
