export class Cliente{
    idCliente !: number;
	nombre !: String;
	app !: String;
	apm !: String;
	telefono !: number;

	constructor() {
        this.nombre = ''
        this.app = ''
		this.apm = ''
		this.telefono = 0
    }
}