import { Routes } from '@angular/router';
import { ListarCompu } from './Componente/listar-compu/listar-compu';
import { GuardarCompu } from './Componente/guardar-compu/guardar-compu';
import { EditarCompu } from './Componente/editar-compu/editar-compu';

export const routes: Routes = [
    {path: 'listarC', component: ListarCompu},
    {path: 'guardarC', component: GuardarCompu},
    {path: 'editarC', component: EditarCompu}
];
