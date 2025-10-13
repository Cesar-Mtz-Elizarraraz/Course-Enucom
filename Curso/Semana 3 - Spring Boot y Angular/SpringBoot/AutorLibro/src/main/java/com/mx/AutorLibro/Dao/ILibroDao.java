package com.mx.AutorLibro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.AutorLibro.Dominio.Libro;

@Repository
public interface ILibroDao extends JpaRepository<Libro, Integer> {
	
}
