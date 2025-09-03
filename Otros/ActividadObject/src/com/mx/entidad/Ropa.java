package com.mx.entidad;

public class Ropa extends Producto{
	String material;
	
	public Ropa() {
	}
	
	
	public Ropa(int codigoBarras, String nombreProducto, String marca, double precio, int stock, String pais, String material) {
		super(codigoBarras, nombreProducto, marca, precio, stock, pais);
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "ROPA => [Código de barras: " + codigoBarras + ", Nombre: " + nombreProducto + ", Marca: " + marca + ", Precio: " + precio + 
				", Stock: " + stock + ", País: " + pais + ", Material: " + material + "]\n";
	}

	@Override
	public double precioTotal() {
		double precioTotal = precio + (precio * 0.15);
		return precioTotal;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
}
