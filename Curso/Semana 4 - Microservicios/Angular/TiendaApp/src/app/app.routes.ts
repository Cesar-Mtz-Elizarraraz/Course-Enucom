import { Routes } from '@angular/router';
import { Home } from './Componentes/home/home';
import { ListarP } from './Componentes/Proveedor/listar-p/listar-p';
import { ListarP as ListarProd } from './Componentes/Producto/listar-p/listar-p';
import { ListarC } from './Componentes/Categoria/listar-c/listar-c';
import { ListarE } from './Componentes/Empleado/listar-e/listar-e';
import { ListarCli } from './Componentes/Cliente/listar-cli/listar-cli';
import { NotFound } from './Componentes/not-found/not-found';
import { ListarV } from './Componentes/Venta/listar-v/listar-v';
import { GuardarV } from './Componentes/Venta/guardar-v/guardar-v';

export const routes: Routes = [
    {path: 'home', component: Home},
    {path: 'proveedor', component: ListarP},
    {path: 'categoria', component: ListarC},
    {path: 'empleado', component: ListarE},
    {path: 'cliente', component: ListarCli},
    {path: 'producto', component: ListarProd},
    {path: 'venta', component: ListarV},
    {path: 'guardarVenta', component: GuardarV},
    {path: '**', component: NotFound} // RUTA DE COMODÍN [404 NOT FOUND]
];
