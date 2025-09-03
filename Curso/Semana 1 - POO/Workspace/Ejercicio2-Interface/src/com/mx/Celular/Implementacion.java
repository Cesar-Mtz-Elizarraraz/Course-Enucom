package com.mx.Celular;

import java.util.ArrayList;
import java.util.List;

// Para implementar una interfaz, se usa la palabra reservada "implements"
public class Implementacion implements IMetodos {

	// Definimos una estructura de datos para poder definir el comportamiento de los métodos
	
	List<Celular> listaCelulares = new ArrayList<Celular>();
	
	@Override
	public void guardar(Celular celular) {
		listaCelulares.add(celular);
		
	}

	@Override
	public void editar(int indice, Celular celular) {
		listaCelulares.set(indice, celular);
		
	}

	@Override
	public void mostrar() {
		System.out.println(listaCelulares);
		
	}

	@Override
	public void eliminar(int indice) {
		listaCelulares.remove(indice);
		
	}

	@Override
	public Celular buscar(int indice) {
		
		return listaCelulares.get(indice);
	}
	
	// Método personalizado contar
	public void contar() {
		int contador = listaCelulares.size();
		System.out.println("La lista contiene " + contador + " celulares registrados");
	}

}
