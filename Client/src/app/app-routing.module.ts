import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/not-found/notfound.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { RutaListComponent } from './components/ruta/ruta-list/ruta-list.component';
import { TransmilenioListComponent } from './components/transmilenio/transmilenio-list/transmilenio-list.component';
import { ConductorViewComponent } from './components/conductor/conductor-view/conductor-view.component';
import { ConductorUpdateComponent } from './components/conductor/conductor-update/conductor-update.component';
import { ConductorCreateComponent } from './components/conductor/conductor-create/conductor-create.component';
import { TransmilenioViewComponent } from './components/transmilenio/transmilenio-view/transmilenio-view.component';
const routes:Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'conductor/list', component: ConductorListComponent },
  { path: 'conductor/view/:id', component: ConductorViewComponent },
  { path: 'conductor/update/:id', component: ConductorUpdateComponent },
  { path: 'conductor/list/create', component: ConductorCreateComponent },
  { path: 'ruta/list', component: RutaListComponent },
  { path: 'transmilenio/list', component: TransmilenioListComponent },
  { path: 'transmilenio/view/:id', component: TransmilenioViewComponent },
  { path: '**', component: NotfoundComponent}
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }