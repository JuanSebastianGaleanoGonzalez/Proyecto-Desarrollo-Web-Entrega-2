import { Component, OnInit } from '@angular/core';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-list',
  templateUrl: './ruta-list.component.html',
  styleUrls: ['./ruta-list.component.css']
})
export class RutaListComponent implements OnInit {

  rutas: Ruta[] = [];
  constructor(
    private rutaService: RutaService
  ) { }

  ngOnInit(): void {
    this.rutaService.findAll().subscribe(rutas => this.rutas = rutas);
  }
}
