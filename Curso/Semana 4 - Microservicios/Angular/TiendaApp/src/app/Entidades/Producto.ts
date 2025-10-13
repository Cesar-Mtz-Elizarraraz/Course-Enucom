import { Categoria } from "./Categoria";
import { Proveedor } from "./Proveedor";

export class Producto {
    codigoBarras !: number; 
	nombre !: string;
	precio !: number;
	stock !: number;
	descuento !: number;
	categoria !: Categoria | undefined;
	proveedor !: Proveedor | undefined;

	constructor() {
		this.codigoBarras = 0
        this.nombre = ''
        this.precio = 0
		this.stock = 0
		this.descuento = 0
    }
}

export interface ProductoForm {
    codigoBarras: number; 
	nombre: string;
	precio: number;
	stock: number;
	descuento: number;
	categoriaId?: number;
	proveedorId?: number;
}