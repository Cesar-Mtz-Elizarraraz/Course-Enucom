package com.mx.metodos;

import com.mx.entidad.Cliente;
import com.mx.service.CuentaServicio;

public interface MetodosCliente {
	public void guardar(Cliente cliente);
	
	public void editar(Cliente cliente, CuentaServicio cuentaServicio, int indice);
    
    public void eliminar(int indice);
    
    public Cliente buscar(int indice);
    
    public void mostrar();
	
}
