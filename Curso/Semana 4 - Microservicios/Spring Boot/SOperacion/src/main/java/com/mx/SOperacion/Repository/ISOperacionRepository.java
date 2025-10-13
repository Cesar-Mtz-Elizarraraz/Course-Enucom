package com.mx.SOperacion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.SOperacion.Entity.SOperacion;

public interface ISOperacionRepository extends JpaRepository<SOperacion, Integer> {

}
