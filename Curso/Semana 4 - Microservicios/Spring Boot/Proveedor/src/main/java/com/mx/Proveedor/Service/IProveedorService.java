package com.mx.Proveedor.Service;

import java.util.List;

import com.mx.Proveedor.Entity.Proveedor;

public interface IProveedorService {
	public void guardar(Proveedor proveedor);
	public void editar(Proveedor proveedor);
	public void eliminar(int idProveedor);
	public Proveedor buscar(int idProveedor);
	public List<Proveedor> listar();
}
