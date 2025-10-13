package com.mx.Ventas.Service;

import java.util.List;

import com.mx.Ventas.Entity.Venta;

public interface IVentaService {
	public void guardar(Venta venta);
	public void guardarMultiple(List<Venta> ventas);
	public void editar(Venta venta);
	public Venta buscar(int idVenta);
	public void eliminar(int idVenta);
	public List<Venta> listar();
}
