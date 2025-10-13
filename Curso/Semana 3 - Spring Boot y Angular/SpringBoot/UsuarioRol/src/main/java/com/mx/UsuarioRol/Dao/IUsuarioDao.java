package com.mx.UsuarioRol.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.UsuarioRol.Dominio.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {
	@Query(value = "SELECT * FROM CURSO_USUARIOS CU WHERE LOWER(CU.CORREO) = LOWER(:correo)", nativeQuery = true)
	Optional<Usuario> findByCorreo(String correo); // Se utiliza el "Optional" para ayudar a manejar la ausencia de valores y evitar el null

}
