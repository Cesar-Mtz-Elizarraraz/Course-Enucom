package com.mx.UsuarioRol.Controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

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

import com.mx.UsuarioRol.Dominio.Usuario;
import com.mx.UsuarioRol.Service.UsuarioServiceImp;

@RestController
@RequestMapping("/api/Usuario")
@CrossOrigin
public class UsuarioWS {
	@Autowired
	private UsuarioServiceImp service;
	
	@GetMapping(value = "listar")
	public List<Usuario> listar(){
		return service.listar();
	}
	
	@PostMapping(value = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Usuario usuario){
		/* BANDERAS
		 * 1. ID DUPLICADO
		 * 2. NOMBRE DUPLICADO
		 * 3. CARACTERES INVALIDOS EN EL NOMBRE
		 * 4. EDAD NO PERMITIDA
		 * */
		int bandera = validaciones(usuario, "insert");
		switch(bandera) {
			case 1: 
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un usuario con ese ID registrado en la base de datos");
			case 2:
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un usuario con ese correo registrado en la base de datos");
			case 3:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre y los apellidos no deben contener caracteres especiales ni numéricos");
			case 4:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La edad del usuario debe ser mayor a 18 años");
			default: 
				service.guardar(usuario);
				return ResponseEntity.ok("El usuario " + usuario.getNombre() + " ha sido registrado correctamente");
		}
	}
	
	@PostMapping(value = "editar")
	public ResponseEntity<String> editar(@RequestBody Usuario usuario) {
		/* BANDERAS
		 * 1. ID DUPLICADO
		 * 2. NOMBRE DUPLICADO
		 * 3. CARACTERES INVALIDOS EN EL NOMBRE
		 * 4. EDAD NO PERMITIDA
		 * */
		int bandera = validaciones(usuario, "update");
		switch(bandera) {
			case 2:
				return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe un usuario con ese correo registrado en la base de datos");
			case 3:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El nombre y los apellidos no deben contener caracteres especiales ni numéricos");
			case 4:
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La edad del usuario debe ser mayor a 18 años");
			default: 
				service.editar(usuario);
				return ResponseEntity.ok("El usuario " + usuario.getNombre() + " ha sido actualizado correctamente");
		}
	}
	
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Usuario usuario) {
		service.eliminar(usuario.getIdUsuario());
	}
	
	@PostMapping(value = "buscar")
	public Usuario buscar(@RequestBody Usuario usuario) {
		return service.buscar(usuario.getIdUsuario());
	}
	
	private int validaciones(Usuario usuario, String accion) {
		Usuario encontrado;
		if(accion == "insert") {
			encontrado = service.buscar(usuario.getIdUsuario());
			if(encontrado != null) return 1;
		}
		
		encontrado = service.buscarPorCorreo(usuario.getCorreo());
		if(encontrado != null && encontrado.getIdUsuario() != usuario.getIdUsuario()) return 2;

		String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$"; // Expresión regular para validar que caracteres son permitidos
		if (!usuario.getNombre().matches(regex) || !usuario.getApp().matches(regex) || !usuario.getApm().matches(regex)) return 3;
		
		LocalDate hoy = LocalDate.now(); // El .now trae la fecha actual
	    Period edad = Period.between(usuario.getFechaNacimiento(), hoy); // Period.between(a, b) calcula la diferencia entre dos fechas
	    if(edad.getYears() < 18) return 4; // El .getYears obtiene el periodo en años que han pasado entre las dos fechas
		
		return 0;
	}
}
