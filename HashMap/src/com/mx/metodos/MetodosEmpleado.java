package com.mx.metodos;

import com.mx.entidad.Empleado;

public interface MetodosEmpleado {
    public void guardar(Empleado empleado);
    
    public void editar(Empleado empleado);
    
    public void eliminar(Empleado empleado);
    
    public Empleado buscar(Empleado empleado);
    
    public void mostrar();
}
