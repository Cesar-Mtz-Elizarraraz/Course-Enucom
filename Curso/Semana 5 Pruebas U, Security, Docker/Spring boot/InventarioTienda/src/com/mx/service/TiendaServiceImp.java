package com.mx.service;

import java.util.ArrayList;
import java.util.List;

import com.mx.entity.*;

public class TiendaServiceImp implements ITiendaService {
	
	private Inventario inventario = new Inventario();
	private int idProducto = 1;

	@Override
	public void agregarProducto(Producto p) {
		
		int bandera = 1;
		for(Producto prod : inventario.listaProductos) {
			if(prod.getNombre().equalsIgnoreCase(p.getNombre())) {
				bandera = 2;
				break;
			}
		}
		if(bandera == 1) {
			p.setId(idProducto);
			inventario.listaProductos.add(p);
			idProducto++;
		}
		System.out.println(bandera == 1 ? "Producto guardado" : "El nombre del producto ya esta registrado");
		
	}

	@Override
	public void venderProducto(String nombre, int cantidad) {
		int bandera = 0;
		for(Producto p : inventario.listaProductos) {
			if(p.getNombre().equalsIgnoreCase(nombre)) {
				if(p.getCantidad() < cantidad) {
					bandera = 2;
				} else {
					p.setCantidad(p.getCantidad() - cantidad);
					bandera = 1;
				}
				break;
			}
		}
		System.out.println(bandera == 1 ? "Producto vendido" : bandera == 2 ? "Sin stock suficiente" : "Producto no encontrado");
	}

	@Override
	public List<Producto> mostrarBajoStock() {
		List<Producto> productosBajoStock = new ArrayList<Producto>();
		for(Producto p : inventario.listaProductos) {
			if(p.getCantidad() < 5) {
				productosBajoStock.add(p);
			}
		}
		return productosBajoStock;
	}

	@Override
	public double calcularValorTotal() {
		double valorInventario = 0;
		for(Producto p : inventario.listaProductos) {
			valorInventario += (p.getCantidad() * p.getPrecio());
		}
		return valorInventario;
	}

}
