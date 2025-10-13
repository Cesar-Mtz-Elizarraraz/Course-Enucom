package com.mx.Responsables.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Responsables.Entity.Responsable;

@Repository
public interface IResponsableRepository extends JpaRepository<Responsable, Integer> {
	boolean existsByContacto(Long telefono);
	boolean existsByContactoAndIdResponsableNot(Long telefono, Integer idResponsable);

}
