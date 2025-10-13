package com.mx.PadreHijo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mx.PadreHijo.Dao.IPadreDao;
import com.mx.PadreHijo.Dominio.Padre;

@Service
public class PadreServiceImp implements IPadreService {
	@Autowired
	private IPadreDao dao;
	
	
	@Override
	public void guardar(Padre padre) {
		dao.save(padre);
		
	}

	@Override
	public void editar(Padre padre) {
		dao.save(padre);
		
	}

	@Override
	public void eliminar(int idPadre) {
		dao.deleteById(idPadre);
		
	}

	@Override
	public Padre buscar(int idPadre) {
		
		return dao.findById(idPadre).orElse(null);
	}

	@Override
	public List<Padre> listar() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idPadre"));
	}

}
