package com.mx.Producto.Service;

import java.util.List;

import com.mx.Producto.Entity.Producto;

public interface IProductoService {
	public void guardar(Producto producto);
	public void editar(Producto producto);
	public void eliminar(long codigoBarras);
	public Producto buscar(long codigoBarras);
	public List<Producto> listar();
}
