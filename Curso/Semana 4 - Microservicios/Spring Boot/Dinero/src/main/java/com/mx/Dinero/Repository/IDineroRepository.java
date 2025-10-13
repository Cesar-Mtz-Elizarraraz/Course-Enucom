package com.mx.Dinero.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Dinero.Entity.Dinero;

@Repository
public interface IDineroRepository extends JpaRepository<Dinero, Integer> {
	@Query(value = "SELECT TOTAL_FONDOS FROM CALCULAR_FONDOS", nativeQuery = true)
    BigDecimal obtenerFondos();
	@Query(value = "SELECT * FROM DENOMINACIONES_DISPONIBLES", nativeQuery = true)
	List<Dinero> obtenerDenominacionesDisponibles();
}
