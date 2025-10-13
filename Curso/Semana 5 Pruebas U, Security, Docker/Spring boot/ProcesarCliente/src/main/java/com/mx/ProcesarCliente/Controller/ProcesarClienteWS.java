package com.mx.ProcesarCliente.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ProcesarCliente.Entity.*;
import com.mx.ProcesarCliente.Repository.IContactoRepository;
import com.mx.ProcesarCliente.Repository.IContratoRepository;
import com.mx.ProcesarCliente.Repository.IProductoRepository;
import com.mx.ProcesarCliente.Service.ProcesarClienteServiceImp;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/procesar-cliente")
@CrossOrigin
public class ProcesarClienteWS {
	@Autowired
	private ProcesarClienteServiceImp service;
	
	@Autowired
	private IProductoRepository daoProd;
	
	@Autowired
	private IContratoRepository daoContrato;
	
	@Autowired
	private IContactoRepository daoContacto;
	
	@PostMapping
	public ResponseEntity<?> procesarCli(@Valid @RequestBody Cliente cliente) {
		
		HashMap<String, String> errores = new HashMap<>();
		
	    if (service.clienteExistente(cliente.getIdClienteDigital())) {
	        errores.put("idClienteDigital", "El cliente con ID " + cliente.getIdClienteDigital() + " ya existe en la BD");
	    }

	    if (service.curpExistente(cliente.getCurp())) {
	        errores.put("curp", "El cliente con CURP " + cliente.getCurp() + " ya existe en la BD");
	    }

	    Contrato contrato = cliente.getContrato();
	    if (daoContrato.existsById(contrato.getIdContrato())) {
	        errores.put("contrato", "El contrato con ID " + contrato.getIdContrato() + " ya existe en la BD");
	    }

	    Contacto contacto = cliente.getContacto();
	    if (daoContacto.existsByEmail(contacto.getEmail())) {
	        errores.put("contacto.email", "El email " + contacto.getEmail() + " ya está en uso");
	    }

	    if (daoContacto.existsByTelefono(contacto.getTelefono())) {
	        errores.put("contacto.telefono", "El teléfono " + contacto.getTelefono() + " ya está en uso");
	    }

	    if (!errores.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
	    }
		
		Producto producto = cliente.getProductoId();
		if (!daoProd.existsById(producto.getIdProducto())) {
			daoProd.save(producto);
		}
		
		service.ProcesarCliente(cliente);
		return ResponseEntity.ok("El cliente fue guardado correctamente");
	}
	
	@GetMapping("/listar-clientes")
	public ResponseEntity<?> listarClientes() {
		List<Cliente> lista = service.listarClientes();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay clientes registrados");
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listar-beneficiarios")
	public ResponseEntity<?> listarBeneficiarios() {
		List<Beneficiario> lista = service.listarBeneficiarios();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay beneficiarios registrados");
		}
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listar-contactos")
	public ResponseEntity<?> listarContactos() {
		List<Contacto> lista = service.listarContactos();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay contactos registrados");
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listar-contratos")
	public ResponseEntity<?> listarContratos() {
		List<Contrato> lista = service.listarContratos();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay contratos registrados");
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listar-documentacion")
	public ResponseEntity<?> listarDocumentacion() {
		List<Documentacion> lista = service.listarDocumentacion();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay documentación registrada");
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listar-domicilios")
	public ResponseEntity<?> listarDomicilios() {
		List<Domicilio> lista = service.listarDomicilios();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay domicilios registrados");
		}
		return ResponseEntity.ok(lista);
	}

	@GetMapping("/listar-productos")
	public ResponseEntity<?> listarProductos() {
		List<Producto> lista = service.listarProductos();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay productos registrados");
		}
		return ResponseEntity.ok(lista);
	}
}
