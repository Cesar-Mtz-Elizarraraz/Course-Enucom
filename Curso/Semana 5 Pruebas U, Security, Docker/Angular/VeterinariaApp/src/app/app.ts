import { Component, signal } from '@angular/core';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { FaIconLibrary, FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faDog, faHouse, faHouseMedical, faUser, faUserDoctor, faCopyright, faShieldDog, faBars, faHashtag, faCheck, faArrowRight, faTrashCan, faPen, faPlus } from '@fortawesome/free-solid-svg-icons';
import { filter } from 'rxjs';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FontAwesomeModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

  constructor(private router: Router, library: FaIconLibrary){
    library.addIcons(faDog, faHouse, faHouseMedical, faUser, faUserDoctor, faCopyright, faShieldDog, faBars, faHashtag, faCheck, faArrowRight, faTrashCan, faPen, faPlus);
  }
  
  protected readonly title = signal('VeterinariaApp');

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
        case "vVeterinaria":
          if (currentView == "/veterinaria") this.setActive(link);
          break;
        case "vCliente":
          if (currentView == "/cliente") this.setActive(link);
          break;
        case "vResponsable":
          if (currentView == "/responsable") this.setActive(link);
          break;
        case "vMascota":
          if (currentView == "/mascota") this.setActive(link);
          break;
      }
    });
  }

  setActive(link: Element) {
    link.classList.add("bg-main-active", "fw-medium");
    link.classList.remove("link-opacity-50-hover");
  }

  faDog = faDog
  faHouse = faHouse
  faHouseMedical = faHouseMedical
  faUser = faUser
  faUserDoctor = faUserDoctor
  faCopyright = faCopyright
  faShieldDog = faShieldDog
  faBars = faBars
}
