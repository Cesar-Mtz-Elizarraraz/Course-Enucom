package com.mx.Empleado.Service;

import java.util.List;

import com.mx.Empleado.Entity.Empleado;

public interface IEmpleadoService {
	public void guardar(Empleado empleado);
	public void editar(Empleado empleado);
	public void eliminar(int idEmpleado);
	public Empleado buscar(int idEmpleado);
	public List<Empleado> listar();
}
