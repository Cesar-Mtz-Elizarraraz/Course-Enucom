package com.mx.Libro;

public interface IMetodos {
	public void guardar(Libro libro);
	public void editar(int indice, Libro libro);
	public void mostrar();
	public void eliminar(int indice);
	public Libro buscar(int indice);
}
