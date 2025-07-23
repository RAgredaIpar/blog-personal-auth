import { Routes } from '@angular/router';
import { HomeComponent } from './modules/posts/pages/home/home.component';
import { LoginComponent } from './modules/auth/pages/login/login.component';
import { RegisterComponent } from './modules/auth/pages/register/register.component';
import { CreatePostComponent } from './modules/posts/pages/create-post/create-post.component';

export const routes: Routes = [
    { path: '', redirectTo: 'posts', pathMatch: 'full'},
    { path: 'posts', component: HomeComponent },
    { path: 'posts/create', component: CreatePostComponent },
    { path: 'auth/login', component: LoginComponent },
    { path: 'auth/register', component: RegisterComponent },
];
