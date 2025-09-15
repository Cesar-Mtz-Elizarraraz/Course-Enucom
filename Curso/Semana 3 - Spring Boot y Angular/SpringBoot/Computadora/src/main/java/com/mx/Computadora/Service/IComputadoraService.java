package com.mx.Computadora.Service;

import java.util.List;

import com.mx.Computadora.Dominio.Computadora;

public interface IComputadoraService {

	public void guardar(Computadora computadora);
	public void editar(Computadora computadora);
	public void eliminar(Computadora computadora);
	public Computadora buscar(Computadora computadora);
	public List<Computadora> listar();
}
