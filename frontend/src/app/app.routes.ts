import { Routes } from '@angular/router';
import { HomeComponent } from './modules/posts/pages/home/home.component';
import { LoginComponent } from './modules/auth/pages/login/login.component';
import { RegisterComponent } from './modules/auth/pages/register/register.component';
import { AuthLayoutComponent } from './modules/auth/components/auth-layout/auth-layout.component';
import { CreatePostComponent } from './modules/posts/pages/create-post/create-post.component';

export const routes: Routes = [
    {
        path: 'auth',
        component: AuthLayoutComponent,
        children: [
            { path: 'login', component: LoginComponent },
            { path: 'register', component: RegisterComponent },
        ],
    },
    { path: 'posts', component: HomeComponent },
    { path: 'posts/create', component: CreatePostComponent },
    { path: '', redirectTo: 'posts', pathMatch: 'full' },
];
