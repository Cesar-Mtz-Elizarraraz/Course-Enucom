package com.mx.Responsables.Service;

import java.util.List;

import com.mx.Responsables.Entity.Responsable;

public interface IResponsableService {
	public List<Responsable> listar(); 
	public void guardar(Responsable responsable);
	public void editar(Responsable responsable);
	public Responsable buscar(Integer idResponsable);
	public void eliminar(Integer idResponsable);
	
}
