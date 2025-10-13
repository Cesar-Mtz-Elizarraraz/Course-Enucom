package com.mx.Categoria.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.Categoria.DTOs.CategoriaProductoDTO;
import com.mx.Categoria.DTOs.ProductoDTO;
import com.mx.Categoria.Entity.Categoria;
import com.mx.Categoria.Repository.ICategoriaRepository;

@Service
public class CategoriaServiceImp implements ICategoriaService {
	
	@Autowired
	private ICategoriaRepository dao;

	@Override
	public void guardar(Categoria categoria) {
		dao.save(categoria);
		
	}

	@Override
	public void editar(Categoria categoria) {
		dao.save(categoria);
		
	}

	@Override
	public void eliminar(int idCategoria) {
		dao.deleteById(idCategoria);
		
	}

	@Override
	public Categoria buscar(int idCategoria) {
		return dao.findById(idCategoria).orElse(null);
	}

	@Override
	public List<Categoria> listar() {
		// TODO Auto-generated method stub
		return (List<Categoria>) dao.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
	}
	
	public boolean categoriaExistente(String nombre) {
		return dao.existsByNombreIgnoreCase(nombre);
	}
	
	public boolean categoriaExistenteDiferenteID(String nombre, int idCategoria) {
		return dao.existsByNombreIgnoreCaseAndIdCategoriaNot(nombre, idCategoria);
	}
	
	@Autowired // Inyectar el bean RestTemplate para poder hacer las peticiones HTTP a otros microservicios
	private RestTemplate restTemplate;
	// Declaración del metodo filtrar productos por categoria
	public CategoriaProductoDTO obtenerCategoriaConProductos(int categoriaId) {
		// Buscar si la categoria existe
		Categoria categoria = dao.findById(categoriaId).orElse(null);
		if(categoria == null) {
			return null;
		} else {
			// Consumir el microservicio de productos
			// Como GetForObject no soporta las listas, se coloca en un Array .class
			ProductoDTO[] productosArray = restTemplate.getForObject("http://localhost:8010/P/buscarPorCategoria/" + categoriaId, ProductoDTO[].class);
			// Almacenar en una lista
			List<ProductoDTO> productos = Arrays.asList(productosArray); // COvertir el array de productos en una lista{
			return new CategoriaProductoDTO(categoria, productos);
		}
	}
	
}
