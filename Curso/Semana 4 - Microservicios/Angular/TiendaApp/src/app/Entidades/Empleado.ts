export class Empleado {
    idEmpleado !: number;
	nombre !: String;
	apellido !: String;
	telefono !: number;
	puesto !: String;

	constructor() {
        this.nombre = ''
        this.apellido = ''
		this.telefono = 0
		this.puesto = ''
    }
}