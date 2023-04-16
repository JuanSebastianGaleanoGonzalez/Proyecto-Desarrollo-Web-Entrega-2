import { Component, OnInit } from '@angular/core';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-list',
  templateUrl: './ruta-list.component.html',
  styleUrls: ['./ruta-list.component.css']
})
export class RutaListComponent implements OnInit {

  rutas: any;
  constructor(
    private rutaService: RutaService
  ) { }

  ngOnInit(): void {
    this.rutaService.findAll().subscribe(rutas => this.rutas = rutas);
  }
  public eliminarRuta(id: number){
    this.rutaService.delete(id).subscribe(resp => {  
      this.rutas.pop(this.rutaService.findById(id));
    },
      error => console.error(error));
  }
}
