package com.mx.SOperacion.Service;

import java.util.List;

import com.mx.SOperacion.Entity.SOperacion;

public interface ISOperacionService {
	public void guardar(SOperacion sOperacion);
	public List<SOperacion> listar();
}
