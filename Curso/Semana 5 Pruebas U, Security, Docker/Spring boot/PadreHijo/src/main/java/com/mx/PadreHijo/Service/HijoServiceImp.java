package com.mx.PadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.PadreHijo.Dao.IHijoDao;
import com.mx.PadreHijo.Dominio.Hijo;

@Service
public class HijoServiceImp implements IHijoService {
	
	@Autowired
	private IHijoDao dao;

	@Override
	public void guardar(Hijo hijo) {
		dao.save(hijo);
		
	}

	@Override
	public void editar(Hijo hijo) {
		dao.save(hijo);
		
	}

	@Override
	public void eliminar(int idHijo) {
		dao.deleteById(idHijo);
		
	}

	@Override
	public Hijo buscar(int idHijo) {
		
		return dao.findById(idHijo).orElse(null);
	}

	@Override
	public List<Hijo> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idHijo"));
	}

}
