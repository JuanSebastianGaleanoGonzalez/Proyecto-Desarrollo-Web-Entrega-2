import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/not-found/notfound.component';
import { ConductorViewComponent } from './components/conductor/conductor-view/conductor-view.component';
import { TransmilenioViewComponent } from './components/transmilenio/transmilenio-view/transmilenio-view.component';
import { RutaViewComponent } from './components/ruta/ruta-view/ruta-view.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { RutaListComponent } from './components/ruta/ruta-list/ruta-list.component';
import { TransmilenioListComponent } from './components/transmilenio/transmilenio-list/transmilenio-list.component';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ConductorUpdateComponent } from './components/conductor/conductor-update/conductor-update.component';
import { ConductorCreateComponent } from './components/conductor/conductor-create/conductor-create.component';
import { TransmilenioCreateComponent } from './components/transmilenio/transmilenio-create/transmilenio-create.component';
import { TransmilenioUpdateComponent } from './components/transmilenio/transmilenio-update/transmilenio-update.component';
import { RutaUpdateComponent } from './components/ruta/ruta-update/ruta-update.component';
import { RutaCreateComponent } from './components/ruta/ruta-create/ruta-create.component';
import { EstacionListComponent } from './components/estacion/estacion-list/estacion-list.component';
import { ConductorAsignComponent } from './components/conductor/conductor-asign/conductor-asign.component';
import { RutaAsignEstacionComponent } from './components/ruta/ruta-asign-estacion/ruta-asign-estacion.component';
import { RutaAsignTransmilenioComponent } from './components/ruta/ruta-asign-transmilenio/ruta-asign-transmilenio.component';
import { RutaAsignHorarioComponent } from './components/ruta/ruta-asign-horario/ruta-asign-horario.component';
import { TransmilenioAsignConductorComponent } from './components/transmilenio/transmilenio-asign-conductor/transmilenio-asign-conductor.component';
import { TransmilenioAsignRutaComponent } from './components/transmilenio/transmilenio-asign-ruta/transmilenio-asign-ruta.component';


@NgModule({
  declarations: [
    AppComponent,
    ConductorViewComponent,
    TransmilenioViewComponent,
    RutaViewComponent,
    ConductorListComponent,
    HomeComponent,
    NotfoundComponent,
    RutaListComponent,
    TransmilenioListComponent,
    ConductorUpdateComponent,
    ConductorCreateComponent,
    TransmilenioCreateComponent,
    TransmilenioUpdateComponent,
    RutaUpdateComponent,
    RutaCreateComponent,
    EstacionListComponent,
    ConductorAsignComponent,
    RutaAsignEstacionComponent,
    RutaAsignTransmilenioComponent,
    RutaAsignHorarioComponent,
    TransmilenioAsignConductorComponent,
    TransmilenioAsignRutaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
