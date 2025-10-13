export class Cliente{
    idCliente !: number;
	nombre !: string;
	direccion !: string;
	contacto !: number;

	constructor(){
		this.nombre = ""
		this.direccion = ""
		this.contacto = 0
	}
}