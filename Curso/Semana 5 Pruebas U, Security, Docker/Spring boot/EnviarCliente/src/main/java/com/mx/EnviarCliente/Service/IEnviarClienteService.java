package com.mx.EnviarCliente.Service;

import org.springframework.http.ResponseEntity;

import com.mx.EnviarCliente.Entity.ClienteRequest;

public interface IEnviarClienteService {
	public ResponseEntity<String> enviarCliente(ClienteRequest clienteRequest);
}
