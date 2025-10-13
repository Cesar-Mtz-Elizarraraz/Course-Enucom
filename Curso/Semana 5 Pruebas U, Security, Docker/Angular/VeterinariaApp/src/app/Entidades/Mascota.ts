import { Cliente } from "./Cliente"
import { Responsable } from "./Responsable"
import { Veterinaria } from "./Veterinaria"

export class Mascota{
    idMascota !: number
	nombre !: string
	raza !: string
	edad !: number
	razonCita !: string
	clienteId !: number
	responsableId !: number
	veterinariaId !: number

    constructor(){
        this.idMascota = 0
        this.nombre = ''
        this.raza = ''
        this.edad = 0
        this.razonCita = ''
        this.clienteId = 0
        this.responsableId = 0
        this.veterinariaId = 0
    }
}

export interface MascotaCliResVet{
    idMascota : number;
	nombre : string;
	raza : string;
	edad : number;
	razonCita : string;
	cliente : Cliente;
	responsable : Responsable;
	veterinariaId : Veterinaria;
}