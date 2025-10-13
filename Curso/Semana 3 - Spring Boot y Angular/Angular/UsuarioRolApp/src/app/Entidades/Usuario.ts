import { Rol } from "./Rol";

export class Usuario{
    idUsuario !: number;
	nombre !: String;
	app !: String;
	apm !: String;
	sexo !: String;
	correo !: String;
	fechaNacimiento !: String;
	fechaCreacion !: String;
	rolId !: Rol;
}