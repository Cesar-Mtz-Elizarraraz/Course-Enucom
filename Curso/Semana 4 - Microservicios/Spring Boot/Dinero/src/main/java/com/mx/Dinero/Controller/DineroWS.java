package com.mx.Dinero.Controller;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Dinero.Entity.Dinero;
import com.mx.Dinero.Entity.RetiroRequest;
import com.mx.Dinero.Service.DineroServiceImp;

@RestController
@RequestMapping(path = "/cajero")
// @CrossOrigin
public class DineroWS {
	@Autowired
	private DineroServiceImp service;
	
	// Solo para consulta
	@GetMapping
	public ResponseEntity<?> obtenerDineroDisponible(){
		List<Dinero> dinero = service.obtenerDenominacionesDisponibles();
		if(dinero.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay fondos en el cajero");
		}
		return ResponseEntity.ok(dinero);
	}
	
	// Solo para consulta
	@GetMapping("/fondos")
	public ResponseEntity<?> obtenerFondos(){
		double fondos = service.obtenerFondos().setScale(2, RoundingMode.CEILING).doubleValue();
		if(fondos == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay fondos en el cajero");
		}
		return ResponseEntity.ok(fondos);
	}
	
	@PostMapping("/retiro")
	public ResponseEntity<?> retiro(@RequestBody RetiroRequest retiro){
		double fondos = service.obtenerFondos().setScale(2, RoundingMode.CEILING).doubleValue();
		double montoRetiro = retiro.getMonto().setScale(2, RoundingMode.CEILING).doubleValue();
		
		if(fondos == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El cajero ya no cuenta con fondos :(");
		}
		
		if(fondos < montoRetiro) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Los fondos no son suficientes para el retiro");
		}
		
		List<Dinero> dineroBD = service.obtenerDenominacionesDisponibles();
		List<Dinero> dineroOcupado = new ArrayList<Dinero>();
		List<Dinero> dineroActualizado = new ArrayList<Dinero>();
		
		for(Dinero d : dineroBD){
			
			double denominacion = d.getDenominacion().doubleValue();
			
			if(denominacion <= montoRetiro) {
				int cantidadOriginal = d.getCantidad();
				int cantidadBM = cantidadBilletesMonedas(montoRetiro, d); // Calcular la cantidad de billestes y/o monedas a utilizar
				
		        Dinero dineroUsado = new Dinero();
		        dineroUsado.setIdDinero(d.getIdDinero());
		        dineroUsado.setTipo(d.getTipo());
		        dineroUsado.setDenominacion(d.getDenominacion());
		        dineroUsado.setCantidad(cantidadBM); // Asignar la cantidad de billetes y/o monedas utilizado
		        dineroOcupado.add(dineroUsado); // Agregar el objeto a la lista "dineroOcupado" con la misma información y la cantidad utilizada
		        
				d.setCantidad(cantidadOriginal - cantidadBM); // Asignar lo restante de la denominación utilizada
				dineroActualizado.add(d); // Agregar el objeto a la lista "dineroActualizado" con la misma información y la cantidad restante actualizada
				
				montoRetiro = montoRetiro - (cantidadBM * denominacion);
				if(montoRetiro == 0) break;
			}
		}
		System.out.println(dineroActualizado);
		service.editarMultiple(dineroActualizado);
		return ResponseEntity.ok(dineroOcupado);
	}
	
	private int cantidadBilletesMonedas(double cantidadRetiro, Dinero dinero) {
		double dineroAcumulado = 0;
		int contador = 0;
		while(contador < dinero.getCantidad()){
			dineroAcumulado = dinero.getDenominacion().doubleValue() * (contador + 1);
			if(dineroAcumulado > cantidadRetiro) break;
			contador++;
		}
		return contador;
	}
}
