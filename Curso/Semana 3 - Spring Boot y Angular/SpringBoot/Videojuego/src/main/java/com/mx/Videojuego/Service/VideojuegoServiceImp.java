package com.mx.Videojuego.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.Videojuego.Dao.IVideojuegoDao;
import com.mx.Videojuego.Dominio.Videojuego;

@Service
public class VideojuegoServiceImp implements IVideojuegoService {
	@Autowired
	private IVideojuegoDao dao;
	

	@Override
	public void guardar(Videojuego videojuego) {
		System.out.println(videojuego);
		dao.save(videojuego);
		
	}

	@Override
	public void editar(Videojuego videojuego) {
		dao.save(videojuego);
		
	}

	@Override
	public void eliminar(Videojuego videojuego) {
		dao.delete(videojuego);
		
	}

	@Override
	public Videojuego buscar(Videojuego videojuego) {
		
		return dao.findById(videojuego.getIdVideojuego()).orElse(null);
	}

	@Override
	public List<Videojuego> listar() {
		
		return (List<Videojuego>) dao.findAll();
	}

}
