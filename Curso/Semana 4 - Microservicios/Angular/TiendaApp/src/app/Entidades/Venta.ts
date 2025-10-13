import { Cliente } from "./Cliente";
import { Empleado } from "./Empleado";
import { Producto } from "./Producto";

export class Venta {
    idVenta !: number; 
    folio !: string;
    fecha !: string;
    cantidad !: number;
    total !: number;
    metodoPago !: string;
    cliente !: Cliente | null;
    empleado !: Empleado | null;
    producto !: Producto | null;
}

export interface VentaForm {
    idVenta ?: number; 
    folio ?: string;
    fecha ?: string;
    cantidad : number;
    total : number;
    metodoPago : string;
    clienteId ?: number;
    empleadoId ?: number;
    codigoBarras ?: number;
}