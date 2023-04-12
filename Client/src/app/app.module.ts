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
import { ReactiveFormsModule } from '@angular/forms';
import { ConductorUpdateComponent } from './components/conductor/conductor-update/conductor-update.component';
import { ConductorCreateComponent } from './components/conductor/conductor-create/conductor-create.component';
import { TransmilenioCreateComponent } from './components/transmilenio/transmilenio-create/transmilenio-create.component';
import { TransmilenioUpdateComponent } from './components/transmilenio/transmilenio-update/transmilenio-update.component';
import { RutaUpdateComponent } from './components/ruta/ruta-update/ruta-update.component';
import { RutaCreateComponent } from './components/ruta/ruta-create/ruta-create.component';
import { EstacionListComponent } from './components/estacion/estacion-list/estacion-list.component';


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
    EstacionListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
