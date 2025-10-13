package com.mx.Cliente.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Cliente.Entity.Cliente;
import com.mx.Cliente.Repository.IClienteRepository;

@Service
public class ClienteServiceImp implements IClienteService {
	@Autowired
	private IClienteRepository dao;

	@Override
	public void guardar(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	public void editar(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	public void eliminar(int idCliente) {
		dao.deleteById(idCliente);
		
	}

	@Override
	public Cliente buscar(int idCliente) {
		
		return dao.findById(idCliente).orElse(null);
	}

	@Override
	public List<Cliente> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idCliente"));
	}
}
