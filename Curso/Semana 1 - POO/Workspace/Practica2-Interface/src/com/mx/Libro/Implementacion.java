package com.mx.Libro;

import java.util.ArrayList;
import java.util.List;

public class Implementacion implements IMetodos {

	List<Libro> listaLibros = new ArrayList<Libro>();
	
	@Override
	public void guardar(Libro libro) {
		listaLibros.add(libro);
		
	}

	@Override
	public void editar(int indice, Libro libro) {
		listaLibros.set(indice, libro);
		
	}

	@Override
	public void mostrar() {
		System.out.println(listaLibros);
		
	}

	@Override
	public void eliminar(int indice) {
		listaLibros.remove(indice);
		
	}

	@Override
	public Libro buscar(int indice) {

		return listaLibros.get(indice);
	}
	
	// MÉTODO PERSONALIZO
	public void contar() {
		System.out.println("La lista contiene " + listaLibros.size() + " libros registrados");
	}
	
}
