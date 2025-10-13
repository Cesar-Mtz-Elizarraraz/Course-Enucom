package com.mx.Clientes.Service;

import java.util.List;

import com.mx.Clientes.Entity.Cliente;

public interface IClienteService {
	public List<Cliente> listar(); 
	public void guardar(Cliente cliente);
	public void editar(Cliente cliente);
	public Cliente buscar(Integer idCliente);
	public void eliminar(Integer idCliente);
}
