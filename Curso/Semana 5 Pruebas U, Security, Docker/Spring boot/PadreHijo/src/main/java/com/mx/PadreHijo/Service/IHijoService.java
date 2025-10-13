package com.mx.PadreHijo.Service;

import java.util.List;

import com.mx.PadreHijo.Dominio.Hijo;

public interface IHijoService {
	public void guardar(Hijo hijo);
	public void editar(Hijo hijo);
	public void eliminar(int idHijo);
	public Hijo buscar(int idHijo);
	public List<Hijo> listar();
}
