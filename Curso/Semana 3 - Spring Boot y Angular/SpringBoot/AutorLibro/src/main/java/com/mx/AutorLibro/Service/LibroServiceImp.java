package com.mx.AutorLibro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.AutorLibro.Dao.ILibroDao;
import com.mx.AutorLibro.Dominio.Libro;

@Service
public class LibroServiceImp implements ILibroService {

	@Autowired 
	private ILibroDao dao;
	
	@Override
	public void guardar(Libro libro) {
		dao.save(libro);
		
	}

	@Override
	public void editar(Libro libro) {
		dao.save(libro);
		
	}

	@Override
	public void eliminar(int idLibro) {
		dao.deleteById(idLibro);
		
	}

	@Override
	public Libro buscar(int idLibro) {
		
		return dao.findById(idLibro).orElse(null);
	}

	@Override
	public List<Libro> listar() {
		
		return (List<Libro>) dao.findAll(Sort.by(Sort.Direction.ASC, "idAutor"));
	}
}
