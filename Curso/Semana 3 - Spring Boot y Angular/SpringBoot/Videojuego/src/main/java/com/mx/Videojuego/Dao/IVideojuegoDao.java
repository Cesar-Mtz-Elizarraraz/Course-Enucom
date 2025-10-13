package com.mx.Videojuego.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Videojuego.Dominio.Videojuego;

@Repository
public interface IVideojuegoDao extends CrudRepository<Videojuego, Integer> {
	// METODO PERSONALIZADO
	public Videojuego findByDesarrollador(String desarrollador);
}
