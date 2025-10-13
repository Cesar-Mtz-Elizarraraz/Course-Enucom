package com.mx.PadreHijo.Service;

import java.util.List;

import com.mx.PadreHijo.Dominio.Padre;

public interface IPadreService {
	public void guardar(Padre padre);
	public void editar(Padre padre);
	public void eliminar(int idPadre);
	public Padre buscar(int idPadre);
	public List<Padre> listar();
}
