package com.mx.Principal;
// Se utilizará la clase 'Object'
// Se usa un HashMap o una lista (por ejemplo HashMap<Object, Object> estamos indicando que tanto
// la clave como el valor son 
public interface IMetodos {
	public void guardar(Object key, Object value);
	public void editar(Object key, Object value);
	public void eliminar(Object key);
	public Object buscar(Object key);
	public void mostrar();
	
}
