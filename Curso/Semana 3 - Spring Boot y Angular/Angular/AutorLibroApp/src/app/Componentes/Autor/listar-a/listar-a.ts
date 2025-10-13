import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceWS } from '../../../Service/service-ws';
import { Autor } from '../../../Entidades/Autor';

@Component({
  selector: 'app-listar-a',
  imports: [],
  templateUrl: './listar-a.html',
  styleUrl: './listar-a.css'
})
export class ListarA implements OnInit{
  constructor(private router: Router, private service: ServiceWS){}

  autor: Autor = new Autor()
  autores !: Autor[]
  
  ngOnInit(): void {
    this.listarAutor()
  }

  listarAutor(){
    this.service.listarAWS().subscribe(data => {
      this.autores = data;
    })
  }

  editarButton(autor: Autor) {
    localStorage.setItem('autor', JSON.stringify(autor));
    console.log(localStorage)
    this.router.navigate(['editarA'])
  }
  eliminarButton(autor: Autor) {
    
  }

}
