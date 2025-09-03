package com.mx.metodos;

import com.mx.entidad.Persona;

public interface MetodosPersona {
	public void guardar(Persona persona);
	
	public void editar(Persona persona, int indice);
	
	public void eliminar(int indice);
	
	public void buscar(int indice);
	
	public void mostrar();
}
