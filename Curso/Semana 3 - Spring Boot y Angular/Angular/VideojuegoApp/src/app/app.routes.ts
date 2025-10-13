import { Routes } from '@angular/router';
import { ListarVJuego } from './Componente/listar-vjuego/listar-vjuego';
import { GuardarVJuego } from './Componente/guardar-vjuego/guardar-vjuego';
import { EditarVJuego } from './Componente/editar-vjuego/editar-vjuego';

export const routes: Routes = [
    {path: 'listarVJ', component: ListarVJuego},
    {path: 'guardarVJ', component: GuardarVJuego},
    {path: 'editarVJ', component: EditarVJuego}
];
