package com.mx.Operacion.Service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mx.Operacion.DTOs.SOperacionDTO;
import com.mx.Operacion.Entity.Operacion;
import com.mx.Operacion.FeignClient.SOperacionClient;
import com.mx.Operacion.Util.HashUtil;

@Service
public class OperacionService {
	public String generarSha512(Operacion operacion) {
		String cadena = operacion.getOperacion() + operacion.getImporte() + operacion.getCliente();
		String hash = HashUtil.sha512(cadena);
		return hash;
	}
	
	@Autowired
	private SOperacionClient sOperacionFC;
	public ResponseEntity<?> guardarOperacion(Operacion operacion) {
		SOperacionDTO operacionDTO = new SOperacionDTO();
		operacionDTO.setOperacion(operacion.getOperacion());
		operacionDTO.setCliente(operacion.getCliente());
		operacionDTO.setImporte(operacion.getImporte());
		
		ResponseEntity<SOperacionDTO> response = sOperacionFC.guardar(operacionDTO);
		
		if(response.getStatusCode() != HttpStatus.OK) {
			return ResponseEntity.internalServerError().build();
		}
		
		SOperacionDTO responseDTO = response.getBody();
		HashMap<String, Object> newResponse = new HashMap<>();
		
		newResponse.put("id", responseDTO.getId());
		newResponse.put("estatus", responseDTO.getEstatus());
		newResponse.put("operacion", responseDTO.getOperacion());
		newResponse.put("referencia", responseDTO.getReferencia());
		
		/*
		SOperacionDTO newResponse = new SOperacionDTO(
			responseDTO.getId(),
			responseDTO.getEstatus(),
			responseDTO.getReferencia(),
			responseDTO.getOperacion()
		);*/
		
		return ResponseEntity.ok(newResponse);
	}
}
