package com.mx.Ventas.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Ventas.DTOs.ClienteDTO;
import com.mx.Ventas.DTOs.EmpleadoDTO;
import com.mx.Ventas.DTOs.ProductoDTO;
import com.mx.Ventas.DTOs.VentaCliProdEmpDTO;
import com.mx.Ventas.DTOs.VentaClienteDTO;
import com.mx.Ventas.DTOs.VentaProductoDTO;
import com.mx.Ventas.Entity.Venta;
import com.mx.Ventas.FeignClient.ClienteFeignClient;
import com.mx.Ventas.FeignClient.EmpleadoFeignClient;
import com.mx.Ventas.FeignClient.ProductoFeignClient;
import com.mx.Ventas.Repository.IVentaRepository;

@Service
public class VentaServiceImp implements IVentaService {

	@Autowired
	private IVentaRepository dao;
	
	@Override
	public void guardar(Venta venta) {
		dao.save(venta);
		
	}

	@Override
	public void guardarMultiple(List<Venta> ventas) {
		dao.saveAll(ventas);
		
	}

	@Override
	public void editar(Venta venta) {
		dao.save(venta);
		
	}

	@Override
	public Venta buscar(int idVenta) {

		return dao.findById(idVenta).orElse(null);
	}

	@Override
	public void eliminar(int idVenta) {
		dao.deleteById(idVenta);
		
	}

	@Override
	public List<Venta> listar() {

		return dao.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
	}
	
	public String obtenerFolioSecuencia() {
		return dao.obtenerFolioVenta();
	}
	
	@Autowired
	private ClienteFeignClient clienteFC;
	
	@Autowired
	private ProductoFeignClient productoFC;
	
	@Autowired
	private EmpleadoFeignClient empleadoFC;
	
	public List<VentaCliProdEmpDTO> obtenerVentasCliProdEmp(){
		List<ClienteDTO> clientes = clienteFC.listar();
		List<ProductoDTO> productos = productoFC.listar();
		List<EmpleadoDTO> empleados = empleadoFC.listar();
		
		HashMap<Integer, ClienteDTO> hashClientes = new HashMap<>();
		HashMap<Long, ProductoDTO> hashProductos = new HashMap<>();
		HashMap<Integer, EmpleadoDTO> hashEmpleados = new HashMap<>();
		
		for(ClienteDTO c : clientes) {
			hashClientes.put(c.getIdCliente(), c);
		}
		for(ProductoDTO p : productos) {
			hashProductos.put(p.getCodigoBarras(), p);
		}
		for(EmpleadoDTO e : empleados) {
			hashEmpleados.put(e.getIdEmpleado(), e);
		}
		
		List<Venta> ventas = dao.findAll();
		List<VentaCliProdEmpDTO> ventasDTO = new ArrayList<>();
		
		for(Venta v : ventas) {
			VentaCliProdEmpDTO dto = new VentaCliProdEmpDTO(
				v.getIdVenta(),
				v.getFolio(),
				v.getFecha(),
				v.getCantidad(),
				v.getTotal(),
				v.getMetodoPago(),
				hashClientes.get(v.getClienteId()),
				hashEmpleados.get(v.getEmpleadoId()),
				hashProductos.get(v.getCodigoBarras())
			);
			ventasDTO.add(dto);
		}
		
		return ventasDTO;
	}
	
	
	public VentaProductoDTO obtenerVentasProd(int idVenta) {
		Venta venta = dao.findById(idVenta)
				.orElseThrow(() -> new RuntimeException("Venta no existente"));
		// BUscar prodcuto en el microservicio de Prodcuto(consumir)
		ProductoDTO producto = productoFC.buscar(venta.getCodigoBarras());
		// COnstruir una respuesta
		VentaProductoDTO dto = new VentaProductoDTO();
		dto.setIdVenta(venta.getIdVenta());
		dto.setFolio(venta.getFolio());
		dto.setFecha(venta.getFecha());
		dto.setCantidad(venta.getCantidad());
		dto.setTotal(venta.getTotal());
		dto.setMetodoPago(venta.getMetodoPago());
		dto.setClienteId(venta.getClienteId());
		dto.setEmpleadoId(venta.getEmpleadoId());
		dto.setProducto(producto);
		return dto;
		
	}
	
	
	public VentaClienteDTO obtenerVentasCliente(int idVenta) {
		Venta venta = dao.findById(idVenta)
				.orElseThrow(() -> new RuntimeException("Venta no existente"));
		// CONSUMO DEL MICROSERVICIO: Buscar cliente en el microservicio de Cliente
		ClienteDTO cliente = clienteFC.buscar(venta.getClienteId());
		// RESPUESTA
		VentaClienteDTO dto = new VentaClienteDTO();
		dto.setIdVenta(venta.getIdVenta());
		dto.setFolio(venta.getFolio());
		dto.setFecha(venta.getFecha());
		dto.setCantidad(venta.getCantidad());
		dto.setTotal(venta.getTotal());
		dto.setMetodoPago(venta.getMetodoPago());
		dto.setCliente(cliente);
		dto.setEmpleadoId(venta.getEmpleadoId());
		dto.setCodigoBarras(venta.getCodigoBarras());
		return dto;
		
	}

}
