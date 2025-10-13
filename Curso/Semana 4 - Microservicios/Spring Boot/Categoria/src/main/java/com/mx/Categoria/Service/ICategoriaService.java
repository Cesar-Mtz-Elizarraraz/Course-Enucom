package com.mx.Categoria.Service;

import java.util.List;

import com.mx.Categoria.Entity.Categoria;

public interface ICategoriaService {
	public void guardar(Categoria categoria);
	public void editar(Categoria categoria);
	public void eliminar(int idCategoria);
	public Categoria buscar(int idCategoria);
	public List<Categoria> listar();
}
