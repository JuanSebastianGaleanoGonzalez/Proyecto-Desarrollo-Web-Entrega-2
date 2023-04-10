import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NotfoundComponent } from './components/not-found/notfound.component';
import { ConductorViewComponent } from './components/conductor/conductor-view/conductor-view.component';
import { TransmilenioViewComponent } from './components/transmilenio/transmilenio-view/transmilenio-view.component';
import { RutaViewComponent } from './components/ruta/ruta-view/ruta-view.component';
import { EstacionViewComponent } from './components/estacion/estacion-view/estacion-view.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { RutaListComponent } from './components/ruta/ruta-list/ruta-list.component';
import { TransmilenioListComponent } from './components/transmilenio/transmilenio-list/transmilenio-list.component';
import { ReactiveFormsModule } from '@angular/forms';
import { ConductorUpdateComponent } from './components/conductor/conductor-update/conductor-update.component';


@NgModule({
  declarations: [
    AppComponent,
    ConductorViewComponent,
    TransmilenioViewComponent,
    RutaViewComponent,
    EstacionViewComponent,
    ConductorListComponent,
    HomeComponent,
    NotfoundComponent,
    RutaListComponent,
    TransmilenioListComponent,
    ConductorUpdateComponent
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
