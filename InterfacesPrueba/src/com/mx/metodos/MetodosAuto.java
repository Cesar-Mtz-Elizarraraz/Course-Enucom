package com.mx.metodos;

import com.mx.entidad.Auto;

// La interfaz es una plantilla de métdos vacíos o sin funcionalidad que pueden ser implementados por cualquier clase dentro del
// proyecto, la clase que las implemente tiene la obligación de darle funcionalidad a los métodos vacíos de la interfaz

public interface MetodosAuto {
	public void guardar(Auto auto);
	
	public void editar(Auto auto, int indice);
	
	public void eliminar(int indice);
	
	public void buscar(int indice);
	
	public void mostrar();
}
