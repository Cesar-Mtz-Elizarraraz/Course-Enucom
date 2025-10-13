package com.mx.service;

import com.mx.entity.Reloj;

public class RelojService {
	
	Reloj reloj = new Reloj();
	
	public void avanzarSegundo() {
		int segundo = reloj.getSegundo();
		int minuto = reloj.getMinuto();
		int hora = reloj.getHora();
		segundo++;
        if (segundo >= 60) {
            segundo = 0;
            minuto++;
            if (minuto >= 60) {
                minuto = 0;
                hora++;
                if (hora >= 24) {
                    hora = 0;
                }
            }
        }
        reloj.setHora(hora);
        reloj.setMinuto(minuto);
        reloj.setSegundo(segundo);
	}
	
	public String mostrarHora() {
		return String.format("%02d:%02d:%02d", reloj.getHora(), reloj.getMinuto(), reloj.getSegundo());
	}
}
