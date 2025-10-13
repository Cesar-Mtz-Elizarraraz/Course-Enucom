package com.mx.UsuarioRol.Service;

import java.util.List;

import com.mx.UsuarioRol.Dominio.Usuario;

public interface IUsuarioService {
	public void guardar(Usuario usuario);
	public void editar(Usuario usuario);
	public void eliminar(int idUsuario);
	public Usuario buscar(int idUsuario);
	public List<Usuario> listar();
}
