package com.mx.UsuarioRol.Service;

import java.util.List;

import com.mx.UsuarioRol.Dominio.Rol;

public interface IRolService {
	public void guardar(Rol rol);
	public void editar(Rol rol);
	public void eliminar(int idRol);
	public Rol buscar(int idRol);
	public List<Rol> listar();
}
