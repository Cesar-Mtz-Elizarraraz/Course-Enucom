package com.mx.Empleado;

public interface IMetodos {
	public void guardar(Empleado empleado);
	public Empleado buscar(Empleado empleado);
	public void editar(Empleado empleado);
	public void eliminar(Empleado empleado);
	public void mostrar();
}
