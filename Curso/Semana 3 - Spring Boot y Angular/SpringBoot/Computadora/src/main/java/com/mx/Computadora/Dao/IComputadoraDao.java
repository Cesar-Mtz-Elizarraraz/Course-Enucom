package com.mx.Computadora.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.Computadora.Dominio.Computadora;

@Repository // indica que esta interfaz sera gestionada por el contenedor beans de Spring y debera ser inyectado por la otra clase
// @Repository ayuda a que se puedan utilizar los métodos declarados en la interfaz más adelante y construir otra clase
public interface IComputadoraDao extends CrudRepository<Computadora, Integer>{
	// CrudRepository ofrece todos los métodos CRUD para poder modificar mi base de datos
	// y es por eso que esta carpeta(este paquete) se conoce como la capa de acceso a datos
	
	// MÉTODO PERSONALIZADO: Utilizando siempre lo que me ofrece el repositorio de DataJPA
	public Computadora findByMarca(String Marca);
}
