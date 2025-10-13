package com.mx.ProcesarCliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProcesarCliente.Entity.Contacto;

public interface IContactoRepository extends JpaRepository<Contacto, Integer> {
	 boolean existsByTelefono(Long telefono);
	 boolean existsByEmail(String email);
}
