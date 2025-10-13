package com.mx.Operacion.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Operacion.Entity.Operacion;
import com.mx.Operacion.Service.OperacionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/operacion")
@CrossOrigin
public class OperacionWS {
	
	@Autowired
	private OperacionService service;
	
	@PostMapping
	public ResponseEntity<?> enviarOperacion(@Valid @RequestBody Operacion operacion) {
		BigDecimal nuevoImporte = redondearImporte(operacion.getImporte());
		operacion.setImporte(nuevoImporte);
		
		String hash = service.generarSha512(operacion);
		if(!operacion.getSha().equals(hash)){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La operación no puede continuar ya que los datos no coinciden");
		}
		
		// operacion.setSha(hash);
		
		ResponseEntity<?> response = service.guardarOperacion(operacion);
		if(response.getStatusCode() != HttpStatus.OK) {
			return ResponseEntity.internalServerError().build();
		}
		
		return response;
	}
	
	private BigDecimal redondearImporte(BigDecimal importe) {
       importe = importe.setScale(2, RoundingMode.HALF_UP);  // Se redondea a 2 decimales para garantizar que no existan valores de más decimales 
       return importe;
	}
}
