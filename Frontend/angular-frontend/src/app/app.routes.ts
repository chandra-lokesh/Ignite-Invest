import { Routes } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { PageHomeComponent } from './page-home/page-home.component';
import { PageLoginComponent } from './page-login/page-login.component';


export const routes: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    {path: 'home', component: PageHomeComponent},
    {path: 'signup', component: SignupComponent},
    {path: 'login', component: PageLoginComponent},
];
