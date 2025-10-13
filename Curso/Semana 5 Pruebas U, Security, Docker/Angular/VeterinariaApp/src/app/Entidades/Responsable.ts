import { Veterinaria } from "./Veterinaria";

export class Responsable{
    idResponsable !: number;
    nombre!: string;
    contacto!: number;
    veterinariaId!: number;

    constructor(){
        this.nombre = ""
        this.contacto = 0
        this.veterinariaId = 0
    }
}

export interface ResponsableVeterinaria{
    idResponsable: number;
    nombre: string;
    contacto: number;
    veterinaria: Veterinaria;
}