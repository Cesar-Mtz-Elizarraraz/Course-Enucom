package com.mx.entidad;

public class Comestible extends Producto {
	
	String tipo;
	
	public Comestible() {
		super();
	}
	
	public Comestible(int codigoBarras, String nombreProducto, String marca, double precio, int stock, String pais, String tipo) {
		super(codigoBarras, nombreProducto, marca, precio, stock, pais);
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "COMESTIBLE => [Código de barras: " + codigoBarras + ", Nombre: " + nombreProducto + ", Marca: " + marca + ", Precio: " + precio + 
				", Stock: " + stock + ", País: " + pais + ", Tipo: " + tipo + "]\n";
	}

	@Override
	public double precioTotal() {
		double precioTotal = precio + (precio * 0.20);
		return precioTotal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
