package com.mx.Principal;

public interface IMetodos {
	public void guardar(Object value);
	public void editar(Object indice, Object value);
	public void eliminar(Object indice);
	public Object buscar(Object indice);
	public void mostrar();
	
}
