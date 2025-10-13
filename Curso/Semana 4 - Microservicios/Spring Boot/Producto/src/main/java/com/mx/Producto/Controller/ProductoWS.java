package com.mx.Producto.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Producto.DTOs.ProductoCatProvDTO;
import com.mx.Producto.Entity.Producto;
import com.mx.Producto.Service.ProductoServiceImp;

@RestController
@RequestMapping(path = "/P")
// @CrossOrigin
public class ProductoWS {
	
	@Autowired
	private ProductoServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Producto> lista = service.listar();
		/*if(lista == null || lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lista);
		}*/
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Producto producto) {
		Producto prod = service.buscar(producto.getCodigoBarras());
		if(prod != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("El código de barras " + producto.getCodigoBarras() + " ya fue registrado en la base de datos");
		} 
		
		if(service.productoExistente(producto.getNombre())) {
			return ResponseEntity.status(HttpStatus.FOUND).body("El producto '" + producto.getNombre() + "' ya fue registrado en la base de datos");
		}
		
		service.guardar(producto);
		return ResponseEntity.ok("El producto " + producto.getNombre() + " se registro correctamente");
		
	}
	
	@GetMapping("/{codigoBarras}")
	public ResponseEntity<?> buscar(@PathVariable Long codigoBarras) {
		Producto encontrado = service.buscar(codigoBarras);
		if (encontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El producto con código de barras " + codigoBarras + " no esta registrado en la base de datos"
					);
		} else {
			return ResponseEntity.ok(encontrado);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Producto producto){
		if (service.productoExistenteDiferenteCodigoBarras(producto.getNombre(), producto.getCodigoBarras())) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Ya existe otro producto con el nombre '" + producto.getNombre() + "'");
		}
		service.editar(producto);
		return ResponseEntity.ok("El producto " + producto.getNombre() + " se actualizo correctamente");
	}
	
	@PutMapping("editarMultiple")
	public ResponseEntity<?> editarMultiple(@RequestBody List<Producto> productos){
		service.editarMultiple(productos);
		return ResponseEntity.ok("Los productos se actualizaron correctamente");
	}
	
	@DeleteMapping("/{codigoBarras}")
	public ResponseEntity<?> eliminar(@PathVariable Long codigoBarras){
		Producto eliminado = service.buscar(codigoBarras);
		if (eliminado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					"El producto con código de barras " + codigoBarras + " no esta registrado en la base de datos"
					);
		} else {
			service.eliminar(codigoBarras);
			return ResponseEntity.ok(eliminado);
		}
	}
	
	@GetMapping("/buscarPorCategoria/{categoriaId}")
	public ResponseEntity<?> buscarPorCategoria(@PathVariable int categoriaId){
		List<Producto> prod = service.buscarPorCategoria(categoriaId);
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping("/buscarPorProveedor/{proveedorId}")
	public ResponseEntity<?> buscarPorProveedor(@PathVariable int proveedorId){
		List<Producto> prod = service.buscarPorProveedor(proveedorId);
		return ResponseEntity.ok(prod);
	}
	
	@GetMapping("/listarFull")
	public ResponseEntity<?> listarFull() {
		List<ProductoCatProvDTO> lista = service.obtenerProductosCatProv();
		if(lista == null || lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
}
