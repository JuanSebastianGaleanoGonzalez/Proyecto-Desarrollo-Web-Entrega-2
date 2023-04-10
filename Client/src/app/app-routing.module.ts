import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/not-found/notfound.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { RutaListComponent } from './components/ruta/ruta-list/ruta-list.component';
import { TransmilenioListComponent } from './components/transmilenio/transmilenio-list/transmilenio-list.component';
const routes:Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: '**', component: NotfoundComponent},
  { path: 'conductor/list', component: ConductorListComponent },
  { path: 'ruta/list', component: RutaListComponent },
  { path: 'transmilenio/list', component: TransmilenioListComponent },

]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
