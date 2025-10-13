package com.mx.Veterinarias.Service;

import java.util.List;

import com.mx.Veterinarias.Entity.Veterinaria;

public interface IVeterinariaService {
	public List<Veterinaria> listar(); 
	public void guardar(Veterinaria veterinaria);
	public void editar(Veterinaria veterinaria);
	public Veterinaria buscar(Integer idVeterinaria);
	public void eliminar(Integer idVeterinaria);
}
