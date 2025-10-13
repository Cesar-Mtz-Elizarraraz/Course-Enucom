import { Autor } from "./Autor";

export class Libro{
    idLibro !: number;
	titulo !: String;
	genero !: String;
	anioPublicacion !: number;
	precio !: number;
	autorId !: Autor;
}