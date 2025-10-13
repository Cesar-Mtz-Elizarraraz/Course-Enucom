package com.mx.Ventas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.Ventas.Entity.Venta;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {
	@Query(value = "SELECT 'VTA-' || TO_CHAR(SEQ_FOLIO_VENTA.NEXTVAL) FROM DUAL", nativeQuery = true)
	String obtenerFolioVenta();
}
