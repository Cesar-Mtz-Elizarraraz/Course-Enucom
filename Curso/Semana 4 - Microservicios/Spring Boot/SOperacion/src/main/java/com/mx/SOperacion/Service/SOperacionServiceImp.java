package com.mx.SOperacion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.SOperacion.Entity.SOperacion;
import com.mx.SOperacion.Repository.ISOperacionRepository;

@Service
public class SOperacionServiceImp implements ISOperacionService{
	@Autowired
	private ISOperacionRepository dao;

	@Override
	public void guardar(SOperacion sOperacion) {
		dao.save(sOperacion);
		
	}

	@Override
	public List<SOperacion> listar() {
		
		return dao.findAll();
	}
}
