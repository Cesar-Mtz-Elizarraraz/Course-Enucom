package com.mx.ProcesarCliente.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.ProcesarCliente.Entity.*;
import com.mx.ProcesarCliente.Repository.IProcesarClienteRepository;

@Service
public class ProcesarClienteServiceImp implements IProcesarClienteService {

	@Autowired
	private IProcesarClienteRepository dao;
	
	@Override
	public void ProcesarCliente(Cliente cliente) {
		dao.save(cliente);
		
	}
	
	public boolean clienteExistente(Long idClienteDigital) {
		return dao.existsById(idClienteDigital);
	}
	
	public boolean curpExistente(String curp) {
		return dao.existsByCurp(curp);
	}
	
	public List<Cliente> listarClientes(){
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idClienteDigital"));
	}
	
	public List<Beneficiario> listarBeneficiarios(){
		return dao.listarBeneficiarios();
	}
	
	public List<Contacto> listarContactos(){
		return dao.listarContactos();
	}
	
	public List<Contrato> listarContratos(){
		return dao.listarContratos();
	}
	
	public List<Documentacion> listarDocumentacion(){
		return dao.listarDocumentacion();
	}
	
	public List<Domicilio> listarDomicilios(){
		return dao.listarDomicilios();
	}
	
	public List<Producto> listarProductos(){
		return dao.listarProductos();
	}
}
