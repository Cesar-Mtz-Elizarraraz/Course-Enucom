package com.mx.PadreHijo.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.PadreHijo.Dominio.Hijo;

@Repository
public interface IHijoDao extends JpaRepository<Hijo, Integer> {
	// JpaRepository nos ofrece más operaciones que CRUD y tambien poder hacer consultas directamente a la BD
	@Query(value = "SELECT * FROM HIJO H WHERE UPPER(H.HOBBIE) = UPPER(:hobbie)", nativeQuery = true)
	public List<Hijo> findByHobbie(String  hobbie);
}
