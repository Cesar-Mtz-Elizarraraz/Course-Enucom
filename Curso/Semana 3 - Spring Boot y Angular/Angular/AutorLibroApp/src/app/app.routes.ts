import { Routes } from '@angular/router';
import { ListarA } from './Componentes/Autor/listar-a/listar-a';
import { GuardarA } from './Componentes/Autor/guardar-a/guardar-a';
import { EditarA } from './Componentes/Autor/editar-a/editar-a';
import { ListarL } from './Componentes/Libro/listar-l/listar-l';
import { GuardarL } from './Componentes/Libro/guardar-l/guardar-l';
import { EditarL } from './Componentes/Libro/editar-l/editar-l';

export const routes: Routes = [
    {path: 'listarA', component: ListarA},
    {path: 'guardarA', component: GuardarA},
    {path: 'editarA', component: EditarA},

    {path: 'listarL', component: ListarL},
    {path: 'guardarL', component: GuardarL},
    {path: 'editarL', component: EditarL},
];
