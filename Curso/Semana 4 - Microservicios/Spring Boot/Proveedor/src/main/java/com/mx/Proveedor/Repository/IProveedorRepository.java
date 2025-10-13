package com.mx.Proveedor.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Proveedor.Entity.Proveedor;

public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {

}
