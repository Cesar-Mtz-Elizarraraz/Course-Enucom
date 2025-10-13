package com.mx.ProcesarCliente.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mx.ProcesarCliente.Entity.Beneficiario;
import com.mx.ProcesarCliente.Entity.Cliente;
import com.mx.ProcesarCliente.Entity.Contacto;
import com.mx.ProcesarCliente.Entity.Contrato;
import com.mx.ProcesarCliente.Entity.Documentacion;
import com.mx.ProcesarCliente.Entity.Domicilio;
import com.mx.ProcesarCliente.Entity.Producto;

@Repository
public interface IProcesarClienteRepository extends JpaRepository<Cliente, Long> {
	boolean existsById(Long idClienteDigital);
	
	boolean existsByCurp(String curp);
	
	@Query(value = "SELECT * FROM BENEFICIARIO;", nativeQuery = true)
	List<Beneficiario> listarBeneficiarios();
	
	@Query("SELECT ct FROM Contacto ct")
	List<Contacto> listarContactos();
	
	@Query("SELECT ctr FROM Contrato ctr")
	List<Contrato> listarContratos();
	
	@Query("SELECT dc FROM Documentacion dc")
	List<Documentacion> listarDocumentacion();
	
	@Query("SELECT ct FROM Domicilio ct")
	List<Domicilio> listarDomicilios();
	
	@Query("SELECT pr FROM Producto pr")
	List<Producto> listarProductos();
}
