package com.mx.service;

import java.util.ArrayList;
import java.util.List;

import com.mx.entidad.Auto;
import com.mx.metodos.MetodosAuto;

public class AutoServicio implements MetodosAuto {
	List<Auto> autos = new ArrayList<Auto>();

	@Override
	public void guardar(Auto auto) {
		// TODO Auto-generated method stub
		for(Auto a: autos) {
			
		}
	}

	@Override
	public void editar(Auto auto, int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscar(int indice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

}
