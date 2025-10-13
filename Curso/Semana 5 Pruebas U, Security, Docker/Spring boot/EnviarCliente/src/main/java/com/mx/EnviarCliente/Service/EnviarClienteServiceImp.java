package com.mx.EnviarCliente.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mx.EnviarCliente.DTOs.ClienteDTO;
import com.mx.EnviarCliente.DTOs.Producto;
import com.mx.EnviarCliente.Entity.ClienteRequest;
import com.mx.EnviarCliente.FeignClient.ProcesarClienteFeignClient;

import feign.FeignException;

@Service
public class EnviarClienteServiceImp implements IEnviarClienteService {

	@Autowired
	private  ProcesarClienteFeignClient procesarCliFC;
	
	@Override
	public ResponseEntity<String> enviarCliente(ClienteRequest clienteRequest) {
		ClienteDTO dto = new ClienteDTO();
		
		dto.setIdClienteDigital(clienteRequest.getIdClienteDigital());
	    dto.setNombre(clienteRequest.getNombre());
	    dto.setApellidoPaterno(clienteRequest.getApellidoPaterno());
	    dto.setApellidoMaterno(clienteRequest.getApellidoMaterno());
	    dto.setGenero(clienteRequest.getGenero());
	    dto.setFechaNacimiento(clienteRequest.getFechaNacimiento());
	    dto.setCurp(clienteRequest.getCurp());
	    dto.setContacto(clienteRequest.getContacto());
	    dto.setDomicilio(clienteRequest.getDomicilio());
	    dto.setDocumentacion(clienteRequest.getDocumentacion());
	    dto.setBeneficiario(clienteRequest.getBeneficiario());
	    dto.setContrato(clienteRequest.getContrato());
	    
	    Producto prodDTO = new Producto();
	    prodDTO.setIdProducto(clienteRequest.getIdProducto());
	    dto.setProductoId(prodDTO);
	    
	    try {
	        return procesarCliFC.procesarCli(dto);
	    } catch (FeignException e) {
	        String mensaje = e.contentUTF8(); // Mensaje original del otro servicio
	        int status = e.status(); // Status del ResponseEntity
	        return ResponseEntity.status(status).body(mensaje);
	    }
	}

}
