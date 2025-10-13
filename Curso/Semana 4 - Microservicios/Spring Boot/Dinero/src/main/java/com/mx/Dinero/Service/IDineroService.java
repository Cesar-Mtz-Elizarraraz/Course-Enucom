package com.mx.Dinero.Service;

import java.util.List;

import com.mx.Dinero.Entity.Dinero;

public interface IDineroService {
	public void editarMultiple(List<Dinero> dinero);
	public List<Dinero> listar();
	
}
