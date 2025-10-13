package com.mx.Tarea.Service;

import java.util.List;

import com.mx.Tarea.Entity.Tarea;

public interface ITareaService {
	public void guardar(Tarea tarea);
	public void editar(Tarea tarea);
	public void eliminar(int idTarea);
	public Tarea buscar(int idTarea);
	public List<Tarea> listar();
}
