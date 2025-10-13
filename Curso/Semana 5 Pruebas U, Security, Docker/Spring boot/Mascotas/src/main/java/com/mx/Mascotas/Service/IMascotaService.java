package com.mx.Mascotas.Service;

import java.util.List;

import com.mx.Mascotas.Entity.Mascota;

public interface IMascotaService {
	public List<Mascota> listar(); 
	public void guardar(Mascota mascota);
	public void editar(Mascota mascota);
	public Mascota buscar(Integer idMascota);
	public void eliminar(Integer idMascota);
}
