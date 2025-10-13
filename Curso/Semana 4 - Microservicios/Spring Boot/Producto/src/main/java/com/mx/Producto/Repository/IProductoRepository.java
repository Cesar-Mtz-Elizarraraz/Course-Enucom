package com.mx.Producto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.Producto.Entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
	public List<Producto> findByCategoriaId(int categoriaId); // LLAVES REFERENCIALES
	public List<Producto> findByProveedorId(int proveedorId);
	boolean existsByNombreIgnoreCase(String nombre);
	boolean existsByNombreIgnoreCaseAndCodigoBarrasNot(String nombre, Long codigoBarras);
}
