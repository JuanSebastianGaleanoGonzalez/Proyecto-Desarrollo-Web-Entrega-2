import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/not-found/notfound.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { ConductorViewComponent } from './components/conductor/conductor-view/conductor-view.component';
import { ConductorUpdateComponent } from './components/conductor/conductor-update/conductor-update.component';
import { ConductorCreateComponent } from './components/conductor/conductor-create/conductor-create.component';
import { ConductorAsignComponent } from './components/conductor/conductor-asign/conductor-asign.component';
import { RutaListComponent } from './components/ruta/ruta-list/ruta-list.component';
import { RutaViewComponent } from './components/ruta/ruta-view/ruta-view.component';
import { RutaUpdateComponent } from './components/ruta/ruta-update/ruta-update.component';
import { RutaCreateComponent } from './components/ruta/ruta-create/ruta-create.component';
import { TransmilenioListComponent } from './components/transmilenio/transmilenio-list/transmilenio-list.component';
import { TransmilenioViewComponent } from './components/transmilenio/transmilenio-view/transmilenio-view.component';
import { TransmilenioCreateComponent } from './components/transmilenio/transmilenio-create/transmilenio-create.component';
import { TransmilenioUpdateComponent } from './components/transmilenio/transmilenio-update/transmilenio-update.component';
import { EstacionListComponent } from './components/estacion/estacion-list/estacion-list.component';
import { RutaAsignEstacionComponent } from './components/ruta/ruta-asign-estacion/ruta-asign-estacion.component';
import { RutaAsignTransmilenioComponent } from './components/ruta/ruta-asign-transmilenio/ruta-asign-transmilenio.component';
import { RutaAsignHorarioComponent } from './components/ruta/ruta-asign-horario/ruta-asign-horario.component';
import { TransmilenioAsignConductorComponent } from './components/transmilenio/transmilenio-asign-conductor/transmilenio-asign-conductor.component';
import { TransmilenioAsignRutaComponent } from './components/transmilenio/transmilenio-asign-ruta/transmilenio-asign-ruta.component';

const routes:Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', pathMatch: 'full', redirectTo: '/home' },
  { path: 'conductor/list', component: ConductorListComponent },
  { path: 'conductor/view/:id', component: ConductorViewComponent },
  { path: 'conductor/update/:id', component: ConductorUpdateComponent },
  { path: 'conductor/list/create', component: ConductorCreateComponent },
  { path: 'conductor/asign/:id', component: ConductorAsignComponent },
  { path: 'ruta/list', component: RutaListComponent },
  { path: 'ruta/view/:id', component: RutaViewComponent },
  { path: 'ruta/update/:id', component: RutaUpdateComponent },
  { path: 'ruta/list/create', component: RutaCreateComponent },
  { path: 'estacion/list', component: EstacionListComponent },
  { path: 'ruta/asign/estacion/:id', component: RutaAsignEstacionComponent},
  { path: 'ruta/asign/transmilenio/:id', component: RutaAsignTransmilenioComponent},
  { path: 'ruta/asign/horario/:id', component: RutaAsignHorarioComponent},
  { path: 'transmilenio/list', component: TransmilenioListComponent },
  { path: 'transmilenio/view/:id', component: TransmilenioViewComponent },
  { path: 'transmilenio/list/create', component: TransmilenioCreateComponent },
  { path: 'transmilenio/update/:id', component: TransmilenioUpdateComponent },
  { path: 'transmilenio/asign/conductor/:id', component: TransmilenioAsignConductorComponent},
  { path: 'transmilenio/asign/ruta/:id', component: TransmilenioAsignRutaComponent},
  { path: '**', component: NotfoundComponent}
]; 

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }