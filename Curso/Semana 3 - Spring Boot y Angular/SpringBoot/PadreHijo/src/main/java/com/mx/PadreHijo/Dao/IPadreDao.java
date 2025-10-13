package com.mx.PadreHijo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.PadreHijo.Dominio.Padre;

@Repository
public interface IPadreDao extends JpaRepository<Padre, Integer>{
	// MÉTODO PERSONALIZADO
	public Padre findByNombreIgnoringCase(String nombre);
}
