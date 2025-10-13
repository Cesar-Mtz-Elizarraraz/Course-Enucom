package com.mx.Producto.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Producto.DTOs.CategoriaDTO;
import com.mx.Producto.DTOs.ProductoCatProvDTO;
import com.mx.Producto.DTOs.ProveedorDTO;
import com.mx.Producto.Entity.Producto;
import com.mx.Producto.FeignClient.CategoriaFeignClient;
import com.mx.Producto.FeignClient.ProveedorFeignClient;
import com.mx.Producto.Repository.IProductoRepository;

@Service
public class ProductoServiceImp implements IProductoService{
	// Patron de diseño del tipo de inversion de control
	@Autowired // Inyección de dependencias
	private IProductoRepository dao;
	
	@Override
	public void guardar(Producto producto) {
		dao.save(producto);
	}
	
	@Override
	public void editar(Producto producto) {
		dao.save(producto);
	}
	
	@Override
	public void eliminar(long codigoBarras) {
		dao.deleteById(codigoBarras);
	}
	
	@Override
	public Producto buscar(long codigoBarras) {
		return dao.findById(codigoBarras).orElse(null);
	}
	
	@Override
	public List<Producto> listar(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	// MÉTODOs PERSONALIZADOs
	// Buscar por categoría
	public List<Producto> buscarPorCategoria(int categoriaId){
		return dao.findByCategoriaId(categoriaId);
	}
	
	// Buscar por proveedor
	public List<Producto> buscarPorProveedor(int proveedorId){
		return dao.findByProveedorId(proveedorId);
	}
	
	public void editarMultiple(List<Producto> productos) {
		dao.saveAll(productos);
	}
	
	public boolean productoExistente(String nombre) {
		return dao.existsByNombreIgnoreCase(nombre);
	}
	
	public boolean productoExistenteDiferenteCodigoBarras(String nombre, Long codigoBarras) {
		return dao.existsByNombreIgnoreCaseAndCodigoBarrasNot(nombre, codigoBarras);
	}
	
	@Autowired
	private CategoriaFeignClient categoriaFC;
	
	@Autowired
	private ProveedorFeignClient proveedorFC;
	
	public List<ProductoCatProvDTO> obtenerProductosCatProv() {
		List<CategoriaDTO> categorias = categoriaFC.listar();
		List<ProveedorDTO> proveedores = proveedorFC.listar();
		
		HashMap<Integer, CategoriaDTO> hashCategorias = new HashMap<>();
		HashMap<Integer, ProveedorDTO> hashProveedores = new HashMap<>();
		
		for(CategoriaDTO c : categorias) {
			hashCategorias.put(c.getIdCategoria(), c);
		}
		for(ProveedorDTO p : proveedores) {
			hashProveedores.put(p.getIdProveedor(), p);
		}
		
		List<Producto> productos = dao.findAll();
		List<ProductoCatProvDTO> prodsDTO = new ArrayList<>();
		
		for(Producto p : productos) {
			ProductoCatProvDTO dto = new ProductoCatProvDTO(
				p.getCodigoBarras(),
				p.getNombre(),
				p.getPrecio(),
				p.getStock(),
				p.getDescuento(),
				hashCategorias.get(p.getCategoriaId()),
				hashProveedores.get(p.getProveedorId())
			);
			prodsDTO.add(dto);
		}
		
		return prodsDTO;
	}
}
