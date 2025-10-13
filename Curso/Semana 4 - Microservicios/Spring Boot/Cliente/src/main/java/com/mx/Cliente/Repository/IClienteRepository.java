package com.mx.Cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Cliente.Entity.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

}
