package com.mx.AutorLibro.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.AutorLibro.Dao.IAutorDao;
import com.mx.AutorLibro.Dominio.Autor;
import com.mx.AutorLibro.Dominio.Libro;

@Service
public class AutorServiceImp implements IAutorService {
	
	@Autowired
	private IAutorDao dao;

	@Override
	public void guardar(Autor autor) {
		dao.save(autor);
		
	}

	@Override
	public void editar(Autor autor) {
		dao.save(autor);
		
	}

	@Override
	public void eliminar(int idAutor) {
		dao.deleteById(idAutor);
		
	}

	@Override
	public Autor buscar(int idAutor) {
		
		return dao.findById(idAutor).orElse(null);
	}

	@Override
	public List<Autor> listar() {
		
		return (List<Autor>) dao.findAll(Sort.by(Sort.Direction.ASC, "idAutor"));
	}
	
	public List<Libro> findLibrosByAutor(int idAutor){
		return dao.findLibrosByAutor(idAutor);
	}
	
}
