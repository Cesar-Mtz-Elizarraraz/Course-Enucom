package com.mx.Ventas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.Ventas.DTOs.VentaCliProdEmpDTO;
import com.mx.Ventas.DTOs.VentaClienteDTO;
import com.mx.Ventas.DTOs.VentaProductoDTO;
import com.mx.Ventas.Entity.Venta;
import com.mx.Ventas.Service.VentaServiceImp;

@RestController
@RequestMapping(path = "/V")
// @CrossOrigin
public class VentaWS {
	@Autowired
	private VentaServiceImp service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		List<Venta> lista = service.listar();
		if(lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No hay registros en la base de datos");
			// return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> guardar(@RequestBody Venta venta) {
		service.guardar(venta);
		return ResponseEntity.ok("La venta de ID " + venta.getIdVenta() + " ha sido registrada correctamente");
	}
	
	@PostMapping("/guardarMultiple")
	public ResponseEntity<?> guardarMultiple(@RequestBody List<Venta> ventas) {
		String folio = service.obtenerFolioSecuencia();
		for(Venta v : ventas) {
			v.setFolio(folio);
		}
		
		service.guardarMultiple(ventas);
		return ResponseEntity.ok("La venta ha sido registrada correctamente");
	}
	
	@PutMapping
	public ResponseEntity<?> editar(@RequestBody Venta venta) {
		service.editar(venta);
		return ResponseEntity.ok("La venta de ID " + venta.getIdVenta() + " ha sido actualizada correctamente");
	}
	
	@GetMapping("/{idVenta}")
	public ResponseEntity<?> buscar(@PathVariable int idVenta) {
		Venta encontrada = service.buscar(idVenta);
		if(encontrada == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(encontrada);
		}
	}
	
	@DeleteMapping("/{idVenta}")
	public ResponseEntity<?> eliminar(@PathVariable int idVenta) {
		Venta encontrada = service.buscar(idVenta);
		if(encontrada == null) {
			return ResponseEntity.notFound().build();
		} else {
			service.eliminar(idVenta);
			return ResponseEntity.ok(encontrada);
		}
	}
	
	@GetMapping("/productos/{idVenta}")
	public VentaProductoDTO obtenerListaProd(@PathVariable int idVenta) {
		return service.obtenerVentasProd(idVenta);
	}
	
	@GetMapping("/clientes/{idVenta}")
	public VentaClienteDTO obtenerListaCLientes(@PathVariable int idVenta) {
		return service.obtenerVentasCliente(idVenta);
	}
	
	@GetMapping("/listarFull")
	public ResponseEntity<?> listarFull() {
		List<VentaCliProdEmpDTO> lista = service.obtenerVentasCliProdEmp();
		if(lista == null || lista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.ok(lista);
		}
	}
}
