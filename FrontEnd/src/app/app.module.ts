import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ConductorViewComponent } from './components/conductor/conductor-view/conductor-view.component';
import { TransmilenioViewComponent } from './components/transmilenio/transmilenio-view/transmilenio-view.component';
import { RutaViewComponent } from './components/ruta/ruta-view/ruta-view.component';
import { EstacionViewComponent } from './components/estacion/estacion-view/estacion-view.component';
import { ConductorListComponent } from './components/conductor/conductor-list/conductor-list.component';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    ConductorViewComponent,
    TransmilenioViewComponent,
    RutaViewComponent,
    EstacionViewComponent,
    ConductorListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
