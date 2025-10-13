package com.mx.Clientes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Clientes.Entity.Cliente;
import com.mx.Clientes.Repository.IClienteRepository;

@Service
public class ClienteServiceImp implements IClienteService {
	@Autowired
	private IClienteRepository dao;
	
	@Override
	public List<Cliente> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idCliente"));
	}

	@Override
	public void guardar(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	public void editar(Cliente cliente) {
		dao.save(cliente);
		
	}

	@Override
	public Cliente buscar(Integer idCliente) {

		return dao.findById(idCliente).orElse(null);
	}

	@Override
	public void eliminar(Integer idCliente) {
		dao.deleteById(idCliente);
		
	}
	
	public boolean contactoExistente(Long contacto) {
		return dao.existsByContacto(contacto);
	}
	
	public boolean contactoExistenteEditar(Long contacto, Integer idCliente) {
		return dao.existsByContactoAndIdClienteNot(contacto, idCliente);
	}
}
