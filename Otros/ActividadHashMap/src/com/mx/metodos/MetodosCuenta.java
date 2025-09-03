package com.mx.metodos;

import com.mx.entidad.Cuenta;

public interface MetodosCuenta {
	public void guardar(Cuenta cuenta);
	
	public void editar(Cuenta cuenta);
	
	public void eliminar(Cuenta cuenta);
	
	public Cuenta buscar(Cuenta cuenta);
	
	public void mostrar();
}
