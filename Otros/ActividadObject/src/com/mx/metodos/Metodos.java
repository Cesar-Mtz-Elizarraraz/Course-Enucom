package com.mx.metodos;

public interface Metodos {
	public void guardar(Object obj, String clase);
	
	public void editar(Object obj, int indice, String clase);
	
	public void eliminar(Object obj, int indice, String clase);
	
	public Object buscar(Object obj, int indice, String clase);
	
	public void mostrar(String clase);
}
