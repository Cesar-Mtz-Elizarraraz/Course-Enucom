package com.mx.PadreHijo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.PadreHijo.Dominio.Padre;
import com.mx.PadreHijo.Service.PadreServiceImp;

@Controller // Funciona como RestController, pero este se usa para comunicar clases entre spring, usando con thymelife
@RequestMapping("/")
public class PruebaController {
	
	public @ResponseBody String Prueba() {
		return "Hola Mundo";
	}
	
	@Autowired
	private PadreServiceImp service;
	
	@GetMapping
	// ESta es una interfaz que ya esta definida y nos agrega los atributos
	public String index(Model model) {
		var lista = service.listar();
		model.addAttribute("lista", lista);
		return "index"; // "index" es el html
	}
	
	// Método para abrir la pagina de guardar 
	@GetMapping(path = "/nuevo")
	public String nuevo(Padre padre, Model model){ 
		model.addAttribute("padre", padre);
		return "guardar";
	}
	
	// Método para guardar el registro en la base de datos 
	@PostMapping(path = "/guardar")
	public String guardar(Padre padre){ 
		service.guardar(padre);
		return "redirect:/";
	}
	
	// Método para abrir la página
	@GetMapping(path = "/abrirEditar/{idPadre}")
	public String abrirEditar(Padre padre, Model model){ 
		padre = service.buscar(padre.getIdPadre());
		model.addAttribute("padre", padre);
		return "editar";
	}
	
	// Método para editar el registro en la base de datos 
	@PostMapping(path = "/editar")
	public String editar(Padre padre){ 
		service.editar(padre);
		return "redirect:/";
	}
	
	// Método para eliminar el registro en la base de datos 
	@PostMapping(path = "/eliminar/{idPadre}")
	public String eliminar(Padre padre){ 
		service.eliminar(padre.getIdPadre());
		return "redirect:/";
	}
}
