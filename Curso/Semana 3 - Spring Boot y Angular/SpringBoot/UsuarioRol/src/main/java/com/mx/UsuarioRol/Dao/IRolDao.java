package com.mx.UsuarioRol.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mx.UsuarioRol.Dominio.Rol;

public interface IRolDao extends JpaRepository<Rol, Integer> {
	@Query(value = "SELECT * FROM CURSO_ROLES CR WHERE LOWER(CR.PRIVILEGIO) = LOWER(:privilegio)", nativeQuery = true)
	Optional<Rol> findByPrivilegio(String privilegio); // Se utiliza el "Optional" para ayudar a manejar la ausencia de valores y evitar el null
}
