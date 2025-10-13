package com.mx.Mascotas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Mascotas.Entity.Mascota;

@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {

}
