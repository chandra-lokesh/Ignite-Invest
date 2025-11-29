import { Component } from '@angular/core';
import { LandingComponent } from '../landing/landing.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { FooterComponent } from '../footer/footer.component';

@Component({
  selector: 'app-page-home',
  imports: [LandingComponent,NavbarComponent, FooterComponent],
  templateUrl: './page-home.component.html',
  styleUrl: './page-home.component.scss'
})
export class PageHomeComponent {

}
