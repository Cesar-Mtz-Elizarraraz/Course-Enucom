export class Proveedor{
    idProveedor !: number;
	nombre !: String;
	telefono !: number;
	email !: String;

	constructor() {
        this.nombre = ''
        this.telefono = 0
		this.email = ''
    }
}