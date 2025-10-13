package com.mx.UsuarioRol.Controller;

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

import com.mx.UsuarioRol.Dominio.Rol;
import com.mx.UsuarioRol.Service.RolServiceImp;

@RestController
@RequestMapping("/api/Rol")
@CrossOrigin
public class RolWS {
	@Autowired
	private RolServiceImp service;
	
	@GetMapping(value = "listar")
	public List<Rol> listar(){
		return service.listar();
	}
	
	@PostMapping(value = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Rol rol){
		/* BANDERAS
		 * 1. ID DUPLICADO
		 * 2. PRIVILEGIO DUPLICADO
		 * */
		int bandera = validaciones(rol, "insert");
		switch(bandera) {
			case 1: 
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un rol con ese ID registrado en la base de datos");
			case 2:
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un rol con ese privilegio registrado en la base de datos");
			default: 
				service.guardar(rol);
				return ResponseEntity.ok("El rol " + rol.getPrivilegio() + " ha sido registrado correctamente");
		}
	}
	
	@PostMapping(value = "editar")
	public ResponseEntity<String> editar(@RequestBody Rol rol) {
		/* BANDERAS
		 * 1. ID DUPLICADO
		 * 2. PRIVILEGIO DUPLICADO
		 * */
		int bandera = validaciones(rol, "update");
		switch(bandera) {
			case 2:
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un rol con ese privilegio registrado en la base de datos");
			default: 
				service.guardar(rol);
				return ResponseEntity.ok("El rol " + rol.getPrivilegio() + " ha sido actualizado correctamente");
		}
	}
	
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Rol rol) {
		service.eliminar(rol.getIdRol());
	}
	
	@PostMapping(value = "buscar")
	public Rol buscar(@RequestBody Rol rol) {
		return service.buscar(rol.getIdRol());
	}
	
	private int validaciones(Rol rol, String accion) {
		Rol encontrado;
		if(accion == "insert") {
			encontrado = service.buscar(rol.getIdRol());
			if(encontrado != null) return 1;
		}
		
		encontrado = service.buscarPorPrivilegio(rol.getPrivilegio());
		if(encontrado != null && encontrado.getIdRol() != rol.getIdRol()) return 2;
		
		return 0;
	}
}
