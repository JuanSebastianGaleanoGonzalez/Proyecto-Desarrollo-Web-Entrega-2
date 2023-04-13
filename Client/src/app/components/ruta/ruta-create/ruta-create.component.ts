import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Ruta } from 'src/app/model/ruta/ruta';
import { RutaService } from 'src/app/services/ruta/ruta.service';

@Component({
  selector: 'app-ruta-create',
  templateUrl: './ruta-create.component.html',
  styleUrls: ['./ruta-create.component.css']
})
export class RutaCreateComponent  {
  ruta: Ruta = new Ruta();
  rutas: any;
  rutaForm: FormGroup | undefined;
  constructor(private fb: FormBuilder, private rutaService:RutaService, private router:Router) { }

  public guardarRuta(): void {
    this.rutaService.create(this.ruta).subscribe(resp => {
      this.rutaForm?.reset();
      this.router.navigate(['/ruta/list'])
    },
      error => console.error(error));
  }

}