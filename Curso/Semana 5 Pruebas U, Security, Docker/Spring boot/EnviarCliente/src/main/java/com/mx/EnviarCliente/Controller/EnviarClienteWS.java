package com.mx.EnviarCliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.EnviarCliente.Entity.ClienteRequest;
import com.mx.EnviarCliente.Service.EnviarClienteServiceImp;

@RestController
@RequestMapping("/enviar-cliente")
@CrossOrigin
public class EnviarClienteWS {
	@Autowired
	private EnviarClienteServiceImp service;
	
	@PostMapping
	public ResponseEntity<String> procesarCli(@RequestBody ClienteRequest clienteRequest) {
		return service.enviarCliente(clienteRequest);
	}
}
