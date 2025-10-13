package com.mx.Dinero.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.Dinero.Entity.Dinero;
import com.mx.Dinero.Repository.IDineroRepository;

@Service
public class DineroServiceImp implements IDineroService{

	@Autowired
	private IDineroRepository dao;

	@Override
	public void editarMultiple(List<Dinero> dinero) {
		dao.saveAll(dinero);
	}

	@Override
	public List<Dinero> listar() {

		return dao.findAll(Sort.by(Sort.Direction.DESC, "denominacion"));
	}
	
	public BigDecimal obtenerFondos() {
		return dao.obtenerFondos();
	}
	
	public  List<Dinero> obtenerDenominacionesDisponibles() {
		return dao.obtenerDenominacionesDisponibles();
	}

}
