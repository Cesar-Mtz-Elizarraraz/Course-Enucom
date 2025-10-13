package com.mx.Book.Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Book.Entity.Book;
import com.mx.Book.Service.BookServiceImp;

@RestController
@RequestMapping(path = "/api/books")
@CrossOrigin
public class BookController {
	@Autowired // Patron de diseño de control
	private BookServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable int id) {
		Book foundBook = service.buscar(id);
		
		
		if(foundBook == null) {
			HashMap<String, String> hash = new HashMap<String, String>();
			hash.put("error", "Libro no encontrado");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hash);
		} else {
			return ResponseEntity.ok(foundBook);
		}
		
	}
}
