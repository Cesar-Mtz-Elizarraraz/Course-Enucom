package com.mx.Categoria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Categoria.Entity.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
	boolean existsByNombreIgnoreCase(String nombre);
	//@Query("SELECT COUNT(c) > 0 FROM Categoria c WHERE LOWER(c.nombre) = LOWER(:nombre) AND c.idCategoria <> :idCategoria")
	//boolean existsByNombreIgnoreCaseAndIdCategoriaNot(@Param("nombre") String nombre, @Param("idCategoria") int idCategoria);
	boolean existsByNombreIgnoreCaseAndIdCategoriaNot(String nombre, int idCategoria);
}
