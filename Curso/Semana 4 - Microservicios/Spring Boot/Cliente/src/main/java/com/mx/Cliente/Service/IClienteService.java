package com.mx.Cliente.Service;

import java.util.List;

import com.mx.Cliente.Entity.Cliente;

public interface IClienteService {
	public void guardar(Cliente cliente);
	public void editar(Cliente cliente);
	public void eliminar(int idCliente);
	public Cliente buscar(int idCLiente);
	public List<Cliente> listar();
}
