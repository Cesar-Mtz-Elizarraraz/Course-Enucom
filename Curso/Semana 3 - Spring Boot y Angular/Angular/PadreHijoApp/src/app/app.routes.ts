import { Routes } from '@angular/router';
import { ListarP } from './Componentes/Padre/listar-p/listar-p';
import { GuardarP } from './Componentes/Padre/guardar-p/guardar-p';
import { EditarP } from './Componentes/Padre/editar-p/editar-p';
import { ListarH } from './Componentes/Hijo/listar-h/listar-h';
import { GuardarH } from './Componentes/Hijo/guardar-h/guardar-h';
import { EditarH } from './Componentes/Hijo/editar-h/editar-h';

export const routes: Routes = [
    {path: 'listarP', component: ListarP},
    {path: 'guardarP', component: GuardarP},
    {path: 'editarP', component: EditarP},

    {path: 'listarH', component: ListarH},
    {path: 'guardarH', component: GuardarH},
    {path: 'editarH', component: EditarH},
];
