package com.mx.Implementaciones;

import java.util.ArrayList;
import java.util.List;

import com.mx.Principal.IMetodos;

public class ImplementacionGenerica implements IMetodos{
	
	// DECLARAR LA LISTA
	protected List<Object> lista = new ArrayList<Object>();

	@Override
	public void guardar(Object value) {
		lista.add(value);
		
	}

	@Override
	public void editar(Object indice, Object value) {
		int index = (Integer) indice;
		lista.set(index, value);
		
	}

	@Override
	public void eliminar(Object indice) {
		int index = (Integer) indice;
		lista.remove(index);
	}

	@Override
	public Object buscar(Object indice) {
		int index = (Integer) indice;
		return lista.get(index);
	}

	@Override
	public void mostrar() {
		System.out.println(lista);
		
	}



}
