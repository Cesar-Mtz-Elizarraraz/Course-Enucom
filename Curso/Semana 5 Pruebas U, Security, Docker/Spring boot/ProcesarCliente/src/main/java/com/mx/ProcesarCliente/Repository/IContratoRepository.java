package com.mx.ProcesarCliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProcesarCliente.Entity.Contrato;

public interface IContratoRepository extends JpaRepository<Contrato, Long> {
	 boolean existsById(Long idContrato);
}
