package com.mx.Veterinarias.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Veterinarias.Entity.Veterinaria;

@Repository
public interface IVeterinariaRepository extends JpaRepository<Veterinaria, Integer> {
	boolean existsByTelefono(Long telefono);
	boolean existsByTelefonoAndIdVeterinariaNot(Long telefono, Integer idVeterinaria);
}
