package com.mx.Tarea.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.Tarea.Entity.Tarea;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Integer> {

}
