package com.mx.AutorLibro.Service;

import java.util.List;

import com.mx.AutorLibro.Dominio.Autor;

public interface IAutorService {
	public void guardar(Autor autor);
	public void editar(Autor autor);
	public void eliminar(int idAutor);
	public Autor buscar(int idAutor);
	public List<Autor> listar();
}
