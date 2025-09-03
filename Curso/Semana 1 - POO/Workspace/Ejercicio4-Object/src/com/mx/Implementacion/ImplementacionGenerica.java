package com.mx.Implementacion;

import java.util.HashMap;

import com.mx.Principal.IMetodos;

public class ImplementacionGenerica implements IMetodos{
	
	// DECLARAR HASHMAP
	protected HashMap<Object, Object> hash = new HashMap<Object, Object>();

	@Override
	public void guardar(Object key, Object value) {
		hash.put(key, value);
		
	}

	@Override
	public void editar(Object key, Object value) {
		hash.replace(key, value);
		
	}

	@Override
	public void eliminar(Object key) {
		hash.remove(key);
		
	}

	@Override
	public Object buscar(Object key) {
		
		return hash.get(key); 
	}

	@Override
	public void mostrar() {
		System.out.println(hash);
		
	}

}
