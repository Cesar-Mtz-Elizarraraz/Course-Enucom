package com.mx.AutorLibro.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.AutorLibro.Dominio.Autor;
import com.mx.AutorLibro.Dominio.Libro;
import com.mx.AutorLibro.Service.AutorServiceImp;
import com.mx.AutorLibro.Service.LibroServiceImp;

@RestController
@RequestMapping("api")
@CrossOrigin
public class BibliotecaController {
	@Autowired
	private AutorServiceImp serviceAutor;
	@Autowired
	private LibroServiceImp serviceLibro;
	
	@PostMapping("/autores")
	public HashMap<String, Object> crearAutor(@RequestBody Autor autor) {
		serviceAutor.guardar(autor);
		
	    HashMap<String, Object> response = new HashMap<String, Object>();
	    response.put("data", autor);
	    response.put("message", "Autor creado exitosamente");
	    
		return response;
	}
	
	@PostMapping("/autores/{autorId}/libros")
	public HashMap<String, Object>  crearLibroAutor(@PathVariable int autorId, @RequestBody Libro libro) {
		Autor autor = serviceAutor.buscar(autorId);
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		if(autor == null) {
			response.put("message", "Libro no registrado. El autor ingresado no existe");
		} else {
			libro.setAutorId(autor);
			serviceLibro.guardar(libro);
			response.put("data", libro);
			response.put("message", "Libro creado y asignado exitosamente");
		}
		
		return response;
	}
	
	@GetMapping("/autores")
	public Autor buscarAutorPorId(@RequestParam int id) {
		return serviceAutor.buscar(id);
	}
	
	@GetMapping("/autores/{autorId}/libros")
	public List<Libro> obtenerLibrosPorAutor(@PathVariable int autorId) {
		List<Libro> libros = serviceAutor.findLibrosByAutor(autorId);
		
		return libros;
	}
	
	@GetMapping("/libros/{libroId}/autor")
	public Autor obtenerAutorDelLibro(@PathVariable int libroId) {
		Libro libro = serviceLibro.buscar(libroId);
		Autor autor = serviceAutor.buscar(libro.getAutorId().getIdAutor());
		return autor;
	}
	
	
}
