import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser, faUsers, faUserTie, faBagShopping, faTags, faCircleDollarToSlot } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-home',
  imports: [FontAwesomeModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  faUser = faUser
  faUsers = faUsers
  faUserTie = faUserTie
  faBagShopping = faBagShopping
  faTags = faTags
  faCircleDollarToSlot = faCircleDollarToSlot
}
