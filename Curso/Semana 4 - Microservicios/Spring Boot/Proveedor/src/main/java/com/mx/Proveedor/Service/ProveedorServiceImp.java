package com.mx.Proveedor.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Proveedor.DTOs.ProductoDTO;
import com.mx.Proveedor.DTOs.ProveedorProductoDTO;
import com.mx.Proveedor.Entity.Proveedor;
import com.mx.Proveedor.Repository.IProveedorRepository;

@Service
public class ProveedorServiceImp implements IProveedorService {

	@Autowired
	private IProveedorRepository dao;
	
	@Override
	public void guardar(Proveedor proveedor) {
		dao.save(proveedor);
		
	}

	@Override
	public void editar(Proveedor proveedor) {
		dao.save(proveedor);
		
	}

	@Override
	public void eliminar(int idProveedor) {
		dao.deleteById(idProveedor);
		
	}

	@Override
	public Proveedor buscar(int idProveedor) {
		
		return dao.findById(idProveedor).orElse(null);
	}

	@Override
	public List<Proveedor> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	@Autowired // Inyectar el bean RestTemplate para poder hacer las peticiones HTTP a otros microservicios
	private RestTemplate restTemplate;
	// Declaración del metodo filtrar productos por proveedor
	public ProveedorProductoDTO obtenerProveedorConProductos(int proveedorId) {
		// Buscar si la proveedor existe
		Proveedor proveedor = dao.findById(proveedorId).orElse(null);
		if(proveedor == null) {
			return null;
		} else {
			// Consumir el microservicio de productos
			// Como GetForObject no soporta las listas, se coloca en un Array .class
			ProductoDTO[] productosArray = restTemplate.getForObject("http://localhost:8010/P/buscarPorProveedor/" + proveedorId, ProductoDTO[].class);
			// Almacenar en una lista
			List<ProductoDTO> productos = Arrays.asList(productosArray); // COvertir el array de productos en una lista{
			return new ProveedorProductoDTO(proveedor, productos);
		}
	}

}
