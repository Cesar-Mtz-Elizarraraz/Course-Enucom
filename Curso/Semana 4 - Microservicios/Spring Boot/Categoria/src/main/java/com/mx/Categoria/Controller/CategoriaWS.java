package com.mx.Categoria.Controller;

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

import com.mx.Categoria.Entity.Categoria;
import com.mx.Categoria.Service.CategoriaServiceImp;

@RestController
@RequestMapping(path = "/C")
// @CrossOrigin
public class CategoriaWS {
	@Autowired
	private CategoriaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Categoria> lista = service.listar();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Categoria categoria){
		if(service.categoriaExistente(categoria.getNombre())) {
			return ResponseEntity.status(HttpStatus.FOUND).body("La categoría '" + categoria.getNombre() + "' ya fue registrada en la base de datos");
		}
		
		service.guardar(categoria);
		return ResponseEntity.ok("El registro " + categoria.getNombre() + " se guardo correctamente");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Categoria categoria){
		if (service.categoriaExistenteDiferenteID(categoria.getNombre(), categoria.getIdCategoria())) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe otra categoría con el nombre '" + categoria.getNombre() + "'");
		}
		service.editar(categoria);
		return ResponseEntity.ok("El registro " + categoria.getNombre() + " se actualizo correctamente");
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<?> buscar(@PathVariable int idCategoria){
		Categoria encontrado = service.buscar(idCategoria);
		if(encontrado == null){
			return ResponseEntity.status(HttpStatus.FOUND).body("El registro no existe en la base de datos");
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<?> eliminar(@PathVariable int idCategoria){
		Categoria encontrado = service.buscar(idCategoria);
		if(encontrado == null){
			return ResponseEntity.notFound().build();
		} else {
			service.eliminar(idCategoria);
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@GetMapping("/productos/{categoriaId}")
	public ResponseEntity<?> obtenerProductos(@PathVariable int categoriaId){
		return ResponseEntity.ok(service.obtenerCategoriaConProductos(categoriaId));
	}
	
}
