import { Routes } from '@angular/router';
import { ListarCli } from './Componentes/Cliente/listar-cli/listar-cli';
import { Home } from './Componentes/home/home';
import { ListarV } from './Componentes/Veterinaria/listar-v/listar-v';
import { ListarR } from './Componentes/Responsable/listar-r/listar-r';
import { NotFound } from './Componentes/not-found/not-found';
import { ListarM } from './Componentes/Mascota/listar-m/listar-m';

export const routes: Routes = [
    {path: 'home', component: Home},
    {path: 'cliente', component: ListarCli},
    {path: 'veterinaria', component: ListarV},
    {path: 'responsable', component: ListarR},
    {path: 'mascota', component: ListarM},
    {path: '**', component: NotFound}
];
