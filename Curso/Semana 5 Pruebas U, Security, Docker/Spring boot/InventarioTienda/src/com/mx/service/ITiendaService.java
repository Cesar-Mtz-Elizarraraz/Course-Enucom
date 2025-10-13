package com.mx.service;

import java.util.List;

import com.mx.entity.Producto;

public interface ITiendaService {
	public void agregarProducto(Producto p);
	public void venderProducto(String nombre, int cantidad);
	public List<Producto> mostrarBajoStock();
	public double calcularValorTotal();
}
