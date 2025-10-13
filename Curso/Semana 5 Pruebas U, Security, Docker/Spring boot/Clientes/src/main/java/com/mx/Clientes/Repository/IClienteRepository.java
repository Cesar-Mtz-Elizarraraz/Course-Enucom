package com.mx.Clientes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Clientes.Entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
	boolean existsByContacto(Long contacto);
	boolean existsByContactoAndIdClienteNot(Long contacto, Integer idCliente);
}
