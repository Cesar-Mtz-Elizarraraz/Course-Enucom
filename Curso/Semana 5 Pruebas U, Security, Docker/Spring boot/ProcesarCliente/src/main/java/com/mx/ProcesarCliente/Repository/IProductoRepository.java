package com.mx.ProcesarCliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.ProcesarCliente.Entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, String> {
	 boolean existsById(String idProducto);
}
