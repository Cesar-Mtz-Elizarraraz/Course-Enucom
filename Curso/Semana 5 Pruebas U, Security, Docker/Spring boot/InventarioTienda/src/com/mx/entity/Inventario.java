package com.mx.entity;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
	public List<Producto> listaProductos;
	
	public Inventario() {
		this.listaProductos = new ArrayList<Producto>();
	}
}
