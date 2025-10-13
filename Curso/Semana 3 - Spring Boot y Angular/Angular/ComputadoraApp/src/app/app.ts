import { Component, signal } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('ComputadoraApp');

  // Constructor para inicializar el router
  constructor(private router: Router){}

  // funciones para navegar a los componentes
  listarC(){
    this.router.navigate(['listarC'])
  }

  guardarC(){
    this.router.navigate(['guardarC'])
  }

  editarC(){
    this.router.navigate(['editarC'])
  }
}
