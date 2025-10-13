package com.mx.Empleado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Empleado.Entity.Empleado;

@Repository
public interface IEmpleadoDao extends JpaRepository<Empleado, Integer> {
	boolean existsByNombreAndApellidoIgnoreCase(String nombre, String apellido);
	boolean existsByTelefono(Long telefono);
}
