import { Routes } from '@angular/router';
import { EditarU } from './Componentes/Usuario/editar-u/editar-u';
import { GuardarU } from './Componentes/Usuario/guardar-u/guardar-u';
import { ListarU } from './Componentes/Usuario/listar-u/listar-u';
import { ListarR } from './Componentes/Rol/listar-r/listar-r';
import { GuardarR } from './Componentes/Rol/guardar-r/guardar-r';
import { EditarR } from './Componentes/Rol/editar-r/editar-r';

export const routes: Routes = [
    {path: 'listarU', component: ListarU},
    {path: 'guardarU', component: GuardarU},
    {path: 'editarU', component: EditarU},

    {path: 'listarR', component: ListarR},
    {path: 'guardarR', component: GuardarR},
    {path: 'editarR', component: EditarR},
];
