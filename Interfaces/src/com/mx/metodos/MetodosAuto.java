package com.mx.metodos;

import com.mx.entidad.Auto;

//La interfaz es una plantilla de metodos vacios o sin funcionabilidad que pueden ser implementados por cualquier
//clase dentro del proyecto, la clase que las implemente tiene la obligacion de darle funcionabilidad
//a los metodos vacios de la interfaz
public interface MetodosAuto {
    public void guardar(Auto auto);
    
    public void editar(Auto auto, int indice);
    
    public void eliminar(int indice);
    
    public Auto buscar(int indice);
    
    public void mostrar();
}
