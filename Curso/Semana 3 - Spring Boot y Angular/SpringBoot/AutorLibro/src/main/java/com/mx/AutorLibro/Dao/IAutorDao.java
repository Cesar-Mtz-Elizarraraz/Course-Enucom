package com.mx.AutorLibro.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.AutorLibro.Dominio.Autor;
import com.mx.AutorLibro.Dominio.Libro;

@Repository
public interface IAutorDao extends JpaRepository<Autor, Integer> {
	@Query(value = "SELECT * FROM LIBRO L WHERE L.AUTOR_ID = :autorId", nativeQuery = true)
	public List<Libro> findLibrosByAutor(int autorId);
}
