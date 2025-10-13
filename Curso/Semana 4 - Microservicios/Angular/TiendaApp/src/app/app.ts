import { Component, OnInit, signal } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser, faUsers, faUserTie, faBagShopping, faTags, faCircleDollarToSlot, faHome, faStore } from '@fortawesome/free-solid-svg-icons';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FontAwesomeModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {

  constructor(private router: Router){}
  
  protected readonly title = signal('TiendaApp');
  ngOnInit(): void {

    // Obtener la ultima parte de la URL
    this.router.events
      // Filtra los eventos del router para obtener solo cuando la navegación termina
      .pipe(filter(event => event instanceof NavigationEnd)) // Filter es un operador que deja pasar solo los eventos que cumplan la condición
      // Se suscribe al evento filtrado y NavigationEnd ocurre cuando la navegación se completó exitosamente y la url fue actualizada
      .subscribe((event: NavigationEnd) => {
        this.modMenu(event.url);
    });
  }

  modMenu(currentView: string){
    ["/", ""].includes(currentView) && this.router.navigate(['home'])
    // Obtiene todos los elementos <a> con clase nav-link
    const links = document.querySelectorAll('a.nav-link')

    // Recorrer con forEach
    links.forEach((link, index) => {
      link.classList.remove("active")
      link.classList.add("link-secondary")
      switch(link.id) {
        case "vHome":
          if (currentView == "/home") this.setActive(link);
          break;
        case "vProveedor":
          if (currentView == "/proveedor") this.setActive(link);
          break;
        case "vProducto":
          if (currentView == "/producto") this.setActive(link);
          break;
        case "vEmpleado":
          if (currentView == "/empleado") this.setActive(link);
          break;
        case "vCliente":
          if (currentView == "/cliente") this.setActive(link);
          break;
        case "vCategoria":
          if (currentView == "/categoria") this.setActive(link);
          break;
        case "vVenta":
          if (currentView == "/venta" || currentView == "/guardarVenta") this.setActive(link);
          break;
      }
    });
  }

  setActive(link: Element) {
    link.classList.add("active");
    link.classList.remove("link-secondary");
  }

  faStore = faStore
  faHome = faHome
  faUser = faUser
  faUsers = faUsers
  faUserTie = faUserTie
  faBagShopping = faBagShopping
  faTags = faTags
  faCircleDollarToSlot = faCircleDollarToSlot
}
