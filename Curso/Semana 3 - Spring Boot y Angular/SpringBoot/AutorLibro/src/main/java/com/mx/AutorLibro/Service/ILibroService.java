package com.mx.AutorLibro.Service;

import java.util.List;

import com.mx.AutorLibro.Dominio.Libro;

public interface ILibroService {
	public void guardar(Libro libro);
	public void editar(Libro libro);
	public void eliminar(int idLibro);
	public Libro buscar(int idLibro);
	public List<Libro> listar();
}
