package com.mx.PadreHijo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mx.PadreHijo.Dominio.Hijo;
import com.mx.PadreHijo.Service.HijoServiceImp;

@Controller
@RequestMapping("/hijo")
public class HijoController {
	@Autowired
	private HijoServiceImp service;
	
	@GetMapping
	public String index(Model model) {
		var lista = service.listar();
		model.addAttribute("lista", lista);
		return "indexHijo";
	}
	
	@GetMapping(path = "/nuevoH")
	public String nuevo(Hijo hijo, Model model){ 
		model.addAttribute("hijo", hijo);
		return "guardarHijo";
	}

	@PostMapping(path = "/guardarH")
	public String guardar(Hijo hijo, RedirectAttributes redirectAttributes){ 
		service.guardar(hijo);
		// Mandar un mensaje "flash" para la vista de "/hijo"
	    redirectAttributes.addFlashAttribute("exito", "El hijo " + hijo.getNombre() + " se ha guardado correctamente");
		return "redirect:/hijo";
	}

	@GetMapping(path = "/abrirEditarH/{idHijo}")
	public String abrirEditar(Hijo hijo, Model model){ 
		hijo = service.buscar(hijo.getIdHijo());
		model.addAttribute("hijo", hijo);
		return "editarHijo";
	}

	@PostMapping(path = "/editarH")
	public String editar(Hijo hijo, RedirectAttributes redirectAttributes){ 
		service.editar(hijo);
		// Mandar un mensaje "flash" para la vista de "/hijo"
	    redirectAttributes.addFlashAttribute("exito", "El hijo " + hijo.getNombre() + " se ha editado correctamente");
		return "redirect:/hijo";
	}

	@PostMapping(path = "/eliminarH/{idHijo}")
	public String eliminar(Hijo hijo, RedirectAttributes redirectAttributes){ 
		service.eliminar(hijo.getIdHijo());
		redirectAttributes.addFlashAttribute("exito", "El hijo " + hijo.getNombre() + " se ha eliminado correctamente");
		return "redirect:/hijo";
	}
}
