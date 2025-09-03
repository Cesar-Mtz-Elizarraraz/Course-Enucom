package com.mx.Celular;
// Una interface es como una plantilla, que nos ayuda para la contrucción de otras clases
public interface IMetodos {
	// Las interfaces solo pueden tener métodos abstractos
	public void guardar(Celular celular);
	public void editar(int indice, Celular celular);
	public void mostrar();
	public void eliminar(int indice);
	public Celular buscar(int indice);
}
