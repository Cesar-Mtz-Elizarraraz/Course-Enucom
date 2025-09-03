package com.mx.metodos;

import com.mx.entidad.Empresa;

public interface MetodosEmpresa {
    public void guardar(Empresa empresa);
    
    public void editar(Empresa empresa, int indice);
    
    public void eliminar(int indice);
    
    public Empresa buscar(int indice);
    
    public void mostrar();
}
