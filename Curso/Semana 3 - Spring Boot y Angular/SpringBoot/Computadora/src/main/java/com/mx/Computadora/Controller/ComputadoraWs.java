package com.mx.Computadora.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Computadora.Dominio.Computadora;
import com.mx.Computadora.Service.ComputadoraServiceImp;

@RestController // Es la anotación que se utiliza para crear controladores RESTFUL. Un controlador RESTFUL es un componente que maneja
// las solicitudes HTTP y proporciona una respuesta HTTP adecuada
@RequestMapping(path = "api/Compu") // Es la anotación en Spring que utiliza para asignar un URL a un método de controlador o una clase
// completa de controladores (Sera la ruta base)
@CrossOrigin // es para darle permiso a los clientes que consuman mi ruta
public class ComputadoraWs {
	// inyección de el service
	@Autowired
	private ComputadoraServiceImp service;
	
	/* URL = PROTOCOLO://HOST:PUERTO/PATH
	 * PUERTO POR DEFECTO DE SPRING ES 8080
	 * http://localhost:8080/api/Compu
	 * 
	 * */
	
	// LISTAR -> http://localhost:8080/api/Compu/listar
	@GetMapping(value = "listar") // es una anotación que se utiliza para mapear una solicitud HHTP GET a un método en específico en un 
	// controlador: Es una combinación de @RequestMapping y @GetMapping lo que significa que solo se aceptaran solicitudes HTTP GET en el 
	// método anotado, si se utiliza (value = "Ejemplo") se esta agregando un recurso extra a la ruta.
	public List<Computadora> listar() {
		return service.listar();	
	}
	
	// GUARDAR -> http://localhost:8080/api/Compu/guardar
	@PostMapping(value = "guardar")
	public void guardar(@RequestBody Computadora computadora) { // @RequestBody es para especificar que en la solicitud HHTP debo incluir un cuerpo
		service.guardar(computadora);
	}
	
	// BUSCAR -> http://localhost:8080/api/Compu/buscar
	@PostMapping(value = "buscar")
	public Computadora buscar(@RequestBody Computadora computadora) { 
		return service.buscar(computadora);
	}
	
	// ELIMINAR -> http://localhost:8080/api/Compu/eliminar
	@DeleteMapping(value = "eliminar")
	public void eliminar(@RequestBody Computadora computadora) {
		service.eliminar(computadora);
	}
	
	// EDITAR -> http://localhost:8080/api/Compu/editar
	@PostMapping(value = "editar")
	public void editar(@RequestBody Computadora computadora) { 
		service.editar(computadora);
	}
	
}
